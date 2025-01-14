package CNJV.lab10.Service;

import CNJV.lab10.Repository.AccountRepository;
import CNJV.lab10.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public Account getAccount(Account account){
        Optional<Account> foundTK = accountRepository.findById(account.getUsername());
        return foundTK.isPresent() && account.getPassword().equals(foundTK.get().getPassword()) ?
                account : null;
    }
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}