package domain;

public enum TableStatus {
    ACTIVE("#"),
    DISABLE("─");

    private final String message;

    TableStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
