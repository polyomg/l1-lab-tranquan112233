package poly.edu.tv00103_lab8.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import poly.edu.tv00103_lab8.model.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
}
