# ORM (Object Relational Mapping)
This is a demo project that demonstrates the implementation of ORM concept in Java Spring boot framework.
# Description
ORM is a technique that lets you query and manipulate data from a database using an object-oriented paradigm. When talking about ORM, most people are referring to a library that implements the Object-Relational Mapping technique, hence the phrase "an ORM". In ORM, database table, relations and query are managed from coding side dynamically rather than manually creating the tables and relations. 

In this demonstration, ORM is used in java spring boot, a complex join query is made and the response is stored as a java object.
# Code
* Entity.

  Here `tbl_billinfo` and  `tbl_SNDList` is related as many to one where as one **snd** my occur many times in **bill info**.

```
  @Entity
@Table(name="tbl_SNDList")
public class SNDList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique=true, name = "snd_id")
	private Integer sndId;
	private String sNDName;
	private Integer computerCenterId;
	private Integer displayOrder;
	@OneToMany(targetEntity = BillInfoEntity.class, mappedBy = "sndList", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<BillInfoEntity> billInfoEntities;
```
```
@Entity
@Table(name="tbl_billinfo")
public class BillInfoEntity {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private String account_No;
	  private String name;
	  private String address;
	  private String metter_No;
	  @Column(name = "bill_No",unique=true) 	  
	  private String billNo;
	  private String consumer_No;
	  private Double bill_Amount;
	  private Double total_BillAmount;
	  private Double vat_Amount;
	  private Double LPC_Amount;
	  private String payment_Status;
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  private Date due_Date;
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  private Date collection_Date;
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "snd_id", insertable = false, updatable = false, referencedColumnName="snd_id")
	  @Fetch(FetchMode.JOIN)
	  private SNDList sndList;
```
For better understranding of FetchMode, go through the link
https://solidsyntax.be/2013/10/17/fetching-collections-hibernate/


* Repository

  In this part a repository is made.
  ```
  @Repository
  public interface BillInfoRepo extends JpaRepository<BillInfoEntity, Long> {
      @Query("SELECT new orm_practice.practice.dto.BillInfoSdnJoinDto(bi.billNo, bi.collection_Date, bi.Bank_Txn_Id, bi.client_txn_Id, " +
              "bi.total_BillAmount, bi.Principal_Amount, bi.vat_Amount, bi.LPC_Amount, bi.Rev_StampAmount, bi.Net_PrincipalAmount, sl.sndId, " +
              "sl.sNDName, sl.displayOrder) FROM BillInfoEntity bi JOIN bi.sndList sl where bi.payment_Status = 'PAID'" +
              "group by sl.sndId, bi.billNo,bi.collection_Date,bi.Bank_Txn_Id,bi.client_txn_Id,bi.total_BillAmount,bi.Principal_Amount," +
              "sl.displayOrder,sl.sNDName order by sl.displayOrder asc")
      List<BillInfoSdnJoinDto> fetchBillInfoSDNJoin();
  ```
  Here a join query is made mentioning the entity rather than mentioning the actual table name. A pojo class is created that has the exact number of fields with the same name as the response of the query. In this query, all the data that are returned will be stored in *List<BillInfoSdnJoinDto>* object as it returns a list of *BillInfoSdnJoinDto* type data.

  DONE ! 
  Now let's see the output.
  
# Output
  I've made an api with the endpoint of `localhost:8082/api/getData` to see the result.
  
  ![orm getData](https://user-images.githubusercontent.com/30841228/148640067-0f012147-a9a2-4ade-9521-8089d11bf166.JPG)

# JPA Projection
Jpa projection is used for getting custom columns from a raw query (*native query*) in jpa and store them into objects.
First we need to create an interface that has exact name and number of fields that are in the query. For example if the query is *select fname, lname, age, gender from person*
then the corresponding interface's methids should be, getFname, getLname, getAge, getGender.
	
```
	@Query(value = "select bi.bill_no,cast(bi.collection_date as date) collection_date,bi.bank_txn_id," +
            "bi.client_txn_id,bi.total_bill_amount Total_billAmount,bi.principal_amount,bi.vat_amount,bi.lpc_amount, " +
            "bi.rev_stamp_amount Rev_stampAmount ,bi.net_principal_Amount Net_principalAmount,bi.snd_id,sl.sndname,sl.display_order " +
            "from tbl_billinfo bi " +
            "join tbl_sndlist sl on sl.snd_id=bi.snd_id " +
            "where payment_status='PAID' " +
            "group by bi.snd_id, bi.bill_no,bi.collection_date, " +
            "bi.bank_txn_id,bi.client_txn_id,bi.total_bill_amount,bi.principal_amount,bi.vat_amount,bi.lpc_amount, " +
            "bi.rev_stamp_amount,bi.net_principal_Amount,sl.display_order,sl.sndname " +
            "order by sl.display_order asc", nativeQuery = true)
         List<JpaProjection> billInfoWithProjection();
```
	
This is the native query written into the `BillInfoRepo` repository. An interface `JpaProjection` is implemented.
	
```
	public interface JpaProjection {
		public String getBill_no();
		public Date getCollection_date();
		public String getBank_txn_id();
		public String getClient_txn_id();
		public Double getTotal_billAmount();
		public Double getPrincipal_Amount();
		public Double getVat_amount();
		public Double getLpc_amount();
		public Double getRev_stampAmount();
		public Double getNet_principalAmount();
		public Integer getSnd_id();
		public String getSndname();
		public Integer getDisplay_order();
	}

```

  DONE ! 
  Now let's see the output.
# Output
	
 Now I've created a seperate endpoint `http://localhost:8082/api/projection` just to get value from Jpa projection process. 
	

![projection](https://user-images.githubusercontent.com/30841228/148671959-09c31dd2-5948-4f56-92de-804cd3af5252.JPG)

**Don't forget to give me a star!**
