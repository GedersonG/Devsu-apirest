package com.devsu.apirest.application.dto.response;

public class MessageResponseDto {

    private String message;

    public MessageResponseDto(){
        message = "";
    }
    public MessageResponseDto (String message){
        this.message = message;
    }

}
