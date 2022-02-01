package com.example.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    /**
     * Serial
     */
    private static final long serialVersionUID = -380786979143064061L;

    /**
     * Codigo del error
     */
    private final String codigo;

    /**
     * Descripcion del error
     */
    private final String description;

    /**
     * http status
     */
    private final HttpStatus httpStatus;

    @Override
    public String toString() {
        return "BusinessException{" +
                "codigo='" + codigo + '\'' +
                ", description='" + description + '\'' +
                ", httpStatus=" + httpStatus +
                '}';
    }

    public BusinessException(final String message) {
        super(message);
        this.httpStatus = null;
        this.codigo = null;
        this.description = message;
    }

    public BusinessException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.codigo = null;
        this.description = null;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
