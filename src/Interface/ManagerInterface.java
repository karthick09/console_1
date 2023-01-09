package Interface;
import Model.*;
public interface ManagerInterface {
    void addItem(Item item,String Id);
    void deleteItem(String itemId,String Id);
    void sales(String itemId,float quantity,String Id);
    void purchase(String item,float quantity,String Id);
    void showList();
}
