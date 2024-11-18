package CNJV.lab10.Repository;

import CNJV.lab10.model.Account;
import CNJV.lab10.model.CartManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartManagementRepository extends JpaRepository<CartManagement,Long> {

    List<CartManagement> findByUserAccount(Optional<Account> account);

    CartManagement findBySanPhamIdAndUserAccount(Long sanPhamId, Account username);
}