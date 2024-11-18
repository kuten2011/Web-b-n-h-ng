package CNJV.lab10.Service;

import CNJV.lab10.Repository.AccountRepository;
import CNJV.lab10.Repository.CartManagementRepository;
import CNJV.lab10.model.Account;
import CNJV.lab10.model.CartManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartManagementService {
    @Autowired
    CartManagementRepository cartManagementRepository;
    @Autowired
    AccountRepository accountRepository;
    public CartManagement save(CartManagement cartManagement){
        return cartManagementRepository.save(cartManagement);
    }
    public List<CartManagement> getAllCartManagementByUserAccount(String username){
        Optional<Account> account = accountRepository.findById(username);

        return cartManagementRepository.findByUserAccount(account);
    }
    public CartManagement findBySanPhamIdAndUserAccount(Long sanPhamId, Account username){
        return cartManagementRepository.findBySanPhamIdAndUserAccount(sanPhamId,username);
    }

    public void deleteCartManagement(CartManagement cartManagement){
        cartManagementRepository.delete(cartManagement);
    }
}
