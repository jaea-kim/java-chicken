package controller;

import domain.menu.Menu;
import domain.menu.MenuRepository;
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
        //메뉴 선택
        //메뉴 수량 입력
        //주문 객체 + 테이블 상태 테이블 객체 업데이트 -> 레포 저장
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
