package com.zepolcode.orders_service.domain.model.dto.response;

public record BaseResponse(String[] errorMessages) {

    public Boolean hasErrors(){
        return errorMessages != null && errorMessages.length > 0;
    }
}
