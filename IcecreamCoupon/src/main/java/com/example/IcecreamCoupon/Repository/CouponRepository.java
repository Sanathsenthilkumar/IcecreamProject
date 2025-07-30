package com.example.IcecreamCoupon.Repository;

import com.example.IcecreamCoupon.Model.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends MongoRepository<Coupon, Integer> {
    Optional<Coupon> findByDiscount(int discount);
}
