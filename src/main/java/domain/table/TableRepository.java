package domain.table;

import message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table findByTableNumber(int tableNumber) {
        for (Table table : tables) {
            if (table.eqaulsTableNumber(tableNumber)) {
                return table;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NO_TABLE.getMessage());
    }
}
