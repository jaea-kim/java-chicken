package controller;

import domain.Command;
import view.InputView;
import view.OutputView;

import java.util.Arrays;

public class MainController {
    private final RegisterController registerController;
    private final PaymentController paymentController;

    public MainController(RegisterController registerController, PaymentController paymentController) {
        this.registerController = registerController;
        this.paymentController = paymentController;
    }

    public void execute() {
        while (true) {
            OutputView.printMainView(Arrays.asList(Command.values()));
            Command command = inputCommand();
            if (command.equals(Command.EXIT)) {
                break;
            }
            if (command.equals(Command.REGISTER)) {
                registerController.execute();
            }
            if (command.equals(Command.PAYMENT)) {
                paymentController.execute();
            }
        }
    }

    public Command inputCommand() {
        while (true) {
            try {
                int code = InputView.inputCommandCode();
                return Command.of(code);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }
}
