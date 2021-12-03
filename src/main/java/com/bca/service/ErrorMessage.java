package com.bca.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    @JsonAlias(value = "Indonesian")
    private String indonesian;
    @JsonAlias(value = "English")
    private String english;
}
