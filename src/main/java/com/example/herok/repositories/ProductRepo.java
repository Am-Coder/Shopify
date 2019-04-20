package com.example.herok.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.herok.enities.Product;
import com.example.herok.nonentity.ProductDisplay;


@Repository
public interface ProductRepo extends JpaRepository<Product,String> {
	Optional<Product> findByPid(String pid);
	Optional<Product> findByRating(float rating );
	Optional<Product> findByBrand(String brand);
	Optional<Product> findByProductname(String productname);
	Optional<Product> findByPrice(String price);
	
	
	@Query("select new com.example.herok.nonentity.ProductDisplay(p.pid,p.productname,p.type,p.price,p.rating,p.availability,p.brand,i.directory) from Product p INNER JOIN Images i on i.pid.pid = p.pid where p.type = :type")
	List<ProductDisplay> findByType(@Param("type") String type,Pageable pageable);
	
//	@Query("")
//	Product findClothes();
//	
//	@Query("")
//	Product findElectronics();
//	
//	@Query("")
//	Product findFootwear();
	
	
	
	
}
