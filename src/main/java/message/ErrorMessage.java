package message;

public enum ErrorMessage {
    NO_COMMAND("잘못된 기능을 선택하였습니다."),
    NO_MENU("입력된 메뉴가 없습니다."),
    NO_MENU_COUNT("입력된 메뉴의 수량이 잘못되었습니다."),
    OVER_TOTAL_MENU_COUNT("주문 메뉴 총 수량이 기준 갯수보다 많습니다."),
    NO_PAYMENT("잘못된 결제 방법을 선택하였습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
