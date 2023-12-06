package view;

import domain.Command;
import domain.menu.Menu;
import domain.table.Order;
import domain.table.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String STATUS_ACTIVE_FORMAT = "└ # ┘";
    private static final String STATUS_DISABLE_FORMAT = "└ ─ ┘";
    private static final String COMMAND_FORMAT = "%d - %s%n";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printTableStatus(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printTableStatus(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(tableStatus(table.isDisable()));
        }
        System.out.println();
    }

    private static String tableStatus(boolean tableStatus) {
        if (tableStatus) {
            return STATUS_DISABLE_FORMAT;
        }
        return STATUS_ACTIVE_FORMAT;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMainView(List<Command> commands) {
        System.out.println("## 메인 화면");
        commands.sort(Command.codeComparator);
        printCommands(commands);
    }

    private static void printCommands(final List<Command> commands) {
        for (Command command : commands) {
            System.out.printf(COMMAND_FORMAT, command.getCode(), command.getDescription());
        }
        System.out.println();
    }

    public static void printOrders(final List<Order> orders) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }

    public static void printPaymentTable(int number) {
        System.out.printf("## %d번 테이블의 결제를 진행합니다.%n", number);
    }

    public static void printTotalPaymentAmount(int totalPaymentAmount) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(totalPaymentAmount + "원");
    }
}
