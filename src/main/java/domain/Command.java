package domain;

import message.ErrorMessage;

import java.util.Comparator;

public enum Command {
    REGISTER(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    EXIT(3, "프로그램 종료");

    private final int code;
    private final String description;

    Command(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Command of(int code) {
        for (Command command : Command.values()) {
            if (command.code == code) {
                return command;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NO_COMMAND.getMessage());
    }

    public static Comparator<Command> codeComparator = Comparator.comparingInt(Command::getCode);

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
