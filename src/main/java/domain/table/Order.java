package domain.table;

import domain.menu.Menu;
import message.ErrorMessage;

public class Order {
    private static final int MIN_AMOUNT = 1;
    private static final int MAX_AMOUNT = 99;
    private final Menu menu;
    private int amount;

    public Order(Menu menu, int amount) {
        validateAmount(amount);
        this.menu = menu;
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < MIN_AMOUNT || amount > MAX_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.NO_MENU_COUNT.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}
