package com.example.IcecreamCoupon.Service;

import com.example.IcecreamCoupon.Model.Coupon;
import com.example.IcecreamCoupon.Repository.CouponRepository;
import com.example.IcecreamCoupon.Util.CouponDiscountNotFoundException;
import com.example.IcecreamCoupon.Util.CouponIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public List<Coupon> getCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon getCouponById(int couponId) {
        Optional<Coupon> _getCoupon = couponRepository.findById(couponId);
        if(_getCoupon.isPresent()) {
            Coupon coupon = _getCoupon.get();
            return coupon;
        } else {
            System.out.println("error in coupon");
            throw new CouponIdNotFoundException("Coupon not found");
        }
    }

    @Override
    public Coupon getCouponByDiscount(int discount) {
        Optional<Coupon> _getCoupon = couponRepository.findByDiscount(discount);
        if(_getCoupon.isPresent()) {
            Coupon coupon = _getCoupon.get();
            return coupon;
        } else {
            throw new CouponDiscountNotFoundException("Coupon not found");
        }
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        if(coupon != null) {
            couponRepository.save(coupon);
        }
        return coupon;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        Optional<Coupon> _updateCoupon = couponRepository.findById(coupon.getCouponId());
        if(_updateCoupon.isPresent()) {
            Coupon newCoupon = _updateCoupon.get();
            newCoupon.setCouponId(coupon.getCouponId());
            newCoupon.setDiscount(coupon.getDiscount());
            couponRepository.save(newCoupon);
            return newCoupon;
        } else {
            throw  new CouponIdNotFoundException("Coupon with "+coupon.getCouponId()+" id not found");
        }
    }

    @Override
    public Coupon deleteCouponById(int couponId) {
        Optional<Coupon> _updateCoupon = couponRepository.findById(couponId);
        if(_updateCoupon.isPresent()) {
            Coupon deletedCoupon = _updateCoupon.get();
            couponRepository.deleteById(couponId);
            return deletedCoupon;
        } else {
            throw  new CouponIdNotFoundException("Coupon with "+couponId+" id not found");
        }
    }
}
