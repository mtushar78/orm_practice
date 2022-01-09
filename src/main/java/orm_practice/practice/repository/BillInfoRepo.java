package orm_practice.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import orm_practice.practice.dto.BillInfoSdnJoinDto;
import orm_practice.practice.model.BillInfoEntity;

import java.util.List;

@Repository
public interface BillInfoRepo extends JpaRepository<BillInfoEntity, Long> {
    @Query("SELECT new orm_practice.practice.dto.BillInfoSdnJoinDto(bi.billNo, bi.collection_Date, bi.Bank_Txn_Id, bi.client_txn_Id, " +
            "bi.total_BillAmount, bi.Principal_Amount, bi.vat_Amount, bi.LPC_Amount, bi.Rev_StampAmount, bi.Net_PrincipalAmount, sl.sndId, " +
            "sl.sNDName, sl.displayOrder) FROM BillInfoEntity bi JOIN bi.sndList sl where bi.payment_Status = 'PAID'" +
            "group by sl.sndId, bi.billNo,bi.collection_Date,bi.Bank_Txn_Id,bi.client_txn_Id,bi.total_BillAmount,bi.Principal_Amount," +
            "sl.displayOrder,sl.sNDName order by sl.displayOrder asc")
    List<BillInfoSdnJoinDto> fetchBillInfoSDNJoin();


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

}
