package orm_practice.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import orm_practice.practice.dto.BillInfoSdnJoinDto;
import orm_practice.practice.model.BillInfoEntity;

import java.util.List;

@Repository
public interface BillInfoRepo extends JpaRepository<BillInfoEntity, Long> {
    @Query("SELECT new orm_practice.practice.dto.BillInfoSdnJoinDto(bi.billNo, bi.collection_Date, bi.Bank_Txn_Id, bi.Nesco_Txn_Id, bi.total_BillAmount, bi.Principal_Amount, bi.vat_Amount, bi.LPC_Amount, bi.Rev_StampAmount, bi.Net_PrincipalAmount, sl.sndId, sl.sNDName, sl.displayOrder) "
            + "FROM BillInfoEntity bi JOIN bi.sndList sl where bi.payment_Status = 'PAID'" +
            "group by sl.sndId, bi.billNo,bi.collection_Date,bi.Bank_Txn_Id,bi.Nesco_Txn_Id,bi.total_BillAmount,bi.Principal_Amount,sl.displayOrder,sl.sNDName order by sl.displayOrder asc")
    List<BillInfoSdnJoinDto> fetchBillInfoSDNJoin();
}
