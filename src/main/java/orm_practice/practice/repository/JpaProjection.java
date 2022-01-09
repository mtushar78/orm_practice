package orm_practice.practice.repository;
import orm_practice.practice.dto.BillInfoSdnJoinDto;
import java.util.Date;

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
