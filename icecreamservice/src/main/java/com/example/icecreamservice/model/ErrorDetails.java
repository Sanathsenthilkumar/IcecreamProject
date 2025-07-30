package com.example.icecreamservice.model;


import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String errorDescription;
    private String message;

    public ErrorDetails(Date timestamp, String errorDescription, String message) {
        this.timestamp = timestamp;
        this.errorDescription = errorDescription;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
