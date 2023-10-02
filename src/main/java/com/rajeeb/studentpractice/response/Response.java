package com.rajeeb.studentpractice.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private String message;
    private String status;
    private T data;

    public Response(String message) {
        this.message = message;
    }

    public Response(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
