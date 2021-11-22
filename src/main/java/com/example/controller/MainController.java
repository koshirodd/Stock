package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Stock;
import com.example.form.StockForm;
import com.example.service.StockService;

@Controller
public class MainController {
	
	@Autowired 
	private StockService stockService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/main")
	public String showcompany(@ModelAttribute("stockform") StockForm stockform, Model model) {
		
		Stock stock = mapper.map(stockform, Stock.class);
		
		//stock の情報を、mapper から取り出す。
		List<Stock> stocks=stockService.getAllStocks(stock);
		
		model.addAttribute("stocklist", stocks);
		
		return "main";
	}
	
	@PostMapping("/main")
	public String detail(Model model) {
		
		return "main";
	}

}
