package Database;
import Interface.*;
import Model.Item;
import Model.Manager;
import Model.SalesMan;

public class DatabaseManger implements ManagerInterface,SalesmanInterface,OwnerInterface{

    @Override
    public void addItem(Item item, String Id) {

    }

    @Override
    public void deleteItem(String itemId, String Id) {

    }

    @Override
    public void sales(String itemId, float quantity, String Id) {

    }

    @Override
    public void purchase(String item, float quantity, String Id) {

    }

    @Override
    public void showList() {

    }

    @Override
    public void addManager(Manager manager) {

    }

    @Override
    public void addSalesman(SalesMan salesman) {

    }

    @Override
    public float salary(String empId, String designation) {
        return 0;
    }

    @Override
    public void turnover(int choice) {

    }
}
