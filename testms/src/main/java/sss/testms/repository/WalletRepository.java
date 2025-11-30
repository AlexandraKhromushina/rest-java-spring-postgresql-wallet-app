package sss.testms.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sss.testms.model.Wallet;
import java.util.*;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}