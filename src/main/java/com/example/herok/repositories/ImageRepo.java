package com.example.herok.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.herok.enities.Images;
import com.example.herok.enities.Product;

@Repository
public interface ImageRepo extends JpaRepository<Images,Long>{
	Optional<Images> findByPid(Product pid);
	
}
