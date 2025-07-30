package com.example.IcecreamCoupon.Model;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetais {
    private Date timestamp;
    private String errorDescription;
    private HttpStatus status;

    public ErrorDetais(Date timestamp, String errorDescription, HttpStatus status) {
        this.timestamp = timestamp;
        this.errorDescription = errorDescription;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
