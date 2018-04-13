package com.sda.cinema.model;

public class CinemaNotifierResponse {
    private boolean status;
    private CinemaNotifierResponseStatus StatusCode;

    public CinemaNotifierResponse(boolean status, CinemaNotifierResponseStatus statusCode) {
        this.status = status;
        StatusCode = statusCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CinemaNotifierResponseStatus getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(CinemaNotifierResponseStatus statusCode) {
        StatusCode = statusCode;
    }
}
