package com.First.FirstStep.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String field;
    private String fieldName;
    private Long fieldId;
    private String resourceName;

    public ResourceNotFoundException(String field, String fieldName, Long fieldId) {
        super(String.format("%s with %s: %d not found",field,fieldName,fieldId));
        this.field = field;
        this.fieldName = fieldName;
        this.fieldId = fieldId;
    }

    public ResourceNotFoundException(String field, String fieldName, String resourceName) {
        super(String.format("%s with %s: %s not found",field,fieldName,resourceName));
        this.field = field;
        this.fieldName = fieldName;
        this.resourceName = resourceName;
    }
}
