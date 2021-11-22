package com.example.service.calCompany;

import org.springframework.stereotype.Service;

import com.example.entity.Stock;
import com.example.form.CalcForm;



@Service
public class CalcValueService {
	public Stock calcStock(CalcForm form) {
		double busvalue =form.getProfit(); //事業価値
		busvalue *=10;
		
		double currentliabi =form.getCurrentliabi(); //流動負債
		currentliabi *=1.2;
		
		double currentasset = form.getCurrentasset();
		double otherinvest=form.getOtherinvest();
		
		double assetvalue = currentasset - currentliabi + otherinvest;
		
		double debt =form.getDebt();
		double stocks = form.getStocks();
		
		double companyvalue = busvalue + assetvalue - debt;
		companyvalue = companyvalue/ stocks ;//業価値
		
		Stock stock = new Stock();
		stock.setCompany(form.getCompany());
		stock.setAssetvalue(assetvalue);
		stock.setBusvalue(busvalue);
		stock.setCompanyvalue(companyvalue);
		
		
		
		return stock;
				
	
	
	}
	
	
	
	
}
