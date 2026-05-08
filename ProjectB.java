import javafx.application.Application;
import javafx.stage.Stage;

public class ProjectB extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dapo Menu");

        Menu menu = new Menu();
        DapoController controller = new DapoController(menu);
        DapoView view = new DapoView();
        view.setController(controller); // input the controller

        view.start(primaryStage); // launch Dapo View, since the GUI is already setted there
    }

    public static void main(String[] args) {
        launch(args);
    }
}
