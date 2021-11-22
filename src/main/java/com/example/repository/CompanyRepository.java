package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Stock;

public interface CompanyRepository extends JpaRepository<Stock,String>{
	
	
	
	@Modifying
	@Query(value = "delete from stock where id =:id", nativeQuery = true)
	public void deletestock(@Param("id") int id);
	
	@Modifying
	@Query(value = "insert into stock(company,assetvalue,busvalue,companyvalue)"
			+ "values(:company,:assetvalue,:busvalue,:companyvalue)", nativeQuery = true)
	public void insertstock(
			@Param("company") String company,@Param("assetvalue") Double assetvalue,
			@Param("busvalue") Double busvalue,@Param("companyvalue") Double companyvalue);
}
