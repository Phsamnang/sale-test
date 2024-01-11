package com.kosign.saletest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class SaleRestController<T> {
    public <T> ResponseEntity<T> buildResponse(HttpStatus status, T data, HttpHeaders headers) {

        //        headers.add("Custom-Header", "foo");
        if(data == null) {
            return ResponseEntity.ok().headers(headers).build();
        }

        return new ResponseEntity<T>(data, headers, HttpStatus.OK);

    }

    public <T> ResponseEntity<T> ok(T data, HttpHeaders headers) {

        return buildResponse(HttpStatus.OK, data, headers);

    }

    public <T> ResponseEntity<T> buildResponse(HttpStatus status, T data) {

        return buildResponse(status, data, new HttpHeaders());

    }

    public <T> ResponseEntity<T> ok(T data) {

        return buildResponse(HttpStatus.OK, data);

    }

    public <T> ResponseEntity<T> buildResponse(HttpStatus status)
    {

        return buildResponse(status, null);

    }

    public <T> ResponseEntity<T> ok() {

        return buildResponse(HttpStatus.OK);

    }
}
