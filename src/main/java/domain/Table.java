package domain;

public class Table {
    private final int number;
    private TableStatus status;

    public Table(final int number) {
        this.number = number;
        status = TableStatus.DISABLE;
    }

    //TODO: 활성화여부 boolean 타입으로 반환하도록
    public TableStatus getTableStatus() {
        return status;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
