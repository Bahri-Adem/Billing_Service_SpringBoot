package com.example.demo.model;

import java.io.Serializable;

import com.example.demo.beans.ProductBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class ProductItem implements Serializable{

	@Transient
	ProductBean product;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double price;
	private int quantite;

	private Long productId;
	

	@ManyToOne
	@JsonIgnore
	private Bill bill;
}
