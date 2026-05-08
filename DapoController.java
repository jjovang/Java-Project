import javafx.collections.ObservableList;

public class DapoController {
    private Menu menu;

    public DapoController(Menu menu) {
        this.menu = menu;
    }

    public void addOrder(Order order) {
        Menu.addToCart(order);
    }

    public void removeOrder(Order order) {
        Menu.removeFromCart(order);
    }

    public void clearCart() {
        Menu.clearCart();
    }

    public ObservableList<Order> getCart() {
        return Menu.getCart();
    }

    public double getTotalPrice() {
        return Menu.getTotalPrice();
    }
}
