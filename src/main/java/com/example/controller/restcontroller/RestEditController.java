package com.example.controller.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.StockForm;
import com.example.service.StockService;

import groovy.util.logging.Slf4j;

@Slf4j
@RestController
@RequestMapping("/main")
public class RestEditController {

	@Autowired
	private StockService stockService;
	
	@DeleteMapping("/deletecompany")
	public int deletestock(StockForm form) {
		int[] checkbox =form.getCheckbox();
		
		if (checkbox != null) {
			for (int i : checkbox) {
				Logger logger = LoggerFactory.getLogger(RestEditController.class);
				
		        logger.info("hi" + i + "sd");
				stockService.deletestock(i);
			}
		}
		
		return 0;
		
		
	}
	
	
}
