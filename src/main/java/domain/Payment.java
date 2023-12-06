package domain;

import message.ErrorMessage;

public enum Payment {
    CARD(1, "신용 카드"),
    CASH(2, "현금");

    private final int code;
    private final String description;

    Payment(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Payment of(int paymentCode) {
        for (Payment payment : Payment.values()) {
            if (payment.code == paymentCode) {
                return payment;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NO_PAYMENT.getMessage());
    }
}
