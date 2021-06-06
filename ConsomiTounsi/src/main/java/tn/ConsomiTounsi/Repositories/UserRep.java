package tn.ConsomiTounsi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.ConsomiTounsi.Entities.User;
@Repository
public interface UserRep extends JpaRepository<User, Long> {
	
	 @Query(" select u from User u " +
	            " where u.username = ?1")
	    Optional<User> findUserWithName(String username);
	 
	 @Query("select max(id) from User")
	    Long findid();
	 
	 @Query(" select u.idUser from User u " +
	            " where u.username =:username")
	    Long findSesson(@Param("username")String username);
	  
	    
		User findByemaiUser(String email);
		
		@Modifying
	    @Query(value = "insert into users_roles (user_id,role_id) VALUES (:uid,:rid)", nativeQuery = true)
	    @Transactional
	    void addrole(@Param("uid") Long insertLink, @Param("rid") int id);
		
		public User getUserByEmaiUserAndPassword(String login, String password);

		
}

