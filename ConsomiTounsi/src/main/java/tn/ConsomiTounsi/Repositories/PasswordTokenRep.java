package tn.ConsomiTounsi.Repositories;

import tn.ConsomiTounsi.Entities.PasswordResetToken;
import tn.ConsomiTounsi.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.stream.Stream;

@Repository 
public interface PasswordTokenRep extends JpaRepository<PasswordResetToken, Long> {

	PasswordResetToken findByToken(String confirmationToken);
 
}
