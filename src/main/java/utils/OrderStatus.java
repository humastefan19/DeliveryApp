package utils;

public enum OrderStatus {
    IN_PROCESS("IN_PROCESS"),
    PICKED("PICKED"),
    ON_ROUTE("ON_ROUTE"),
    DELIVERED("DELIVERED");

    private final String message;

    OrderStatus(String message) {
        this.message = message;
    }


}
