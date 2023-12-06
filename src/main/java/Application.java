import controller.MainController;
import controller.PaymentController;
import controller.RegisterController;

public class Application {
    public static void main(String[] args) {
        RegisterController registerController = new RegisterController();
        PaymentController paymentController = new PaymentController();

        MainController mainController = new MainController(registerController, paymentController);
        mainController.execute();
    }
}
