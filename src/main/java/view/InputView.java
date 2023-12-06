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
}
