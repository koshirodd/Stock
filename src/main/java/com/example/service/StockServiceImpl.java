package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Stock;
import com.example.repository.CompanyRepository;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<Stock> getAllStocks(Stock stock){
		/*ExampleMatcher matcher = ExampleMatcher
				.matching() // and 条件
				.withStringMatcher(StringMatcher.CONTAINING)//like
				.withIgnoreCase(); //小文字大文字気にしない
		
		return companyRepository.findAll(Example.of(stock, matcher));*/
		return companyRepository.findAll();		
	
	}
	
	@Transactional
	@Override
	public void insertstock(String company,  Double assetvalue,Double busvalue,Double companyvalue) {
		companyRepository.insertstock(company, assetvalue, busvalue, companyvalue);
		
	
	}
	
	@Transactional
	@Override
	public void deletestock(int id) {
		companyRepository.deletestock(id);
		
	
	}
	
	
}
