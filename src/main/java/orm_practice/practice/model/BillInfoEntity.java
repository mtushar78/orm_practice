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
	  
	  private String client_txn_Id;
	  
	  private Double Principal_Amount;
	  
	  private Double Net_PrincipalAmount;


}
