package com.example.icecreamservice.feingclient;


import com.example.icecreamservice.model.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("ICECREAMCOUPON")
public interface CouponFeing {

    @GetMapping("/coupon/getCouponById/{couponId}")
    public ResponseEntity<Coupon> getCouponById(@PathVariable int couponId);

}
