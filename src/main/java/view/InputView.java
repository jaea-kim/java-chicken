package view;

import camp.nextstep.edu.missionutils.Console;
import message.ErrorMessage;

public class InputView {
    public static int inputCommandCode() {
        try {
            System.out.println("## 원하는 기능을 선택하세요.");
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NO_COMMAND.getMessage());
        }
    }

    public static int inputTableNumber() {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NO_MENU.getMessage());
        }
    }

    public static int inputMenuNumber() {
        try {
            System.out.println("## 등록할 메뉴를 선택하세요.");
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NO_MENU.getMessage());
        }
    }

    public static int inputMenuAmount() {
        try {
            System.out.println("## 메뉴의 수량을 입력하세요.");
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NO_MENU_COUNT.getMessage());
        }
    }
}
