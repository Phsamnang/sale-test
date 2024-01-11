package com.kosign.saletest.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseData<T> {
    @JsonProperty("data")
    private T data;
}
