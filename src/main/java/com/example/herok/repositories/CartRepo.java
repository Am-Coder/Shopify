package com.example.herok.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.herok.enities.Cart;
import com.example.herok.nonentity.CartDisplay;

@Repository
//@RepositoryRestResource(excerptProjection = CartDisplay.class)
public interface CartRepo extends JpaRepository<Cart, Long> {
	
	@Query("Select c from Cart c where c.userEmail.email = :userEmail and c.pid.pid = :pid")
	public Cart findByUserEmailAndPid(@Param("userEmail") String userEmail,@Param("pid") String pid);
	
	@Query("Select new com.example.herok.nonentity.CartDisplay(p.pid,c.quantity,p.productname,i.directory,p.price,p.availability) from Cart c INNER JOIN Product p on p.pid=c.pid.pid INNER JOIN Images i on c.pid.pid=i.pid where c.userEmail.email = :userEmail")
	public List<CartDisplay> findByUserEmail(@Param("userEmail") String userEmail);
	
	@Query("Select c from Cart c INNER JOIN Product p on p.pid=c.pid where c.userEmail.email = :userEmail")
	public List<Cart> findInCart(@Param("userEmail") String userEmail);
	
	@Query("Select c from Cart c INNER JOIN Product p on p.pid=c.pid where c.userEmail.email = :userEmail")
	public List<Cart> findCartByUserEmail(@Param("userEmail") String userEmail);
	
	
	@Transactional//Whenever some update is being done to database
	@Modifying//we need to add @Transactional as well as @Modifying
	@Query("Delete from Cart c where c.pid.pid = :pid and c.userEmail.email = :email")
	public void deleteByProductId(@Param("pid") String pid,@Param("email") String email);
	
	@Transactional
	@Modifying
	@Query("Update Cart c set c.quantity= :quantity where c.userEmail.email = :email and c.pid.pid = :pid")
	public void updateQuantity(@Param("pid") String pid, @Param("quantity") int quantity, @Param("email") String email);
	
	

}
