package domain.table;

import java.util.ArrayList;
import java.util.List;

public class Table {
    //TODO: 테이블 번호 enum으로 변경
    private final int number;
    private TableStatus status;
    //TODO: 일급컬렉션으로 분리
    private List<Order> order;

    public Table(final int number) {
        this.number = number;
        status = TableStatus.DISABLE;
        order = new ArrayList<>();
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
}
