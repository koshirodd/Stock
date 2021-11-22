package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="stock")
public class Stock {
		@Id
	private String company;
	
	private int id;
	
	private double assetvalue;
	private double busvalue;
	private double companyvalue;
	
}
