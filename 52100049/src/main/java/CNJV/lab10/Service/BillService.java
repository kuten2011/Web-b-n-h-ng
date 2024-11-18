package CNJV.lab10.Service;

import CNJV.lab10.Repository.BillRepository;
import CNJV.lab10.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    public Bill save(Bill billDetail){
        return billRepository.save(billDetail);
    }
}
