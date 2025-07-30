package com.example.IcecreamOrder.Model;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String errorDescription;
    private HttpStatus status;

    public ErrorDetails(Date timestamp, String errorDescription, HttpStatus status) {
        this.timestamp = timestamp;
        this.errorDescription = errorDescription;
        this.status = status;
    }
    // setter not needed
    public Date getTimestamp() {
        return timestamp;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
