package com.barber.shop.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.barber.shop.model.Products;
@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
	/** java  es la consulta y la variable es la que se ingresa **/
	@Query("Select pro FROM Products pro WHERE pro.category_id=:cat_id")
	List<Products> getByCategoryId(@Param("cat_id")String cat_id);
}
