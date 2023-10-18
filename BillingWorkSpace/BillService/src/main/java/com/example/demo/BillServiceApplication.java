package com.example.demo;

import com.example.demo.beans.CustomerBean;
import com.example.demo.beans.ProductBean;

import com.example.demo.model.ProductItem;
import com.example.demo.proxies.CustomerService;
import com.example.demo.proxies.ProductService;
import com.example.demo.repository.BillRepository;

import com.example.demo.model.Bill;
import com.example.demo.repository.ProductItemRepository;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@AllArgsConstructor
public class BillServiceApplication implements CommandLineRunner {

	CustomerService customerServiceProxy;

	ProductService productServiceProxy;
	BillRepository billRepository;
	ProductItemRepository productItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(BillServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Question 1
		CustomerBean bean= customerServiceProxy.findCustomerById(1L);
		System.out.println(bean.getName());

		//Question 2+3
		Bill bill= new Bill();
		bill.setBillingdate(new Date());
		bill.setCustomerID(1L);
		bill.setCustomer(bean);
		billRepository.save(bill);



		ProductBean product1 = productServiceProxy.findProductById(1L);
		ProductBean product2 = productServiceProxy.findProductById(2L);
		ProductBean product3 = productServiceProxy.findProductById(3L);

		ProductItem productItem1 = new ProductItem();
		productItem1.setId(product1.getId());
		productItem1.setProduct(product1);
		productItem1.setProductId(product1.getId());
		productItem1.setBill(bill);


		ProductItem productItem2 = new ProductItem();
		productItem2.setId(product2.getId());
		productItem2.setProduct(product2);
		productItem2.setProductId(product2.getId());
		productItem2.setBill(bill);

		ProductItem productItem3 = new ProductItem();
		productItem3.setId(product3.getId());
		productItem3.setProduct(product3);
		productItem3.setProductId(product3.getId());
		productItem3.setBill(bill);

		productItemRepository.save(productItem1);
		productItemRepository.save(productItem2);
		productItemRepository.save(productItem3);

		System.out.println(bill);



	}

}



