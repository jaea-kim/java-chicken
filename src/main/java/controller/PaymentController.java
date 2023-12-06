package controller;

import domain.Payment;
import domain.table.Order;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PaymentController {
    private static final int DISCOUNT_THRESHOLD = 10;
    private static final int DISCOUNT_PER_THRESHOLD_ITEMS = 10000;
    private static final double DISCOUNT_RATE = 0.05;

    public void execute() {
        printTableInfo();
        Table table = inputTable();
        try {
            printOrderInfo(table);
            Payment payment = payment(table);
            int totalPaymentAmount = calculatePaymentAmount(table, payment);
            OutputView.printTotalPaymentAmount(totalPaymentAmount);
            table.payment();
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private int calculatePaymentAmount(Table table, Payment payment) {
        int discountAmount = calculateMenuAmountDiscount(table);
        return calculatePaymentDiscount(table.getTotalPaymentAmount() - discountAmount, payment);
    }

    private int calculatePaymentDiscount(int basedAmount, Payment payment) {
        if (payment.equals(Payment.CASH)) {
            double discountAmount = basedAmount * DISCOUNT_RATE;
            int discountedAmount = (int) (basedAmount - discountAmount);

            return discountedAmount;
        }
        return basedAmount;
    }

    private int calculateMenuAmountDiscount(Table table) {
        int menuAmount = table.getTotalAmount();
        return (menuAmount / DISCOUNT_THRESHOLD) * DISCOUNT_PER_THRESHOLD_ITEMS;
    }

    private Payment payment(Table table) {
        OutputView.printPaymentTable(table.getNumber());
        return inputPaymentType();
    }

    private Payment inputPaymentType() {
        while (true) {
            try {
                int paymentCode = InputView.inputPaymentCode();
                return Payment.of(paymentCode);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
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
