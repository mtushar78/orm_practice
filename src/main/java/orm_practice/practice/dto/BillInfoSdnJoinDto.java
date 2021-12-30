package orm_practice.practice.dto;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BillInfoSdnJoinDto {
    private String bill_no;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date collection_date;
    private String bank_txn_id;
    private String nesco_txn_id;
    private Double total_billAmount;
    private Double Principal_Amount;
    private Double vat_amount;
    private Double lpc_amount;
    private Double rev_stampAmount;
    private Double net_principalAmount;
    private Integer snd_id;
    private String sndname;
    private Integer display_order;

    public BillInfoSdnJoinDto() {
    }

    public BillInfoSdnJoinDto(String bill_no, Date collection_date, String bank_txn_id, String nesco_txn_id, Double total_billAmount, Double principal_Amount, Double vat_amount, Double lpc_amount, Double rev_stampAmount, Double net_principalAmount, Integer snd_id, String sndname, Integer display_order) {
        this.bill_no = bill_no;
        this.collection_date = collection_date;
        this.bank_txn_id = bank_txn_id;
        this.nesco_txn_id = nesco_txn_id;
        this.total_billAmount = total_billAmount;
        Principal_Amount = principal_Amount;
        this.vat_amount = vat_amount;
        this.lpc_amount = lpc_amount;
        this.rev_stampAmount = rev_stampAmount;
        this.net_principalAmount = net_principalAmount;
        this.snd_id = snd_id;
        this.sndname = sndname;
        this.display_order = display_order;
    }

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public Date getCollection_date() {
        return collection_date;
    }

    public void setCollection_date(Date collection_date) {
        this.collection_date = collection_date;
    }

    public String getBank_txn_id() {
        return bank_txn_id;
    }

    public void setBank_txn_id(String bank_txn_id) {
        this.bank_txn_id = bank_txn_id;
    }

    public String getNesco_txn_id() {
        return nesco_txn_id;
    }

    public void setNesco_txn_id(String nesco_txn_id) {
        this.nesco_txn_id = nesco_txn_id;
    }

    public Double getTotal_billAmount() {
        return total_billAmount;
    }

    public void setTotal_billAmount(Double total_billAmount) {
        this.total_billAmount = total_billAmount;
    }

    public Double getPrincipal_Amount() {
        return Principal_Amount;
    }

    public void setPrincipal_Amount(Double principal_Amount) {
        Principal_Amount = principal_Amount;
    }

    public Double getVat_amount() {
        return vat_amount;
    }

    public void setVat_amount(Double vat_amount) {
        this.vat_amount = vat_amount;
    }

    public Double getLpc_amount() {
        return lpc_amount;
    }

    public void setLpc_amount(Double lpc_amount) {
        this.lpc_amount = lpc_amount;
    }

    public Double getRev_stampAmount() {
        return rev_stampAmount;
    }

    public void setRev_stampAmount(Double rev_stampAmount) {
        this.rev_stampAmount = rev_stampAmount;
    }

    public Double getNet_principalAmount() {
        return net_principalAmount;
    }

    public void setNet_principalAmount(Double net_principalAmount) {
        this.net_principalAmount = net_principalAmount;
    }

    public Integer getSnd_id() {
        return snd_id;
    }

    public void setSnd_id(Integer snd_id) {
        this.snd_id = snd_id;
    }

    public String getSndname() {
        return sndname;
    }

    public void setSndname(String sndname) {
        this.sndname = sndname;
    }

    public Integer getDisplay_order() {
        return display_order;
    }

    public void setDisplay_order(Integer display_order) {
        this.display_order = display_order;
    }
}
