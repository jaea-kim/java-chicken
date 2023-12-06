package domain.table;

import message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table {
    private static final int MAX_TOTAL_AMOUNT = 99;
    //TODO: 테이블 번호 enum으로 변경
    private final int number;
    private TableStatus status;
    //TODO: 일급컬렉션으로 분리
    private List<Order> orders;

    public Table(final int number) {
        this.number = number;
        status = TableStatus.DISABLE;
        orders = new ArrayList<>();
    }

    //TODO: 활성화여부 boolean 타입으로 반환하도록
    public TableStatus getTableStatus() {
        return status;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean eqaulsTableNumber(int tableNumber) {
        return number == tableNumber;
    }

    public void updateOrder(final Order order) {
        validateOrderAmount(order);
        orders.add(order);
        status = TableStatus.ACTIVE;
    }

    private void validateOrderAmount(Order order) {
        if (getTotalAmount() + order.getAmount() > MAX_TOTAL_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.OVER_TOTAL_MENU_COUNT.getMessage());
        }
    }

    private int getTotalAmount() {
        //TODO: 주문 객체 일급컬렉션으로 생성시 현재 수량을 반환하는 메소드로 변경
        return orders.stream()
                .mapToInt(Order::getAmount)
                .sum();
    }
}
