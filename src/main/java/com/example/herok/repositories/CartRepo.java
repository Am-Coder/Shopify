package com.example.herok.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.herok.enities.Cart;
import com.example.herok.nonentity.CartDisplay;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
	
	@Query("Select c.quantity,p.productname,p.price,p.availability from Cart c INNER JOIN Product p on p.pid=c.pid where c.userEmail.email = :userEmail")
	public List<CartDisplay> findByUserEmail(@Param("userEmail") String userEmail);
	
}
