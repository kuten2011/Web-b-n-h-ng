package CNJV.lab10.Service;

import CNJV.lab10.Repository.BillDetailRepository;
import CNJV.lab10.model.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailService {

    @Autowired
    BillDetailRepository billDetailRepository;

    public BillDetail save(BillDetail billDetail){
        return billDetailRepository.save(billDetail);
    }
}