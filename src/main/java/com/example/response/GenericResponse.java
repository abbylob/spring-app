package com.example.response;

public class GenericResponse {
    private final int code;
    private final String message;
    private final Object data;

    public GenericResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

}
