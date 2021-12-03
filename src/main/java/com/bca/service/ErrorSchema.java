package com.bca.service;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ErrorSchema {

    @JsonAlias(value = "ErrorCode")
    private String errorCode;
    @JsonAlias(value = "ErrorMessage")
    private ErrorMessage errorMessage;

    public ErrorSchema(String errorCode, String inMessage, String enMessage) {
        this.errorCode = errorCode;
        errorMessage = new ErrorMessage(inMessage, enMessage);
    }
}
