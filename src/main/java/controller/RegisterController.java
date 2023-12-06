package controller;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Order;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RegisterController {
    public void execute() {
        printTableInfo();
        Table table = inputTable();
        printMenuInfo();
        Order order = inputOrder();
        registerOrder(table, order);
    }

    private void registerOrder(Table table, Order order) {
        try {
            table.updateOrder(order);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private Order inputOrder() {
        Menu menu = inputMenu();
        return createOrderWith(menu);
    }

    private Order createOrderWith(Menu menu) {
        while (true) {
            try {
                int amount = InputView.inputMenuAmount();
                return new Order(menu, amount);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private Menu inputMenu() {
        while (true) {
            try {
                int menuNumber = InputView.inputMenuNumber();
                return MenuRepository.findByMenuNumber(menuNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private void printMenuInfo() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private Table inputTable() {
        while (true) {
            try {
                int tableNumber = InputView.inputTableNumber();
                return TableRepository.findByTableNumber(tableNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private void printTableInfo() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
    }
}
