package com.example.icecreamservice.controller;

import com.example.icecreamservice.feingclient.CouponFeing;
import com.example.icecreamservice.model.Coupon;
import com.example.icecreamservice.model.ErrorDetails;
import com.example.icecreamservice.model.Icecream;
import com.example.icecreamservice.service.IcecreamServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/icecream")
public class IcecreamController {

    private static final Logger logger = LoggerFactory.getLogger(IcecreamController.class);

    @Autowired
    private IcecreamServiceImpl icecreamServiceImpl;

    @Autowired
    private CouponFeing couponFeing;

    @GetMapping("/getFlavours")
    public List<Icecream> getFlavours() {
        return icecreamServiceImpl.getFlavours();
    }

    @GetMapping("/getFlavourById/{flavourId}")
    public Icecream getFlavourById(@PathVariable int flavourId) {
        return icecreamServiceImpl.getFlavourById(flavourId);
    }

    @PostMapping("/addFlavour")
    public Icecream addFlavour(@RequestBody Icecream flavour) {
        return icecreamServiceImpl.addFlavour(flavour);
    }

    @CircuitBreaker(name="icecreamservice", fallbackMethod = "handleError")
    @GetMapping("/getFlavourByDiscount/{flavourId}/{couponId}")
    public ResponseEntity<Icecream> getFlavourByDiscount(@PathVariable int flavourId, @PathVariable int couponId) {
        Icecream flavour = icecreamServiceImpl.getFlavourById(flavourId);
        Coupon coupon = couponFeing.getCouponById(couponId).getBody();
        flavour.setPrice(flavour.getPrice() - coupon.getDiscount());
        return new ResponseEntity<>(flavour, HttpStatus.OK);
    }
    public ResponseEntity<ErrorDetails> handleError(Exception ex) {
        logger.error("Error in getFlavourByDiscount or circuit breaker triggered: ", ex); // Log the full exception
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Internal Server Error", ex.getMessage());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
