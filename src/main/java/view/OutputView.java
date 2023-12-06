package view;

import domain.Command;
import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String STATUS_FORMAT = "└ %s ┘";
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
            System.out.printf(STATUS_FORMAT, table.getTableStatus().getMessage());
        }
        System.out.println();
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
}
