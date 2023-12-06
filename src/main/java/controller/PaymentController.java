package controller;

import domain.table.Order;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PaymentController {
    public void execute() {
        printTableInfo();
        Table table = inputTable();
        try {
            printOrderInfo(table);
            //결제 유형 입력
            //할인 계산
            //최종 결제 금액 계산
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private void printOrderInfo(Table table) {
        final List<Order> orders = table.getOrders();
        OutputView.printOrders(orders);
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
