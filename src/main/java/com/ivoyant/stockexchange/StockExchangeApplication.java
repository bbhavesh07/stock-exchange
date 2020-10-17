package com.ivoyant.stockexchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import com.ivoyant.stockexchange.model.OrderType;
import com.ivoyant.stockexchange.model.StockOrder;
import com.ivoyant.stockexchange.repository.StockOrderRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;

@SpringBootApplication
public class StockExchangeApplication  implements CommandLineRunner{
	
	//for test purpose only, used for initial data loading
	@Autowired
	StockOrderRepository stockOrderRepo;

	public static void main(String[] args) {
		SpringApplication.run(StockExchangeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/iVoyant_Stack_Data.csv").getInputStream()));
        br.readLine();
		String line; 
  
        while ((line = br.readLine()) != null) { 
        	String[] next = line.split(",");
            StockOrder order = new StockOrder();
            order.setOrderId(Long.parseLong(next[0]));
            order.setStockName(next[1]);
            order.setOrderType(OrderType.valueOf(next[2]));
            order.setQuantity(Integer.parseInt(next[3]));
            order.setPrice(Double.parseDouble(next[4]));
            order.setTime(new Timestamp(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(next[5]).getTime()));
            stockOrderRepo.save(order);
        } 
	}

}
