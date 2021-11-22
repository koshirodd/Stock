package com.example.service;

import java.util.List;

import com.example.entity.Stock;

public interface StockService {

	public List<Stock> getAllStocks(Stock stock);	
	
	public void insertstock(String company,  Double assetvalue,Double busvalue,Double companyvalue);
	
	public void deletestock(int id);
	


}
