package orm_practice.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orm_practice.practice.dto.BillInfoSdnJoinDto;
import orm_practice.practice.repository.BillInfoRepo;
import orm_practice.practice.repository.JpaProjection;

import java.util.List;

@Service
public class BillInfoService {
    @Autowired
    BillInfoRepo billInfoRepo;

    public List<BillInfoSdnJoinDto> getData(){
        return billInfoRepo.fetchBillInfoSDNJoin();
    }
    public List<JpaProjection> getDataWithProjection(){
        return billInfoRepo.billInfoWithProjection();
    }


}
