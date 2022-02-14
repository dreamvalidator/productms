package com.ps.product.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ps.product.productservice.model.Coupon;
import com.ps.product.productservice.model.Product;
import com.ps.product.productservice.repo.ProductRepository;
import com.ps.product.productservice.restClient.CouponClient;

@RestController
@RequestMapping("/productapi")
public class ProductAPi {
	
	@Autowired
	CouponClient couponClient;

	@Autowired
	private ProductRepository repo;
	
	@HystrixCommand(fallbackMethod = "sendErrorResponse")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponcode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);

	}
		
	public Product sendErrorResponse(Product product) {
		return product;

	}

	
	}
	


