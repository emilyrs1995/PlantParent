package com.kenzie.capstone.service.exceptions;

import com.amazonaws.AmazonServiceException;

public class ApiGatewayException extends AmazonServiceException {
    // taken from the client package

    public ApiGatewayException(String errorMessage) {
        super(errorMessage);
    }

    public ApiGatewayException(String errorMessage, Exception cause) {
        super(errorMessage, cause);
    }
}
