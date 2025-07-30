package com.example.IcecreamCoupon.Service;

import com.example.IcecreamCoupon.Model.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouponService {
    abstract List<Coupon> getCoupons();
    abstract Coupon getCouponById(int couponId);
    abstract Coupon getCouponByDiscount(int discount);
    abstract Coupon createCoupon(Coupon coupon);
    abstract Coupon updateCoupon(Coupon coupon);
    abstract Coupon deleteCouponById(int couponId);
}
