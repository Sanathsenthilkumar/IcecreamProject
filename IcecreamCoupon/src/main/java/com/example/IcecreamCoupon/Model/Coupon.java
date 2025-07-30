package com.example.IcecreamCoupon.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Coupon {
    @Id
    private int couponId;
    private int discount;

    public Coupon() {
    }

    public Coupon(int couponId, int discount) {
        this.couponId = couponId;
        this.discount = discount;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
