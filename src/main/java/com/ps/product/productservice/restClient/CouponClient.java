package com.ps.product.productservice.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ps.product.productservice.model.Coupon;

@FeignClient(name="API-GATEWAY")
public interface CouponClient {
	@GetMapping("couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);
		
	
	

}
