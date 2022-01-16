package utils;

public enum OrderStatus {
    PICKED("PICKED"),
    ON_ROUTE("ON_ROUTE"),
    DELIVERED("DELIVERED");

    private final String message;

    OrderStatus(String message) {
        this.message = message;
    }


}
