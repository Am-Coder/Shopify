package com.example.herok.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.herok.enities.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product,String> {
	Optional<Product> findByPid(String pid);
	Optional<Product> findByRating(float rating );
	Optional<Product> findByBrand(String brand);
	Optional<Product> findByProductname(String productname);
	Optional<Product> findByPrice(String price);
	List<Product> findByType(String type);
	
//	@Query("")
//	Product findClothes();
//	
//	@Query("")
//	Product findElectronics();
//	
//	@Query("")
//	Product findFootwear();
	
	
	
	
}
