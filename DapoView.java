import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Alert;
import java.util.Comparator;


public class DapoView extends Application {
    private Stage primaryStage;
    private DapoController controller;

    public void setController(DapoController controller) {
        this.controller = controller;
    }
    public static void main(String[] args) {
            DapoView.launch(args);
        }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        // Setting the main window title
        primaryStage.setTitle("Dapo Donburi");

        // Setting the main labels and positioning them to the center
        Label welcomeLabel = new Label("== DAPO ORDERING SYSTEM ==");
        welcomeLabel.setAlignment(Pos.CENTER);

        Label menu = new Label("MENU");
        menu.setAlignment(Pos.CENTER);

        // Buttons make an order, and call the order method
        // Setting the height and width of the buttons
        Button orderBeefDonBtn = new Button("Beef Don");
        orderBeefDonBtn.setPrefWidth(100);
        orderBeefDonBtn.setPrefHeight(100);
        orderBeefDonBtn.setOnAction(e -> {
            orderBeefDon();
        });

        Button orderBeefSteak = new Button("Beef Steak");
        orderBeefSteak.setPrefWidth(100);
        orderBeefSteak.setPrefHeight(100);
        orderBeefSteak.setOnAction(e -> {
            orderBeefSteak();
        });

        Button orderFishBtn = new Button("Plain Fish");
        orderFishBtn.setPrefWidth(100);
        orderFishBtn.setPrefHeight(100);
        orderFishBtn.setOnAction(e -> {
            orderFish();
        });

        Button orderFishDonBtn = new Button("Fish Don");
        orderFishDonBtn.setPrefWidth(100);
        orderFishDonBtn.setPrefHeight(100);
        orderFishDonBtn.setOnAction(e -> {
            orderFishDon();
        });

        Button orderTeaBtn = new Button("Tea");
        orderTeaBtn.setPrefWidth(100);
        orderTeaBtn.setPrefHeight(100);
        orderTeaBtn.setOnAction(e -> {
            orderTea();
        });

        Button orderCoffeeBtn = new Button("Coffee");
        orderCoffeeBtn.setPrefWidth(100);
        orderCoffeeBtn.setPrefHeight(100);
        orderCoffeeBtn.setOnAction(e -> {
            orderCoffee();
        });

        Button orderSoftDrinkBtn = new Button("Soft Drink");
        orderSoftDrinkBtn.setPrefWidth(100);
        orderSoftDrinkBtn.setPrefHeight(100);
        orderSoftDrinkBtn.setOnAction(e -> {
            orderSoftDrink();
        });

        Button showCartBtn = new Button("Show Cart");
        showCartBtn.setPrefWidth(100);
        showCartBtn.setPrefHeight(100);
        showCartBtn.setOnAction(e -> {
            showCart();
        });



        // Organizing the menu items
        HBox hbox1 = new HBox(orderBeefDonBtn, orderBeefSteak);
        HBox hbox2 = new HBox(orderFishBtn, orderFishDonBtn);
        HBox hbox3 = new HBox(orderTeaBtn, orderCoffeeBtn);
        HBox hbox4 = new HBox(orderSoftDrinkBtn, showCartBtn);

        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        hbox4.setAlignment(Pos.CENTER);

        hbox1.setSpacing(10);
        hbox2.setSpacing(10);
        hbox3.setSpacing(10);
        hbox4.setSpacing(10);

        VBox vbox1 = new VBox(welcomeLabel, menu, hbox1, hbox2, hbox3, hbox4);

        vbox1.setAlignment(Pos.CENTER);

        vbox1.setSpacing(10);

        Scene scene = new Scene(vbox1, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    // Ordering beef don
    private void orderBeefDon() {
        // Making this a popup window
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Beef Don Order");

        Label header = new Label("== BEEF DON ==");
        // Set header to center
        header.setAlignment(Pos.CENTER);

        // Beef type selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectBeefType = new Label("1. Select desired beef type:");

        // Making a RadioButton group
        ToggleGroup beefGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbAngus = new RadioButton("Angus ($13.00)");
        // Putting the RadioButton into the beefGroup ToggleGroup
        rbAngus.setToggleGroup(beefGroup);

        // RadioButton buttons
        RadioButton rbWagyu = new RadioButton("Wagyu ($16.00)");
        // Putting the RadioButton into the beefGroup ToggleGroup
        rbWagyu.setToggleGroup(beefGroup);

        // Doneness selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectDoneness = new Label("2. Choose desired doneness:");

        // Making a RadioButton group
        ToggleGroup donenessGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbRare = new RadioButton("Rare (+$1.00)");
        // Putting the RadioButton into the donenessGroup ToggleGroup
        rbRare.setToggleGroup(donenessGroup);

        RadioButton rbNormal = new RadioButton("Normal (+$0.00)");
        // Putting the RadioButton into the donenessGroup ToggleGroup
        rbNormal.setToggleGroup(donenessGroup);

        RadioButton rbWellDone = new RadioButton("Well Done (+$1.00)");
        // Putting the RadioButton into the donenessGroup ToggleGroup
        rbWellDone.setToggleGroup(donenessGroup);

        // Sauce selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectSauce = new Label("3. Select or enter desired sauce:");

        // Making a RadioButton group
        ToggleGroup sauceGroup = new ToggleGroup();
        
        RadioButton rbTeriyaki = new RadioButton("Teriyaki (+$0.00)");
        rbTeriyaki.setToggleGroup(sauceGroup);

        RadioButton rbOther = new RadioButton("Other (+$2.00)");
        rbOther.setToggleGroup(sauceGroup);

        // Making a text field for the user to enter their desired choice of sauce
        TextField tfOther = new TextField();
        tfOther.setPromptText("Enter desired sauce");
        
        // Disabling the 'Other' text field if the 'Other' RadioButton isnt chosen yet
        tfOther.setDisable(true);
        // Listener to detect when 'Other' RadioButton is selected, run the code inside the lambda function
        rbOther.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            // Sets the textfield to enabled/disabled when tfOther is selected/deselected
            tfOther.setDisable(!newValue);
        });

        Label selectEgg = new Label("4. Select desired egg:");

        // Making a RadioButton group
        ToggleGroup eggGroup = new ToggleGroup();

        // Adding buttons
        RadioButton rbSoft = new RadioButton("Soft Egg (+$0.00)");
        rbSoft.setToggleGroup(eggGroup);

        RadioButton rbScramble = new RadioButton("Scrambled Egg (+$3.00)");
        rbScramble.setToggleGroup(eggGroup);

        RadioButton rbCrepe = new RadioButton("Egg Crepe (+$3.00)");
        rbCrepe.setToggleGroup(eggGroup);

        // Add on with CheckBox because user can choose many add ons
        Label selectAddOn = new Label("5. Select desired add-ons:");

        CheckBox cbEdamame = new CheckBox("Edamame (+$3.00)");
        CheckBox cbExtraRice = new CheckBox("Extra Rice (+$3.00)");
        CheckBox cbSmallKaraage = new CheckBox("Small Karaage (+$6.00)");
        CheckBox cbMisoSoup = new CheckBox("Miso Soup (+$3.00)");
        CheckBox cbSalad = new CheckBox("Salad (+$3.00)");
        CheckBox cbNone = new CheckBox("None (+$0.00)");

        // Listener to detect when 'None' is selected, run the code inside the lambda function
        cbNone.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue) { // If 'None' is selected, uncheck and disable all the other choices
                cbEdamame.setSelected(false);
                cbExtraRice.setSelected(false);
                cbSmallKaraage.setSelected(false);
                cbMisoSoup.setSelected(false);
                cbSalad.setSelected(false);

                cbEdamame.setDisable(true);
                cbExtraRice.setDisable(true);
                cbSmallKaraage.setDisable(true);
                cbMisoSoup.setDisable(true);
                cbSalad.setDisable(true);
            } else { // Else, enable other choices when 'None' is deselected
                cbEdamame.setDisable(false);
                cbExtraRice.setDisable(false);
                cbSmallKaraage.setDisable(false);
                cbMisoSoup.setDisable(false);
                cbSalad.setDisable(false);
            }
        });

        VBox vbox1 =  new VBox(selectBeefType, rbAngus, rbWagyu);
        VBox vbox2 = new VBox(selectDoneness, rbRare, rbNormal, rbWellDone);
        VBox vbox3 = new VBox(selectSauce, rbTeriyaki, rbOther, tfOther);
        VBox vbox4 = new VBox(selectEgg, rbSoft, rbScramble, rbCrepe);
        VBox vbox5 = new VBox(selectAddOn, cbEdamame, cbExtraRice, cbSmallKaraage, cbMisoSoup, cbSalad, cbNone);


        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setSpacing(5);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setSpacing(5);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setSpacing(5);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setSpacing(5);
        vbox5.setAlignment(Pos.CENTER_LEFT);
        vbox5.setSpacing(5);

        Button addOrder = new Button("Add to Cart");
        addOrder.setOnAction(e -> {

            // Retrieving user input 1
            String beefTypeStr;
            if (rbAngus.isSelected()) {
                beefTypeStr = "Angus";
            } else if (rbWagyu.isSelected()) {
                beefTypeStr = "Wagyu";
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Beef Type Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving user input 2
            String donenessStr;
            if (rbRare.isSelected()) {
                donenessStr = "Rare";
            } else if (rbNormal.isSelected()) {
                donenessStr = "Normal";
            } else if (rbWellDone.isSelected()) {
                donenessStr = "Well Done";
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Doneness Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving user input 3
            String sauceStr;
            if (rbTeriyaki.isSelected()) {
                sauceStr = "Teriyaki";
            } else if (rbOther.isSelected()) {
                sauceStr = tfOther.getText();
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Sauce Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving EggType
            EggType eggType;
            if (rbSoft.isSelected()) {
                eggType = EggType.SOFT;
            } else if (rbScramble.isSelected()) {
                eggType = EggType.SCRAMBLE;
            } else if (rbCrepe.isSelected()) {
                eggType = EggType.EGGCREPE;
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Egg Type Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Building the objects
            BeefDon beefDonItem = new BeefDon(beefTypeStr, donenessStr, sauceStr, 0.0);
            Order order = new Order(beefDonItem, eggType);

            // Adding addons using independent if statements so multiple addons could be added
            if (cbEdamame.isSelected())  order.addAddOn(AddOn.EDAMAME);
            if (cbExtraRice.isSelected()) order.addAddOn(AddOn.EXTRA_RICE);
            if (cbSmallKaraage.isSelected()) order.addAddOn(AddOn.SMALL_KARAAGE);
            if (cbMisoSoup.isSelected()) order.addAddOn(AddOn.MISO_SOUP);
            if (cbSalad.isSelected()) order.addAddOn(AddOn.SALAD);

            // Adding the full item
            Menu.addToCart(order);

            // Throws up a confirmation window called Alert to alert the user of order added
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Order Added");
            alert1.setHeaderText("Order Added to Cart");
            alert1.setContentText(order.getOrderDetails());
            // Show and wait so that the code under this will wait until the alert is closed
            alert1.showAndWait();

            popupStage.close();
        });

        VBox root = new VBox(header, vbox1, vbox2, vbox3, vbox4, vbox5, addOrder);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        // Insets are used here as a padding, to make the selection options in the middle
        root.setPadding(new Insets(20, 100, 20, 100));
        // ScrollPane to store the root inside it and make the window scrollable
        ScrollPane scroll = new ScrollPane(root);
        scroll.setFitToHeight(true);
        scroll.setFitToWidth(true);
        Scene scene =  new Scene(scroll, 400, 400);
        popupStage.setScene(scene);
        popupStage.show();
    }

    // Ordring beef steak
    private void orderBeefSteak() {
        // Making this a popup window
        Stage popupStage = new Stage();
        popupStage.setTitle("Beef Steak");
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Beef Steak Order");

        Label header = new Label("== BEEF STEAK ==");
        // Set header to center
        header.setAlignment(Pos.CENTER);

        // Beef type selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectBeefType = new Label("1. Select desired beef type:");

        // Making a RadioButton group
        ToggleGroup beefGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbAngus = new RadioButton("Angus ($0.2/g)");
        // Putting the RadioButton into the beefGroup ToggleGroup
        rbAngus.setToggleGroup(beefGroup);

        // RadioButton buttons
        RadioButton rbWagyu = new RadioButton("Wagyu ($0.3/g)");
        // Putting the RadioButton into the beefGroup ToggleGroup
        rbWagyu.setToggleGroup(beefGroup);

        // Doneness selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectDoneness = new Label("2. Choose desired doneness:");

        // Making a RadioButton group
        ToggleGroup donenessGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbRare = new RadioButton("Rare (+$1.00)");
        // Putting the RadioButton into the donenessGroup ToggleGroup
        rbRare.setToggleGroup(donenessGroup);

        RadioButton rbNormal = new RadioButton("Normal (+$0.00)");
        // Putting the RadioButton into the donenessGroup ToggleGroup
        rbNormal.setToggleGroup(donenessGroup);

        RadioButton rbWellDone = new RadioButton("Well Done (+$1.00)");
        // Putting the RadioButton into the donenessGroup ToggleGroup
        rbWellDone.setToggleGroup(donenessGroup);

        // Sauce selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectSides = new Label("3. Select or enter desired sides:");

        // Making a RadioButton group
        ToggleGroup sidesGroup = new ToggleGroup();

        RadioButton rbOther = new RadioButton("Side Dish (+$0.00)");
        rbOther.setToggleGroup(sidesGroup);
        rbOther.setSelected(true);

        // Making a text field for the user to enter their desired choice of sauce
        TextField tfOther = new TextField();
        tfOther.setPromptText("Enter desired side dish");

        // TASKKKK: Ask user for weight
        // code here
        Label selectWeight = new Label("4. Drag to desired weight (grams):");

        // Utilizing the slider function as the weight adjuster
        Slider editWeight = new Slider(1, 500, 250);
        // Showing the marks
        editWeight.setShowTickMarks(true);
        // Showing the Labels
        editWeight.setShowTickLabels(true);
        // Setting the difference between big lines
        editWeight.setMajorTickUnit(100f);
        // Sets the diference between small lines
        editWeight.setBlockIncrement(0.5f);
        editWeight.setSnapToTicks(true);

        Label selectEgg = new Label("5. Select desired egg:");

        // Making a RadioButton group
        ToggleGroup eggGroup = new ToggleGroup();

        // Adding buttons
        RadioButton rbSoft = new RadioButton("Soft Egg (+$0.00)");
        rbSoft.setToggleGroup(eggGroup);

        RadioButton rbScramble = new RadioButton("Scrambled Egg (+$3.00)");
        rbScramble.setToggleGroup(eggGroup);

        RadioButton rbCrepe = new RadioButton("Egg Crepe (+$3.00)");
        rbCrepe.setToggleGroup(eggGroup);

        // Add on with CheckBox because user can choose many add ons
        Label selectAddOn = new Label("6. Select desired add-ons:");

        CheckBox cbEdamame = new CheckBox("Edamame (+$3.00)");
        CheckBox cbExtraRice = new CheckBox("Extra Rice (+$3.00)");
        CheckBox cbSmallKaraage = new CheckBox("Small Karaage (+$6.00)");
        CheckBox cbMisoSoup = new CheckBox("Miso Soup (+$3.00)");
        CheckBox cbSalad = new CheckBox("Salad (+$3.00)");
        CheckBox cbNone = new CheckBox("None (+$0.00)");

        // Listener to detect when 'None' is selected, run the code inside the lambda function
        cbNone.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue) { // If 'None' is selected, uncheck and disable all the other choices
                cbEdamame.setSelected(false);
                cbExtraRice.setSelected(false);
                cbSmallKaraage.setSelected(false);
                cbMisoSoup.setSelected(false);
                cbSalad.setSelected(false);

                cbEdamame.setDisable(true);
                cbExtraRice.setDisable(true);
                cbSmallKaraage.setDisable(true);
                cbMisoSoup.setDisable(true);
                cbSalad.setDisable(true);
            } else { // Else, enable other choices when 'None' is deselected
                cbEdamame.setDisable(false);
                cbExtraRice.setDisable(false);
                cbSmallKaraage.setDisable(false);
                cbMisoSoup.setDisable(false);
                cbSalad.setDisable(false);
            }
        });

        VBox vbox1 =  new VBox(selectBeefType, rbAngus, rbWagyu);
        VBox vbox2 = new VBox(selectDoneness, rbRare, rbNormal, rbWellDone);
        VBox vbox3 = new VBox(selectSides, rbOther, tfOther);
        VBox vbox4 = new VBox(selectEgg, rbSoft, rbScramble, rbCrepe);
        VBox vbox5 = new VBox(selectAddOn, cbEdamame, cbExtraRice, cbSmallKaraage, cbMisoSoup, cbSalad, cbNone);
        VBox vbox6 = new VBox(selectWeight, editWeight);


        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setSpacing(5);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setSpacing(5);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setSpacing(5);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setSpacing(5);
        vbox5.setAlignment(Pos.CENTER_LEFT);
        vbox5.setSpacing(5);
        vbox6.setAlignment(Pos.CENTER_LEFT);
        vbox6.setSpacing(5);

        Button addOrder = new Button("Add to Cart");
        addOrder.setOnAction(e -> {

            // Retrieving user input 1
            String beefTypeStr;
            if (rbAngus.isSelected()) {
                beefTypeStr = "Angus";
            } else if (rbWagyu.isSelected()) {
                beefTypeStr = "Wagyu";
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Beef Type Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving user input 2
            String donenessStr;
            if (rbRare.isSelected()) {
                donenessStr = "Rare";
            } else if (rbNormal.isSelected()) {
                donenessStr = "Normal";
            } else if (rbWellDone.isSelected()) {
                donenessStr = "Well Done";
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Doneness Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving user input 3
            String sidesStr;
            if (!tfOther.getText().isEmpty()) {
                sidesStr = tfOther.getText();
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Sides Entered");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving EggType
            EggType eggType;
            if (rbSoft.isSelected()) {
                eggType = EggType.SOFT;
            } else if (rbScramble.isSelected()) {
                eggType = EggType.SCRAMBLE;
            } else if (rbCrepe.isSelected()) {
                eggType = EggType.EGGCREPE;
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Egg Type Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Building the objects
            double weight = editWeight.getValue();
            BeefSteak beefSteakItem = new BeefSteak(beefTypeStr, donenessStr, weight, sidesStr, 0.0);
            Order order = new Order(beefSteakItem, eggType);

            // Adding addons using independent if statements so multiple addons could be added
            if (cbEdamame.isSelected())  order.addAddOn(AddOn.EDAMAME);
            if (cbExtraRice.isSelected()) order.addAddOn(AddOn.EXTRA_RICE);
            if (cbSmallKaraage.isSelected()) order.addAddOn(AddOn.SMALL_KARAAGE);
            if (cbMisoSoup.isSelected()) order.addAddOn(AddOn.MISO_SOUP);
            if (cbSalad.isSelected()) order.addAddOn(AddOn.SALAD);

            // Adding the full item
            Menu.addToCart(order);

            // Throws up a confirmation window called Alert to alert the user of order added
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Order Added");
            alert1.setHeaderText("Order Added to Cart");
            alert1.setContentText(order.getOrderDetails());
            // Show and wait so that the code under this will wait until the alert is closed
            alert1.showAndWait();

            popupStage.close();
        });

        VBox root = new VBox(header, vbox1, vbox2, vbox3, vbox6, vbox4, vbox5, addOrder);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        // Insets are used here as a padding, to make the selection options in the middle
        root.setPadding(new Insets(20, 100, 20, 100));
        // ScrollPane to store the root inside it and make the window scrollable
        ScrollPane scroll = new ScrollPane(root);
        scroll.setFitToHeight(true);
        scroll.setFitToWidth(true);
        Scene scene =  new Scene(scroll, 400, 400);
        popupStage.setScene(scene);
        popupStage.show();
    }

    private void orderFish() {
        // Making this a popup window
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Fish Order");

        Label header = new Label("== PLAIN FISH ==");
        // Set header to center
        header.setAlignment(Pos.CENTER);

        // Fish type selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectFishType = new Label("1. Select desired fish type:");

        // Making a RadioButton group
        ToggleGroup fishGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbSalmon = new RadioButton("Salmon ($15.00)");
        // Putting the RadioButton into the fishGroup ToggleGroup
        rbSalmon.setToggleGroup(fishGroup);

        // RadioButton buttons
        RadioButton rbTuna = new RadioButton("Tuna ($13.00)");
        // Putting the RadioButton into the fishGroup ToggleGroup
        rbTuna.setToggleGroup(fishGroup);

        RadioButton rbOther = new RadioButton("Other ($12.00)");
        // Putting the RadioButton into the fishGroup ToggleGroup
        rbOther.setToggleGroup(fishGroup);

        // Making a text field for the user to enter their desired choice of fish type
        TextField tfOther = new TextField();
        tfOther.setPromptText("Enter desired fish type");
        
        // Disabling the 'Other' text field if the 'Other' RadioButton isnt chosen yet
        tfOther.setDisable(true);
        // Listener to detect when 'Other' RadioButton is selected, run the code inside the lambda function
        rbOther.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            // Sets the textfield to enabled/disabled when tfOther is selected/deselected
            tfOther.setDisable(!newValue);
        });

        // CookingStyle selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectCookingStyle = new Label("2. Choose desired cooking style:");

        // Making a RadioButton group
        ToggleGroup cookingStyleGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbCooked = new RadioButton("Cooked (+$0.00)");
        // Putting the RadioButton into the cookingStyleGroup ToggleGroup
        rbCooked.setToggleGroup(cookingStyleGroup);

        RadioButton rbSashimi = new RadioButton("Sashimi (+$5.00)");
        // Putting the RadioButton into the cookingStyleGroup ToggleGroup
        rbSashimi.setToggleGroup(cookingStyleGroup);

        Label selectEgg = new Label("5. Select desired egg:");

        // Making a RadioButton group
        ToggleGroup eggGroup = new ToggleGroup();

        // Adding buttons
        RadioButton rbSoft = new RadioButton("Soft Egg (+$0.00)");
        rbSoft.setToggleGroup(eggGroup);

        RadioButton rbScramble = new RadioButton("Scrambled Egg (+$3.00)");
        rbScramble.setToggleGroup(eggGroup);

        RadioButton rbCrepe = new RadioButton("Egg Crepe (+$3.00)");
        rbCrepe.setToggleGroup(eggGroup);

        VBox vbox1 =  new VBox(selectFishType, rbSalmon, rbTuna, rbOther, tfOther);
        VBox vbox2 = new VBox(selectCookingStyle, rbCooked, rbSashimi);
        VBox vbox4 = new VBox(selectEgg, rbSoft, rbScramble, rbCrepe);

        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setSpacing(5);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setSpacing(5);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setSpacing(5);

        Button addOrder = new Button("Add to Cart");
        addOrder.setOnAction(e -> {
            // Retrieving user input 1
            String fishTypeStr;
            if (rbSalmon.isSelected()) {
                fishTypeStr = "Salmon";
            } else if (rbTuna.isSelected()) {
                fishTypeStr = "Tuna";
            } else if (rbOther.isSelected()) {
                fishTypeStr = tfOther.getText();
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Fish Type Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving user input 2
            String cookingStyleStr;
            if (rbCooked.isSelected()) {
                cookingStyleStr = "Cooked";
            } else if (rbSashimi.isSelected()) {
                cookingStyleStr = "Sashimi";
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Cooking Style Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving EggType
            EggType eggType;
            if (rbSoft.isSelected()) {
                eggType = EggType.SOFT;
            } else if (rbScramble.isSelected()) {
                eggType = EggType.SCRAMBLE;
            } else if (rbCrepe.isSelected()) {
                eggType = EggType.EGGCREPE;
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Egg Type Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Building the objects
            Fish fishItem = new Fish(fishTypeStr, cookingStyleStr, 0.0);
            Order order = new Order(fishItem, eggType);

            // Adding the full item
            Menu.addToCart(order);

            // Throws up a confirmation window called Alert to alert the user of order added
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Order Added");
            alert1.setHeaderText("Order Added to Cart");
            alert1.setContentText(order.getOrderDetails());
            // Show and wait so that the code under this will wait until the alert is closed
            alert1.showAndWait();

            popupStage.close();
        });

        VBox root = new VBox(header, vbox1, vbox2, vbox4, addOrder);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        // Insets are used here as a padding, to make the selection options in the middle
        root.setPadding(new Insets(20, 100, 20, 100));
        // ScrollPane to store the root inside it and make the window scrollable
        ScrollPane scroll = new ScrollPane(root);
        scroll.setFitToHeight(true);
        scroll.setFitToWidth(true);
        Scene scene =  new Scene(scroll, 400, 400);
        popupStage.setScene(scene);
        popupStage.show();
    }

    // Order fish don
    private void orderFishDon() {
        // Making this a popup window
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Fish Don Order");

        Label header = new Label("== FISH DON ==");
        // Set header to center
        header.setAlignment(Pos.CENTER);

        // Fish type selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectFishType = new Label("1. Select desired fish type:");

        // Making a RadioButton group
        ToggleGroup fishGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbSalmon = new RadioButton("Salmon ($15.00)");
        // Putting the RadioButton into the fishGroup ToggleGroup
        rbSalmon.setToggleGroup(fishGroup);

        // RadioButton buttons
        RadioButton rbTuna = new RadioButton("Tuna ($13.00)");
        // Putting the RadioButton into the fishGroup ToggleGroup
        rbTuna.setToggleGroup(fishGroup);

        RadioButton rbOther = new RadioButton("Other ($12.00)");
        // Putting the RadioButton into the fishGroup ToggleGroup
        rbOther.setToggleGroup(fishGroup);

        // Making a text field for the user to enter their desired choice of fish type
        TextField tfOther = new TextField();
        tfOther.setPromptText("Enter desired fish type");
        
        // Disabling the 'Other' text field if the 'Other' RadioButton isnt chosen yet
        tfOther.setDisable(true);
        // Listener to detect when 'Other' RadioButton is selected, run the code inside the lambda function
        rbOther.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            // Sets the textfield to enabled/disabled when tfOther is selected/deselected
            tfOther.setDisable(!newValue);
        });

        // CookingStyle selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectCookingStyle = new Label("2. Choose desired cooking style:");

        // Making a RadioButton group
        ToggleGroup cookingStyleGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbCooked = new RadioButton("Cooked (+$0.00)");
        // Putting the RadioButton into the cookingStyleGroup ToggleGroup
        rbCooked.setToggleGroup(cookingStyleGroup);

        RadioButton rbSashimi = new RadioButton("Sashimi (+$5.00)");
        // Putting the RadioButton into the cookingStyleGroup ToggleGroup
        rbSashimi.setToggleGroup(cookingStyleGroup);

        Label selectEgg = new Label("5. Select desired egg:");

        // Making a RadioButton group
        ToggleGroup eggGroup = new ToggleGroup();

        // Adding buttons
        RadioButton rbSoft = new RadioButton("Soft Egg (+$0.00)");
        rbSoft.setToggleGroup(eggGroup);

        RadioButton rbScramble = new RadioButton("Scrambled Egg (+$3.00)");
        rbScramble.setToggleGroup(eggGroup);

        RadioButton rbCrepe = new RadioButton("Egg Crepe (+$3.00)");
        rbCrepe.setToggleGroup(eggGroup);

        // Add on with CheckBox because user can choose many add ons
        Label selectTopping = new Label("6. Select desired add-ons:");

        CheckBox cbChips = new CheckBox("Chips (+$2.00)");
        CheckBox cbAvocado = new CheckBox("Avocado (+$3.00)");
        CheckBox cbTruffle = new CheckBox("Truffle (+$8.00)");

        VBox vbox1 =  new VBox(selectFishType, rbSalmon, rbTuna, rbOther, tfOther);
        VBox vbox2 = new VBox(selectCookingStyle, rbCooked, rbSashimi);
        VBox vbox4 = new VBox(selectEgg, rbSoft, rbScramble, rbCrepe);
        VBox vbox5 =  new VBox(selectTopping, cbChips, cbAvocado, cbTruffle);

        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setSpacing(5);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setSpacing(5);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setSpacing(5);
        vbox5.setAlignment(Pos.CENTER_LEFT);
        vbox5.setSpacing(5);

        Button addOrder = new Button("Add to Cart");
        addOrder.setOnAction(e -> {
            // Retrieving user input 1
            String fishTypeStr;
            if (rbSalmon.isSelected()) {
                fishTypeStr = "Salmon";
            } else if (rbTuna.isSelected()) {
                fishTypeStr = "Tuna";
            } else if (rbOther.isSelected()) {
                fishTypeStr = tfOther.getText();
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Fish Type Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving user input 2
            String cookingStyleStr;
            if (rbCooked.isSelected()) {
                cookingStyleStr = "Cooked";
            } else if (rbSashimi.isSelected()) {
                cookingStyleStr = "Sashimi";
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Cooking Style Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Retrieving EggType
            EggType eggType;
            if (rbSoft.isSelected()) {
                eggType = EggType.SOFT;
            } else if (rbScramble.isSelected()) {
                eggType = EggType.SCRAMBLE;
            } else if (rbCrepe.isSelected()) {
                eggType = EggType.EGGCREPE;
            } else {
                // Throws up an error window called Alert to alert the user of missing choice
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Egg Type Selected");
                // Show and wait so that the code under this will wait until the alert is closed
                alert.showAndWait();
                // Stop the code here so none of the code below runs
                return;
            }

            // Building the objects
            FishDon fishDonItem = new FishDon(fishTypeStr, cookingStyleStr, 0.0);
            fishDonItem.setEggType(eggType);
            Order order = new Order(fishDonItem, eggType);

            // Adding addons using independent if statements so multiple addons could be added
            if (cbChips.isSelected()) fishDonItem.addTopping("Chips");
            if (cbAvocado.isSelected()) fishDonItem.addTopping("Avocado");
            if (cbTruffle.isSelected()) fishDonItem.addTopping("Truffle");

            // Adding the full item
            Menu.addToCart(order);

            // Throws up a confirmation window called Alert to alert the user of order added
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Order Added");
            alert1.setHeaderText("Order Added to Cart");
            alert1.setContentText(order.getOrderDetails());
            // Show and wait so that the code under this will wait until the alert is closed
            alert1.showAndWait();

            popupStage.close();
        });

        VBox root = new VBox(header, vbox1, vbox2, vbox4, vbox5, addOrder);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        // Insets are used here as a padding, to make the selection options in the middle
        root.setPadding(new Insets(20, 100, 20, 100));
        // ScrollPane to store the root inside it and make the window scrollable
        ScrollPane scroll = new ScrollPane(root);
        scroll.setFitToHeight(true);
        scroll.setFitToWidth(true);
        Scene scene =  new Scene(scroll, 400, 400);
        popupStage.setScene(scene);
        popupStage.show();
    }

    private void orderTea() {
        // Making this a popup window
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Tea Order");

        Label header = new Label("== TEA ==");
        // Set header to center
        header.setAlignment(Pos.CENTER);

        // Size selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectSize = new Label("1. Select desired size:");

        // Making a RadioButton group
        ToggleGroup sizeGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbSmall = new RadioButton("Small ($1.00)");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbSmall.setToggleGroup(sizeGroup);

        // RadioButton buttons
        RadioButton rbMedium = new RadioButton("Medium ($1.50)");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbMedium.setToggleGroup(sizeGroup);

        RadioButton rbLarge = new RadioButton("Large ($3.00)");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbLarge.setToggleGroup(sizeGroup);

        Label selectGreenTea = new Label("2. Do you prefer Green Tea?");

        // Making a RadioButton group
        ToggleGroup greenTeaGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbYes = new RadioButton("Yes");
        // Putting the RadioButton into the greenTea ToggleGroup
        rbYes.setToggleGroup(greenTeaGroup);

        RadioButton rbNo = new RadioButton("No");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbNo.setToggleGroup(greenTeaGroup);

        // Editing sugar levels (optional)
        Label selectEditSugar = new Label("3. Edit sugar level (optional):");

        // Utilizing the slider function as the sugar adjuster
        Slider editSugarSlider = new Slider(0, 2, 1);
        // Showing the marks
        editSugarSlider.setShowTickMarks(true);
        // Showing the Labels
        editSugarSlider.setShowTickLabels(true);
        // Setting the difference between big lines
        editSugarSlider.setMajorTickUnit(0.5f);
        // Sets the diference between small lines
        editSugarSlider.setBlockIncrement(0.1f);

        ToggleGroup editSugarGroup = new ToggleGroup();

        // Automatically moves the slider when selects an option
        RadioButton editSugarLess = new RadioButton("Less Sugar");
        editSugarLess.setToggleGroup(editSugarGroup);
        editSugarLess.setOnAction(e -> {
            editSugarSlider.setValue(0.5);
        });

        // Automatically moves the slider when selects an option
        RadioButton editSugarNormal = new RadioButton("Normal");
        editSugarNormal.setToggleGroup(editSugarGroup);
        editSugarNormal.setOnAction(e -> {
            editSugarSlider.setValue(1);
        });

        // Automatically moves the slider when selects an option
        RadioButton editSugarExtra = new RadioButton("Extra Sugar");
        editSugarExtra.setToggleGroup(editSugarGroup);
        editSugarExtra.setOnAction(e -> {
            editSugarSlider.setValue(1.5);
        });

        // Disabling sugar level option when moving slider
        editSugarSlider.setOnDragDetected(e -> {
            editSugarLess.setSelected(false);
            editSugarNormal.setSelected(false);
            editSugarExtra.setSelected(false);
        });

        // Add on with CheckBox because user can choose many add ons
        Label selectTopping = new Label("4. Select desired toppings:");

        CheckBox cbHoney = new CheckBox("Honey");
        CheckBox cbLemon = new CheckBox("Lemon");

        VBox vbox1 =  new VBox(selectSize, rbSmall, rbMedium, rbLarge);
        VBox vbox2 = new VBox(selectGreenTea, rbYes, rbNo);
        VBox vbox4 = new VBox(selectEditSugar, editSugarSlider, editSugarLess, editSugarNormal, editSugarExtra);
        VBox vbox5 =  new VBox(selectTopping, cbHoney, cbLemon);

        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setSpacing(5);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setSpacing(5);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setSpacing(5);
        vbox5.setAlignment(Pos.CENTER_LEFT);
        vbox5.setSpacing(5);

        Button addOrder = new Button("Add to Cart");
        addOrder.setOnAction(e -> {
            // Retrieve user input 1
            String sizeStr;
            if (rbSmall.isSelected()) {
                sizeStr = "Small";
            } else if (rbMedium.isSelected()) {
                sizeStr = "Medium";
            } else if (rbLarge.isSelected()) {
                sizeStr = "Large";
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Size Selected");
                alert.showAndWait();
                return;
            }

            // Retrieve user input 2
            boolean isGreenTea;
            if (rbYes.isSelected()) {
                isGreenTea = true;
            } else if (rbNo.isSelected()) {
                isGreenTea = false;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Green Tea Preference Selected");
                alert.showAndWait();
                return;
            }

            Tea teaItem = new Tea(sizeStr, 0.0, isGreenTea);
            
            // Retrieve slider input
            double sugarLevel = editSugarSlider.getValue();
            teaItem.editSugar(sugarLevel);

            // Retreive toppings
            if (cbHoney.isSelected()) teaItem.addTopping("Honey");
            if (cbLemon.isSelected()) teaItem.addTopping("Lemon");

            Order order = new Order(teaItem, null);
            Menu.addToCart(order);

            // Throws up a confirmation window called Alert to alert the user of order added
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Order Added");
            alert1.setHeaderText("Order Added to Cart");
            alert1.setContentText(order.getOrderDetails());
            // Show and wait so that the code under this will wait until the alert is closed
            alert1.showAndWait();

            popupStage.close();
        });

        VBox root = new VBox(header, vbox1, vbox2, vbox4, vbox5, addOrder);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        // Insets are used here as a padding, to make the selection options in the middle
        root.setPadding(new Insets(20, 100, 20, 100));
        // ScrollPane to store the root inside it and make the window scrollable
        ScrollPane scroll = new ScrollPane(root);
        scroll.setFitToHeight(true);
        scroll.setFitToWidth(true);
        Scene scene =  new Scene(scroll, 400, 400);
        popupStage.setScene(scene);
        popupStage.show();
    }

    private void orderCoffee() {
        // Making this a popup window
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Coffee Order");

        Label header = new Label("== COFFEE ==");
        // Set header to center
        header.setAlignment(Pos.CENTER);

        // Size selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectSize = new Label("1. Select desired size:");

        // Making a RadioButton group
        ToggleGroup sizeGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbSmall = new RadioButton("Small ($1.00)");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbSmall.setToggleGroup(sizeGroup);

        // RadioButton buttons
        RadioButton rbMedium = new RadioButton("Medium ($1.50)");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbMedium.setToggleGroup(sizeGroup);

        RadioButton rbLarge = new RadioButton("Large ($3.5)");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbLarge.setToggleGroup(sizeGroup);

        Label selectEspresso = new Label("2. Do you prefer Espresso?");

        // Making a RadioButton group
        ToggleGroup espressoGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbYes = new RadioButton("Yes");
        // Putting the RadioButton into the espressoGroup ToggleGroup
        rbYes.setToggleGroup(espressoGroup);

        RadioButton rbNo = new RadioButton("No");
        // Putting the RadioButton into the espressoGroup ToggleGroup
        rbNo.setToggleGroup(espressoGroup);

        Label selectShot = new Label("3. Would you like an extra shot?");

        // Making a RadioButton group
        ToggleGroup shotGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbYes1 = new RadioButton("Yes");
        // Putting the RadioButton into the shotGroup ToggleGroup
        rbYes1.setToggleGroup(shotGroup);

        RadioButton rbNo1 = new RadioButton("No");
        // Putting the RadioButton into the shotGroup ToggleGroup
        rbNo1.setToggleGroup(shotGroup);

        VBox vbox1 =  new VBox(selectSize, rbSmall, rbMedium, rbLarge);
        VBox vbox2 = new VBox(selectEspresso, rbYes, rbNo);
        VBox vbox4 = new VBox(selectShot, rbYes1, rbNo1);

        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setSpacing(5);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setSpacing(5);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setSpacing(5);

        Button addOrder = new Button("Add to Cart");
        addOrder.setOnAction(e -> {
            // Retrieve user input 1
            String sizeStr;
            if (rbSmall.isSelected()) {
                sizeStr = "Small";
            } else if (rbMedium.isSelected()) {
                sizeStr = "Medium";
            } else if (rbLarge.isSelected()) {
                sizeStr = "Large";
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Size Selected");
                alert.showAndWait();
                return;
            }

            // Retrieve user input 2
            boolean isEspresso;
            if (rbYes.isSelected()) {
                isEspresso = true;
            } else if (rbNo.isSelected()) {
                isEspresso = false;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Espresso Preference Selected");
                alert.showAndWait();
                return;
            }

            boolean extraShot;
            if (rbYes1.isSelected()) {
                extraShot = true;
            } else if (rbNo1.isSelected()) {
                extraShot = false;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Extra Shot Preference Selected");
                alert.showAndWait();
                return;
            }

            Coffee coffeeItem = new Coffee(sizeStr, 0.0, isEspresso);

            // Checks for extra shot, then updates the object
            if (extraShot) coffeeItem.addExtraShot();

            Order order = new Order(coffeeItem, null);
            Menu.addToCart(order);

            // Throws up a confirmation window called Alert to alert the user of order added
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Order Added");
            alert1.setHeaderText("Order Added to Cart");
            alert1.setContentText(order.getOrderDetails());
            // Show and wait so that the code under this will wait until the alert is closed
            alert1.showAndWait();

            popupStage.close();
        });

        VBox root = new VBox(header, vbox1, vbox2, vbox4, addOrder);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        // Insets are used here as a padding, to make the selection options in the middle
        root.setPadding(new Insets(20, 100, 20, 100));
        // ScrollPane to store the root inside it and make the window scrollable
        ScrollPane scroll = new ScrollPane(root);
        scroll.setFitToHeight(true);
        scroll.setFitToWidth(true);
        Scene scene =  new Scene(scroll, 400, 400);
        popupStage.setScene(scene);
        popupStage.show();
    }

    private void orderSoftDrink() {
        // Making this a popup window
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Soft Drink Order");

        Label header = new Label("== SOFT DRINK ==");
        // Set header to center
        header.setAlignment(Pos.CENTER);

        // Size selection using RadioButton (Similar to CheckBox, however, RadioButton eliminates the possibility of user choosing more than 1 choice)
        Label selectSize = new Label("1. Select desired size:");

        // Making a RadioButton group
        ToggleGroup sizeGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbSmall = new RadioButton("Small ($1.00)");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbSmall.setToggleGroup(sizeGroup);

        // RadioButton buttons
        RadioButton rbMedium = new RadioButton("Medium ($1.50)");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbMedium.setToggleGroup(sizeGroup);

        RadioButton rbLarge = new RadioButton("Large ($3.00)");
        // Putting the RadioButton into the sizeGroup ToggleGroup
        rbLarge.setToggleGroup(sizeGroup);

        Label selectDiet = new Label("2. Do you prefer Diet?");

        // Making a RadioButton group
        ToggleGroup dietGroup = new ToggleGroup();

        // RadioButton buttons
        RadioButton rbYes = new RadioButton("Yes");
        // Putting the RadioButton into the dietGroup ToggleGroup
        rbYes.setToggleGroup(dietGroup);

        RadioButton rbNo = new RadioButton("No");
        // Putting the RadioButton into the dietGroup ToggleGroup
        rbNo.setToggleGroup(dietGroup);

        // Editing sugar levels (optional)
        Label selectEditSugar = new Label("3. Add ice amount (optional):");

        // Utilizing the slider function as the sugar adjuster
        Slider editIceSlider = new Slider(0, 10, 5);
        // Showing the marks
        editIceSlider.setShowTickMarks(true);
        // Showing the Labels
        editIceSlider.setShowTickLabels(true);
        // Setting the difference between big lines
        editIceSlider.setMajorTickUnit(2.5f);
        // Sets the diference between small lines
        editIceSlider.setBlockIncrement(0.5f);

        ToggleGroup editIceGroup = new ToggleGroup();

        // Automatically moves the slider when selects an option
        RadioButton editIceLess = new RadioButton("Less Ice");
        editIceLess.setToggleGroup(editIceGroup);
        editIceLess.setOnAction(e -> {
            editIceSlider.setValue(2.5);
        });

        // Automatically moves the slider when selects an option
        RadioButton editIceNormal = new RadioButton("Normal");
        editIceNormal.setToggleGroup(editIceGroup);
        editIceNormal.setOnAction(e -> {
            editIceSlider.setValue(5);
        });

        // Automatically moves the slider when selects an option
        RadioButton editIceExtra = new RadioButton("Extra Ice");
        editIceExtra.setToggleGroup(editIceGroup);
        editIceExtra.setOnAction(e -> {
            editIceSlider.setValue(7.5);
        });

        // Disabling sugar level option when moving slider
        editIceSlider.setOnDragDetected(e -> {
            editIceLess.setSelected(false);
            editIceNormal.setSelected(false);
            editIceExtra.setSelected(false);
        });

        VBox vbox1 =  new VBox(selectSize, rbSmall, rbMedium, rbLarge);
        VBox vbox2 = new VBox(selectDiet, rbYes, rbNo);
        VBox vbox4 = new VBox(selectEditSugar, editIceSlider, editIceLess, editIceNormal, editIceExtra);

        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setSpacing(5);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setSpacing(5);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setSpacing(5);

        Button addOrder = new Button("Add to Cart");
        addOrder.setOnAction(e -> {
            // Retrieve user input 1
            String sizeStr;
            if (rbSmall.isSelected()) {
                sizeStr = "Small";
            } else if (rbMedium.isSelected()) {
                sizeStr = "Medium";
            } else if (rbLarge.isSelected()) {
                sizeStr = "Large";
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Size Selected");
                alert.showAndWait();
                return;
            }

            // Retrieve user input 2
            boolean isDiet;
            if (rbYes.isSelected()) {
                isDiet = true;
            } else if (rbNo.isSelected()) {
                isDiet = false;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("No Diet preference Selected");
                alert.showAndWait();
                return;
            }

            SoftDrink softDrinkItem = new SoftDrink(sizeStr, 0.0, isDiet);

            // Retrieve slider input
            double iceLevel = editIceSlider.getValue();
            softDrinkItem.addIce(iceLevel);

            Order order = new Order(softDrinkItem, null);
            Menu.addToCart(order);

            // Throws up a confirmation window called Alert to alert the user of order added
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Order Added");
            alert1.setHeaderText("Order Added to Cart");
            alert1.setContentText(order.getOrderDetails());
            // Show and wait so that the code under this will wait until the alert is closed
            alert1.showAndWait();

            popupStage.close();
        });

        VBox root = new VBox(header, vbox1, vbox2, vbox4, addOrder);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        // Insets are used here as a padding, to make the selection options in the middle
        root.setPadding(new Insets(20, 100, 20, 100));
        // ScrollPane to store the root inside it and make the window scrollable
        ScrollPane scroll = new ScrollPane(root);
        scroll.setFitToHeight(true);
        scroll.setFitToWidth(true);
        Scene scene =  new Scene(scroll, 400, 400);
        popupStage.setScene(scene);
        popupStage.show();
    }

    private void showCart() {
        // Create a new window
        Stage cartStage = new Stage();
        cartStage.initModality(Modality.APPLICATION_MODAL);
        cartStage.setTitle("Cart");

        // Header
        Label header = new Label("== ORDER CART ==");
        header.setAlignment(Pos.CENTER);

        // Creating TableView for 'Order' objects
        TableView<Order> tableView = new TableView();

        // Column for item name
        TableColumn<Order, String> itemCol = new TableColumn<>("Item");
        itemCol.setCellValueFactory(cellData -> 
            new SimpleStringProperty(cellData.getValue().getName())
        );
        itemCol.setPrefWidth(90);

        // Column for order details (item name, type, doneness, etc.)
        TableColumn<Order, String> detailsCol = new TableColumn<>("Details");
        detailsCol.setCellValueFactory(cellData -> 
            new SimpleStringProperty(cellData.getValue().getOrderDetails())
        );
        detailsCol.setPrefWidth(600);

        // Column for total price
        TableColumn<Order, Number> priceCol = new TableColumn<>("Price ($)");
        priceCol.setCellValueFactory(cellData -> 
        new SimpleDoubleProperty(cellData.getValue().getTotalPrice())
        );
        priceCol.setPrefWidth(90);

        tableView.getColumns().addAll(itemCol, detailsCol, priceCol);

        tableView.setItems(Menu.getCart());

        // Binding label to show total price
        Label totalLabel = new Label();
        totalLabel.textProperty().bind(
            Menu.totalPriceProperty().asString("Total: $%.2f")
        );

        // Modify/Remove an item function
        Button removeBtn = new Button("Remove Selected Item");
        removeBtn.setPrefWidth(200);
        removeBtn.setOnAction(e -> {
            Order selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Menu.removeFromCart(selected);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Modify Cart");
                alert.setHeaderText("No Item Selected");
                alert.showAndWait();
                return;
            }

            // Throws up a confirmation window called Alert to alert the user of order added
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Modify Cart");
            alert1.setHeaderText("Selected Item Removed");
            alert1.showAndWait();
        });

        Button clearBtn = new Button("Clear Order Cart");
        clearBtn.setPrefWidth(200);
        clearBtn.setOnAction(e -> {
            Menu.clearCart();

            // Throws up a confirmation window called Alert to alert the user of order added
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Modify Cart");
            alert1.setHeaderText("Order Cart Cleared");
            alert1.showAndWait();
        });

        Button addOrderBtn = new Button("Add More Items");
        addOrderBtn.setPrefWidth(200);
        addOrderBtn.setOnAction(e -> {
            cartStage.close();
        });

        // TEST THIS BUTTON LASTTT!!!!! SINCE KILLS THE WHOLE ORDERING SYSTEM
        Button checkoutBtn = new Button("Confirm Checkout");
        checkoutBtn.setPrefWidth(200);
        checkoutBtn.setOnAction(e -> {
            // Checkout window
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Dapo Ordered");
            alert1.setHeaderText("Thank you for your order!");
            alert1.setContentText("Total Price: " + Menu.totalPriceProperty().get());
            alert1.showAndWait();

            cartStage.close();
            primaryStage.close();
        });

        // Editing items button
        Button editItemBtn = new Button("Modify Selected Item");
        editItemBtn.setPrefWidth(200);
        editItemBtn.setOnAction(e -> {
            Order selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                // Find the class that the object belongs to
                MenuItem item = selected.getMenuItem();
                // Edit method
                if (item instanceof BeefDon) {
                    // Asks the user to order once more
                    orderBeefDon();
                    // Remove the selected item, since user is ordering again
                    Menu.removeFromCart(selected);
                } else if (item instanceof BeefSteak) {
                    orderBeefSteak();
                    Menu.removeFromCart(selected);
                } else if (item instanceof FishDon) {
                    orderFishDon();
                    Menu.removeFromCart(selected);
                } else if (item instanceof Fish) {
                    orderFish();
                    Menu.removeFromCart(selected);
                } else if (item instanceof Tea) {
                    orderTea();
                    Menu.removeFromCart(selected);
                } else if (item instanceof Coffee) {
                    orderCoffee();
                    Menu.removeFromCart(selected);
                } else if (item instanceof SoftDrink) {
                    orderSoftDrink();
                    Menu.removeFromCart(selected);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Modify Cart");
                    alert.setHeaderText("No Item Selected");
                    alert.showAndWait();
                    return;
                }
            }
        });

        // Sorting label
        Label sortLabel = new Label("Sort by:");

        // Sorting combobox
        ComboBox<String> sortBox = new ComboBox<>();
        // Adding all the sorting options
        sortBox.getItems().addAll(
            "Price: Low -> High",
            "Price: High -> Low",
            "Alphabetical: Ascending",
            "Alphabetical: Descending"
        );

        sortBox.setOnAction(e -> {
            // Getting the items from the tableview
            ObservableList<Order> items = tableView.getItems();
            // Checks the user choice
            String choice = sortBox.getValue();
            // Sorting the items
            if (choice.equals("Price: Low -> High")) FXCollections.sort(items, Comparator.comparingDouble(Order::getTotalPrice));
            else if (choice.equals("Price: High -> Low")) FXCollections.sort(items, Comparator.comparingDouble(Order::getTotalPrice).reversed());
            else if (choice.equals("Alphabetical: Ascending")) FXCollections.sort(items, Comparator.comparing(Order::getName));
            else if (choice.equals("Alphabetical: Descending")) FXCollections.sort(items, Comparator.comparing(Order::getName).reversed());

        });

        // Layout
        HBox hbox1 = new HBox(10, removeBtn, addOrderBtn);
        HBox hbox2 = new HBox(10, clearBtn, editItemBtn);
        HBox hbox3 = new HBox(10, checkoutBtn);
        VBox vbox1 = new VBox(sortLabel, sortBox);
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        vbox1.setAlignment(Pos.CENTER_LEFT);

        VBox root = new VBox(header, vbox1, tableView, totalLabel, hbox1, hbox2, hbox3);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 800, 400);
        cartStage.setScene(scene);
        cartStage.showAndWait();
    }
}
