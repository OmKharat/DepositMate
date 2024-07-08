
package com.example.DepositManagement.Repo;

        import com.example.DepositManagement.Entity.Deposit;
        import com.example.DepositManagement.Entity.User;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
        import org.springframework.stereotype.Repository;

        import java.util.List;
@EnableJpaRepositories
@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
    List<Deposit> findByUser(User userId);
    List<Deposit> findByDepositType(String depositType);
}
