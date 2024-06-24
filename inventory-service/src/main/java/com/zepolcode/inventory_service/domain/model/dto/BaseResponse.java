package com.zepolcode.inventory_service.domain.model.dto;

public record BaseResponse(String[] errorMessages) {

    public Boolean hasErrors(){
        return errorMessages != null && errorMessages.length > 0;
    }
}
