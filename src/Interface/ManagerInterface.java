package Interface;
import Model.*;
public interface ManagerInterface {
    void addItem(Item item);
    void deleteItem(String itemId);
    void sales(String itemId,float salesQuantity);
    void purchase(String id,float purchaseQuantity);
    void showList();
}
