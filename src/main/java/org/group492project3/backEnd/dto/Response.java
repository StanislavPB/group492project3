package org.group492project3.backEnd.dto;

public class Response<T,U> {
    private final T elementOfOperation;
    private final boolean operationIsSuccess;
    private final U descriptions;

    public Response(T elementOfOperation, boolean operationIsSuccess, U description) {
        this.elementOfOperation = elementOfOperation;
        this.operationIsSuccess = operationIsSuccess;
        this.descriptions = description;
    }

    public T getElementOfOperation() {
        return elementOfOperation;
    }

    public boolean getStatusOfOperation() {
        return operationIsSuccess;
    }

    public U getDescription() {
        return descriptions;
    }

}
