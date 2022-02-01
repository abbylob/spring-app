package com.example.dto;

public class BeeceptorDTO {
    String status;
    String code;
    String message;
    //ExampleDTO exampleDTO;

    public BeeceptorDTO() {
    }
/*
    public ExampleDTO getExampleDTO() {
        return exampleDTO;
    }

    public void setExampleDTO(ExampleDTO exampleDTO) {
        this.exampleDTO = exampleDTO;
    }
*/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String toJson() {
        return "{" +
                "\"status\":\"" + status + "\"," +
                " \"code\":\"" + code + "\"," +
                " \"message\":\"" + message +"\""+
                '}';
    }
}
