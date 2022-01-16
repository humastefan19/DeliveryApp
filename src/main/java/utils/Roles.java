package utils;

public enum Roles {
    ADMIN("ADMIN"),
    DELIVERY("DELIVERY"),
    RESTAURANT_MANAGER("RESTAURANT_MANAGER"),
    USER("USER");

    private final String message;

    Roles(String message) {
        this.message = message;
    }
}
