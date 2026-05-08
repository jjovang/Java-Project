import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleDoubleProperty;


import javafx.beans.property.SimpleBooleanProperty;

enum EggType {
    SOFT(0.0), SCRAMBLE(3.0), EGGCREPE(3.0) ;

    private final SimpleDoubleProperty addedCost = new SimpleDoubleProperty();

    public final SimpleDoubleProperty addedCostProperty() {
        return addedCost;
    }
    EggType(double addedCost) {
        setAddedCostProperty(addedCost);
    }

    public double getAddedCostProperty() {
        return addedCostProperty().get();
    }
    public void setAddedCostProperty(final double addedCost) {
            this.addedCostProperty().set(addedCost);;
    }
    public String toString() {
        if (this == SOFT) {
            return "Soft Egg" ;
        } else if (this == SCRAMBLE) {
            return "Scramble egg" ;
        } else {
            return "Egg Crepe" ;
        }
    }

}

enum AddOn {
    EDAMAME(3.0), EXTRA_RICE(3.0), SMALL_KARAAGE(6.0), MISO_SOUP(3.0), SALAD(3.0), NONE(0.0);
    private final SimpleDoubleProperty addedCost = new SimpleDoubleProperty();

    private final SimpleDoubleProperty addedCostProperty() {
        return addedCost;
    }

    AddOn(double addedCost) { 
        setAddedCostProperty(addedCost);; 
    }
    
    public void setAddedCostProperty(final double addedCost) {
        this.addedCostProperty().set(addedCost);;
    }

    public double getAddedCostProperty() { 
        return addedCostProperty().get(); 
    }

    public String toString() {
        if (this == EDAMAME) {
            return "Edamame" ;
        } else if (this == EXTRA_RICE) {
            return "Extra rice" ;
        } else if (this == SMALL_KARAAGE) {
            return "Small Karage" ;
        } else if (this == MISO_SOUP) {
            return "Miso Soup" ;
        }else if (this == NONE) {
            return "None" ;
        } else {
            return "Salad" ;
        }
    }
}

abstract class MenuItem {
    protected SimpleDoubleProperty price = new SimpleDoubleProperty(0);

    private final SimpleDoubleProperty priceProperty() {
        return price;
    }

    MenuItem(double price) {
        setPriceProperty(price);
    }

    //Abstract method
    abstract double getTotalPrice();
    abstract String description();

    //accessor mutator
    public double getPriceProperty() {
         return priceProperty().get() ;
    }
    public void setPriceProperty(double price) {
        this.priceProperty().set(price);
    }
}

interface RedMeat {
    void setDonenessAndPrice(String doneness);
}

interface Seafood {
    void cookingStyleAndPrice(String cookingStyle);
}

class Beef extends MenuItem implements RedMeat {
    protected SimpleStringProperty beefType, doneness;

    private SimpleStringProperty beefTypeProperty() {
        return beefType;
    }
    private SimpleStringProperty donenesProperty() {
        return doneness;
    }

    Beef(String beefType, String doneness, double price) {
        super(price);
        this.beefType = new SimpleStringProperty();
        this.doneness = new SimpleStringProperty();
        setBeefTypeProperty(beefType);;
        setDonenessProperty(doneness);

        //To update the price 
        beefPrice();
        setDonenessAndPrice(this.donenesProperty().get());
    }
    //Accessor and mutator
    public void setBeefTypeProperty(String beefType) {
        this.beefTypeProperty().set(beefType);
    }
    public void setDonenessProperty(String doneness) {
        this.donenesProperty().set(doneness);;
    }
    public String getBeefTypeProperty() {
        return beefTypeProperty().get();
    }
    public String getDonenessProperty() {
        return donenesProperty().get();
    }

    // Unique method
    public void beefPrice() {
        // Depend on beef type
        String type = getBeefTypeProperty();
        if (type.equals("Angus")) {
            price.set(price.get() + 13);
        } else if (type.equals("Wagyu")) {
            price.set(price.get() + 16);;
        }
    }

    //Override interface
    @Override
    public void setDonenessAndPrice(String doneness) {
        if (!doneness.equals("Normal")) {
            price.set(price.get() + 1);
        }
    }

    // Override MenuItem
    @Override
    double getTotalPrice() {
        return price.get();
    }

    @Override
    String description() {
        return "Beef type : " + beefType.get() + " | Doneness : " + doneness.get();
    }
}

class BeefDon extends Beef {
    protected SimpleStringProperty sauce ;


    private final SimpleStringProperty sauceProperty() {
        return sauce;
    }
    BeefDon(String beefType, String doneness, String sauce, double price) {
        super(beefType, doneness, price);
        this.sauce = new SimpleStringProperty();
        setSauceProperty(sauce); 
        saucePriceProperty();
    }

    //Accessor and mutator
    public void setSauceProperty(String sauce) {
        this.sauceProperty().set(sauce);;
    }
    public String getSauceProperty() {
        return sauceProperty().get();
    }

    //Uniq method
    public void saucePriceProperty() {
        String sauceType = getSauceProperty();
        if(!sauceType.equals("Teriyaki")) {
            price.set(price.get() + 2);
        }
    }

    @Override
    double getTotalPrice() {
        return price.get();
    }
    @Override
    String description() {
        return "Beef type : " + beefType.get() + " | Doneness : " + doneness.get() + " | Sauce : " + sauce.get();
    }

    public String toString(){
        return description();
    }
}

class BeefSteak extends Beef {
    protected SimpleDoubleProperty weight;
    protected SimpleStringProperty sideDish;

    private final SimpleDoubleProperty weighProperty() {
        return weight;
    }
    private final SimpleStringProperty sideDishProperty() {
        return sideDish;
    }

    BeefSteak(String beefType, String doneness, double weight, String sideDish, double price) {
        super(beefType, doneness, price); 
        this.weight = new SimpleDoubleProperty();
        this.sideDish = new SimpleStringProperty();
        setWeightProperty(weight);
        setSideDishProperty(sideDish);
        priceByWeight();
    }

    //Accessor and mutator
    public void setWeightProperty(double weight) {
        this.weighProperty().set(weight);;
    }
    public void setSideDishProperty(String sideDish) {
        this.sideDishProperty().set(sideDish);;
    }
    public double getWeightProperty() {
        return weighProperty().get();
    }
    public String getSideDishProperty() {
        return sideDishProperty().get();
    }

    // Uniqmethod 
    void priceByWeight() {
        double pricePerGram = 0;
        String type = getBeefTypeProperty();
        String doneness = getDonenessProperty(); // assuming you have this getter
    
        if (type.equals("Angus")) {
            pricePerGram = 0.2;
        } else if (type.equals("Wagyu")) {
            pricePerGram = 0.3;
        }
    
        double basePrice = pricePerGram * getWeightProperty();
    
        // Add doneness modifier
        if (doneness.equals("Rare") || doneness.equals("Well Done")) {
            basePrice += 1.0;
        }
    
        price.set(basePrice);
    }
    
    @Override
    public String description() {
        return beefType.get() + " Steak | Weight : " + weight.get() + " | Side dish : " + sideDish.get(); 
    }

    public String toString() {
        return description();
    }
}

class Fish extends MenuItem implements Seafood {
    protected SimpleStringProperty fishType, cookingStyle;

    private final SimpleStringProperty fishTypeProperty() {
        return fishType;
    }
    private final SimpleStringProperty cookingStyleProperty() {
        return cookingStyle;
    }

    Fish(String fishType, String cookingStyle, double price) {
        super(price);
        this.fishType = new SimpleStringProperty();
        this.cookingStyle = new SimpleStringProperty();
        setFishTypeProperty(fishType);
        setCookingStyleProperty(cookingStyle);
        fishPrice();
        cookingStyleAndPrice(cookingStyle);
    }

    //Accessor mutator
    public void setFishTypeProperty(String fishType) {
        this.fishTypeProperty().set(fishType);
    }
    public void setCookingStyleProperty(String cookingStyle) {
        this.cookingStyleProperty().set(cookingStyle);
    }
    public String getFishTypeProperty() {
        return fishTypeProperty().get();
    }
    public String getCookingStyleProperty() {
        return cookingStyleProperty().get();
    }

    void fishPrice() {
        String type = getFishTypeProperty() ;

        if(type.equals("Salmon")) {
            price.set(getPriceProperty() + 15);
        } else if (type.equals("Tuna")) {
            price.set(getPriceProperty() + 13);
        } else {
            price.set(getPriceProperty() + 12);
        }
    }

    @Override
    public void cookingStyleAndPrice(String cookingStyle) {
        if (!cookingStyle.equals("Cooked")) {
            price.set(getPriceProperty() + 5);
        }
    }

    @Override
    public String description() {
        return "Fish : " + fishType.get() + " | Cooking style : " + cookingStyle.get();
    }

    @Override
    double getTotalPrice() {
        return price.get();
    }

    public String toString() {
        return description();
    }
}

class FishDon extends Fish {
    protected ObservableList<String> choosenToppings;
    protected SimpleDoubleProperty baseFishPrice;
    private EggType eggType = EggType.SOFT; 

    private final ObservableList<String> choosenToppingsProperty() {
        return choosenToppings;
    }

    private final SimpleDoubleProperty baseFishPriceProperty() {
        return baseFishPrice;
    }

    public FishDon(String fishType, String cookingStyle, double price) {
        super(fishType, cookingStyle, price);
        this.baseFishPrice = new SimpleDoubleProperty(super.getTotalPrice()); 
        this.choosenToppings = FXCollections.observableArrayList();
        updatePrice(); 
    }

    // Accessors and mutators
    public void setChoosenToppings(ObservableList<String> choosenToppings) {
        if (choosenToppings == null) {
            choosenToppings = FXCollections.observableArrayList();
        } else {
            this.choosenToppings = choosenToppings;
        }
        updatePrice();
    }

    public void setBaseFishPriceProperty(double baseFishPrice) {
        this.baseFishPriceProperty().set(baseFishPrice);
        updatePrice();
    }

    public void addTopping(String addedTopping) {
        choosenToppings.add(addedTopping);
        updatePrice();
    }

    public void removeTopping(String topping) {
        choosenToppings.remove(topping);
        updatePrice();
    }

    public void setEggType(EggType eggType) {
        this.eggType = eggType;
        updatePrice();
    }

    public void updatePrice() {
        double total = baseFishPrice.get(); 

        for (String topping : choosenToppings) {
            switch (topping) {
                case "Chips" -> total += 2;
                case "Avocado" -> total += 3;
                case "Truffle" -> total += 8;
            }
        }

        if (eggType != null) {
            total += eggType.getAddedCostProperty(); 
        }

        price.set(total); 
    }

    @Override
    public String description() {
        return cookingStyle.get() + " " + fishType.get() + " don | Toppings : " + choosenToppings;
    }

    @Override
    public String toString() {
        return description();
    }
}


abstract class Drink extends MenuItem {
    protected SimpleStringProperty size;

    private final SimpleStringProperty sizeProperty() {
        return size;
    }

    public Drink(String size, double price) {
        super(price);
        this.size = new SimpleStringProperty(size);
    }

    //accessor mutator
    public void setSizeProperty(String size) {
        sizeProperty().set(size);
    }
    public String getSizeProperty() {
        return sizeProperty().get();
    }

    abstract void updatePrice();
    abstract String description();
}

class Tea extends Drink {
    protected SimpleBooleanProperty isGreenTea;

    private final SimpleBooleanProperty isGreenTeaProperty() {
        return isGreenTea;
    }

    public Tea(String size, double price, boolean isGreenTea) {
        super(size, price);
        this.isGreenTea = new SimpleBooleanProperty(isGreenTea);
        updatePrice();
    }

    //Accessor mutator
    public void setIsGreenTeaProperty(boolean isGreenTea) {
        this.isGreenTeaProperty().set(isGreenTea);
    }
    public boolean getIsGreenTeaProperty() {
        return isGreenTeaProperty().get();
    }

    @Override
    void updatePrice() {
        String type = getSizeProperty();
        // Update price based on size
        if (type.equals("Medium")) {
            price.set(getPriceProperty() + 1.5);
        } else if (type.equals("Large")) {
            price.set(getPriceProperty() + 3);
        } else if (type.equals("Small")) {
            price.set(getPriceProperty() + 1);
        }

        // Additional price for green tea
        if (getIsGreenTeaProperty()) {
            price.set(getPriceProperty() + 1);; // Extra for green tea
        }
    }

    public void addTopping(String topping) {
        if (topping.equals("Honey")) {
            price.set(getPriceProperty() + 0.5);
        } else if (topping.equals("Lemon")) {
            price.set(getPriceProperty() + 0.3); 
        }
    }

    //Overload
    public void editSugar(double amount) {
        price.set(getPriceProperty() + (amount * 0.1));
    }

    @Override
    public String description() {
        String teaType = "" ;
        if (getIsGreenTeaProperty()) {
            teaType = "Green Tea" ;
        } else {
            teaType = "Regular Tea";
        }
        return "Tea " + size.get() + " | Type: " + teaType;
    }

    @Override
    double getTotalPrice() {
        return price.get();
    }

    public String toString() {
        return description();
    }
}

class Coffee extends Drink {
    protected SimpleBooleanProperty isEspresso;

    private final SimpleBooleanProperty isEspressoProperty() {
        return isEspresso;
    }

    public Coffee(String size, double price, boolean isEspresso) {
        super(size, price);
        this.isEspresso = new SimpleBooleanProperty(isEspresso);
        updatePrice();
    }

    //Accessor mutator
    public void setIsEspressoProperty(boolean isEspresso) {
        this.isEspressoProperty().set(isEspresso);;
    }
    public boolean getIsEspressoProperty() {
        return isEspressoProperty().get();
    }
    @Override
    void updatePrice() {
        // Update price based on size
        String sizeType = getSizeProperty();
        if (sizeType.equals("Medium")) {
            price.set(getPriceProperty() + 2);
        } else if (sizeType.equals("Large")) {
            price.set(getPriceProperty() + 3.5);
        } else if (sizeType.equals("Small")) {
            price.set(getPriceProperty() + 1);
        }

        // Additional price for Espresso
        if (getIsEspressoProperty()) {
            price.set(getPriceProperty() + 1.5); // Extra for Espresso
        }
    }

    public void addExtraShot() {
        price.set(getPriceProperty() + 2.0); // Add cost for extra shot
    }

    @Override
    public String description() {
        // User-friendly description
        String coffeeType = "";
        if (getIsEspressoProperty()) {
            coffeeType = "Espresso" ;
        } else {
            coffeeType = "Regular Coffee";
        }
        return coffeeType + " | Size : " + size.get();
    }

    @Override
    double getTotalPrice() {
        return price.get();
    }

    public String toString() {
        return description();
    }
}

class SoftDrink extends Drink {
    protected SimpleBooleanProperty isDiet;

    private final SimpleBooleanProperty isDietProperty() {
        return isDiet;
    }

    public SoftDrink(String size, double price, boolean isDiet) {
        super(size, price);
        this.isDiet = new SimpleBooleanProperty(isDiet);
        updatePrice();
    }

    //Accessor mutator
    public void setIsDietProperty(boolean isDiet) {
        this.isDietProperty().set(isDiet);
    }
    public boolean getIsDietProperty() {
        return isDietProperty().get();
    }

    @Override
    void updatePrice() {
        if (size.get().equals("Medium")) {
            price.set(getPriceProperty() + 1.5);
        } else if (size.get().equals("Large")) {
            price.set(getPriceProperty() + 2.5);
        } else if (size.get().equals("Small")) {
            price.set(getPriceProperty() + 1);
        }
        if (getIsDietProperty()) {
            price.set(getPriceProperty() - 0.5);
        }
    }

    public void addIce(double amount) {
        price.set(getPriceProperty() + (amount*0.1)); 
    }

    @Override
    public String description() {
        // User-friendly description
        String dietType = "";
        if (getIsDietProperty()) {
            dietType = "Diet";
        } else {
            dietType = "Regular" ;
        }
        return "Soft Drink " + size.get() + " | Type: " + dietType;
    }

    @Override
    double getTotalPrice() {
        return price.get();
    }

    public String toString() {
        return description();
    }
}

class Order {
    protected MenuItem menuItem;
    protected EggType eggType;
    protected ObservableList<AddOn> addOns;    

    public Order(MenuItem menuItem, EggType eggType) {
        this.menuItem = menuItem;
        if (menuItem instanceof BeefDon || menuItem instanceof BeefSteak || menuItem instanceof Fish || menuItem instanceof FishDon) {
            this.eggType = eggType;
            double base = menuItem.getTotalPrice();
            menuItem.price.set(base + eggType.getAddedCostProperty());
        } else {
            this.eggType = null;
        }
        this.addOns = FXCollections.observableArrayList();
    }

    public void addAddOn(AddOn addOn) {
        addOns.add(addOn);
        menuItem.price.set(getTotalPrice() + addOn.getAddedCostProperty()); 
    }        

    public void removeAddOn(AddOn addOn) {
        if (addOns.remove(addOn)) {
            menuItem.price.set(getTotalPrice() - addOn.getAddedCostProperty());
        }
    }

    public double getTotalPrice() {
        if (menuItem instanceof BeefDon || menuItem instanceof BeefSteak || menuItem instanceof Fish || menuItem instanceof FishDon) {
            double total = menuItem.getTotalPrice();
            return total;
        } else {
            double total = menuItem.getTotalPrice();
            return total;
        }        
    }

    public String getOrderDetails() {
        String addOnsDescription;
        if (addOns.isEmpty()) {
            addOnsDescription = "N/A" ;
        } else {
            addOnsDescription = "";
            for (int i = 0; i < addOns.size(); i++) {
                addOnsDescription += addOns.get(i).toString();
                if (i < addOns.size() - 1) {
                    addOnsDescription += ", ";
                }
            }
        }

        String eggDescription;
        if (eggType != null) {
            eggDescription = "Egg: " + eggType;
        } else {
            eggDescription = "Egg: N/A";
        }

        String itemDetails = menuItem.toString();
        return itemDetails + " | " + eggDescription + " | Add-ons: " + addOnsDescription;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public EggType getEggType() {
        return eggType;
    }

    public ObservableList<AddOn> getAddOns() {
        return addOns;
    }

    public void setEggType(EggType eggType) {
        this.eggType = eggType;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public String getName() {
        if (menuItem instanceof BeefDon) return "Beef Don";
        else if (menuItem instanceof BeefSteak) return "Beef Steak";
        else if (menuItem instanceof FishDon) return "Fish Don";
        else if (menuItem instanceof Fish) return "Plain Fish";
        else if (menuItem instanceof Tea) return "Tea";
        else if (menuItem instanceof Coffee) return "Coffee";
        else if (menuItem instanceof SoftDrink) return "Soft Drink";
        else return "N/A";
    }
}

class Menu {
    private static ObservableList<Order> cart = FXCollections.observableArrayList();
    private static SimpleDoubleProperty totalPrice = new SimpleDoubleProperty(0.0);
    
    public static SimpleDoubleProperty totalPriceProperty() {
        return totalPrice;
    }
    
    public static double getTotalPrice() {
        return totalPrice.get();
    }
    
    public static void addToCart(Order order) {
        cart.add(order);
        updateTotalPrice();
    }
    
    public static void removeFromCart(Order order) {
        cart.remove(order);
        updateTotalPrice();
    }
    
    public static void clearCart() {
        cart.clear();
        updateTotalPrice();
    }
    
    public static ObservableList<Order> getCart() {
        return cart;
    }
    
    public static void updateTotalPrice() {
        double total = 0;
        for (Order item : cart) {
            total += item.getTotalPrice();
        }
        totalPrice.set(total);
    }
}    