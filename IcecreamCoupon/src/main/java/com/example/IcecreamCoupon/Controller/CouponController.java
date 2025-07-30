package com.example.IcecreamCoupon.Controller;

import com.example.IcecreamCoupon.Model.Coupon;
import com.example.IcecreamCoupon.Service.CouponServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/coupon")
@RestController
public class CouponController {

    @Autowired
    private CouponServiceImpl couponServiceImpl;

    @GetMapping("/getCoupons")
    public List<Coupon> getCoupons() {
        return couponServiceImpl.getCoupons();
    }

    @GetMapping("/getCouponById/{couponId}")
    public ResponseEntity<Coupon> getCouponById(@PathVariable int couponId) {
        Coupon _getCoupon = couponServiceImpl.getCouponById(couponId);
        return new ResponseEntity<>(_getCoupon, HttpStatus.OK);
    }

    @GetMapping("/getCouponByDiscount/{discount}")
    public Coupon getCouponByDiscount(@PathVariable int discount) {
        return couponServiceImpl.getCouponByDiscount(discount);
    }

    @PostMapping("/createCoupon")
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponServiceImpl.createCoupon(coupon);
    }

    @PutMapping("/updateCoupon")
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return couponServiceImpl.updateCoupon(coupon);
    }

    @DeleteMapping("/deleteCouponById/{couponId}")
    public Coupon deleteCOuponById(@PathVariable int couponId) {
        return couponServiceImpl.deleteCouponById(couponId);
    }
}
