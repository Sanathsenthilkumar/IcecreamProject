package com.example.icecreamservice.model;


public class Coupon {
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
