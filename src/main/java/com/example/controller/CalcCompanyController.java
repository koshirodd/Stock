package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Stock;
import com.example.form.CalcForm;
import com.example.service.StockService;
import com.example.service.calCompany.CalcValueService;



@Controller
public class CalcCompanyController {
	
	@Autowired
	StockService stockService;
	
	@Autowired
	CalcValueService calcValueService;
	
	@GetMapping("/calc")
	public String regicomp(Model model, @ModelAttribute CalcForm form) {
		model.addAttribute("calcform", form);
		return "calc";
	}
	
	@PostMapping("/calc")	
	public String regiComp(Model model, @ModelAttribute CalcForm form)  {
		//form の内容受け取って、それをservice で計算してinsert する処理
		Stock stock = calcValueService.calcStock(form);
		
		stockService.insertstock(stock.getCompany(),stock.getAssetvalue(),
				stock.getBusvalue(),stock.getCompanyvalue());
		
		
		return "redirect:/main";
	}
	
	
	
}
