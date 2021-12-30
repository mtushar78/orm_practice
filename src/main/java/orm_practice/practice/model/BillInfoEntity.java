package orm_practice.practice.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


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
	  
	  private String Instrument_Code;
	  
	  private String Instrumnet_No;
	  
	  private Double Rev_StampAmount;
	  
	  private String Bank_Txn_Id;
	  
	  private String Nesco_Txn_Id;
	  
	  private Double Principal_Amount;
	  
	  private Double Net_PrincipalAmount;

	public BillInfoEntity() {
	}

	public BillInfoEntity(String account_No, String name, String address, String metter_No, String billNo, String consumer_No, Double bill_Amount, Double total_BillAmount, Double vat_Amount, Double LPC_Amount, String payment_Status, Date due_Date, Date collection_Date, SNDList sndList, String instrument_Code, String instrumnet_No, Double rev_StampAmount, String bank_Txn_Id, String nesco_Txn_Id, Double principal_Amount, Double net_PrincipalAmount) {
		this.account_No = account_No;
		this.name = name;
		this.address = address;
		this.metter_No = metter_No;
		this.billNo = billNo;
		this.consumer_No = consumer_No;
		this.bill_Amount = bill_Amount;
		this.total_BillAmount = total_BillAmount;
		this.vat_Amount = vat_Amount;
		this.LPC_Amount = LPC_Amount;
		this.payment_Status = payment_Status;
		this.due_Date = due_Date;
		this.collection_Date = collection_Date;
		this.sndList = sndList;
		Instrument_Code = instrument_Code;
		Instrumnet_No = instrumnet_No;
		Rev_StampAmount = rev_StampAmount;
		Bank_Txn_Id = bank_Txn_Id;
		Nesco_Txn_Id = nesco_Txn_Id;
		Principal_Amount = principal_Amount;
		Net_PrincipalAmount = net_PrincipalAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount_No() {
		return account_No;
	}

	public void setAccount_No(String account_No) {
		this.account_No = account_No;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMetter_No() {
		return metter_No;
	}

	public void setMetter_No(String metter_No) {
		this.metter_No = metter_No;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getConsumer_No() {
		return consumer_No;
	}

	public void setConsumer_No(String consumer_No) {
		this.consumer_No = consumer_No;
	}

	public Double getBill_Amount() {
		return bill_Amount;
	}

	public void setBill_Amount(Double bill_Amount) {
		this.bill_Amount = bill_Amount;
	}

	public Double getTotal_BillAmount() {
		return total_BillAmount;
	}

	public void setTotal_BillAmount(Double total_BillAmount) {
		this.total_BillAmount = total_BillAmount;
	}

	public Double getVat_Amount() {
		return vat_Amount;
	}

	public void setVat_Amount(Double vat_Amount) {
		this.vat_Amount = vat_Amount;
	}

	public Double getLPC_Amount() {
		return LPC_Amount;
	}

	public void setLPC_Amount(Double LPC_Amount) {
		this.LPC_Amount = LPC_Amount;
	}

	public String getPayment_Status() {
		return payment_Status;
	}

	public void setPayment_Status(String payment_Status) {
		this.payment_Status = payment_Status;
	}

	public Date getDue_Date() {
		return due_Date;
	}

	public void setDue_Date(Date due_Date) {
		this.due_Date = due_Date;
	}

	public Date getCollection_Date() {
		return collection_Date;
	}

	public void setCollection_Date(Date collection_Date) {
		this.collection_Date = collection_Date;
	}

	public SNDList getSndList() {
		return sndList;
	}

	public void setSndList(SNDList sndList) {
		this.sndList = sndList;
	}

	public String getInstrument_Code() {
		return Instrument_Code;
	}

	public void setInstrument_Code(String instrument_Code) {
		Instrument_Code = instrument_Code;
	}

	public String getInstrumnet_No() {
		return Instrumnet_No;
	}

	public void setInstrumnet_No(String instrumnet_No) {
		Instrumnet_No = instrumnet_No;
	}

	public Double getRev_StampAmount() {
		return Rev_StampAmount;
	}

	public void setRev_StampAmount(Double rev_StampAmount) {
		Rev_StampAmount = rev_StampAmount;
	}

	public String getBank_Txn_Id() {
		return Bank_Txn_Id;
	}

	public void setBank_Txn_Id(String bank_Txn_Id) {
		Bank_Txn_Id = bank_Txn_Id;
	}

	public String getNesco_Txn_Id() {
		return Nesco_Txn_Id;
	}

	public void setNesco_Txn_Id(String nesco_Txn_Id) {
		Nesco_Txn_Id = nesco_Txn_Id;
	}

	public Double getPrincipal_Amount() {
		return Principal_Amount;
	}

	public void setPrincipal_Amount(Double principal_Amount) {
		Principal_Amount = principal_Amount;
	}

	public Double getNet_PrincipalAmount() {
		return Net_PrincipalAmount;
	}

	public void setNet_PrincipalAmount(Double net_PrincipalAmount) {
		Net_PrincipalAmount = net_PrincipalAmount;
	}
}
