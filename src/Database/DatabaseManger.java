package Database;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;



public class DatabaseManger {

    Database database =Database.getInstance();

    HashMap<Item, Float> getSalesList(){
        return database.getSalesList();
    }

    HashMap<Item, Float> getPurchaseList(){
        return database.getPurchaseList();
    }

    ArrayList<Manager> getManagerList(){
        return database.getManagerList();
    }

    ArrayList<SalesMan> getSalesManList(){
        return database.getSalesManList();
    }
    ArrayList<Item> getItemList(){
        return database.getItemList();
    }

    void addSales(HashMap<Item ,Float> salesList){
       database.setSalesList(salesList);
    }
    void addPurchase(HashMap<Item ,Float> purchaseList){
        database.setPurchaseList(purchaseList);
    }
    void addManager(Manager manager){
        database.addManager(manager);
    }
    void addSaleMan(SalesMan salesMan){
        database.addSaleMan(salesMan);
    }
    void addItem(Item item){
        database.addItem(item);
    }
    void removeItem(Item item){
        database.removeItem(item);
    }
    void addSales(Item id){
        database.addSales(id);
    }
    void addPurchase(Item id,float quantity){
        database.addPurchase(id, quantity);
    }
    void updateItem(ArrayList<Item> itemList){
        database.setItemList(itemList);
    }
}
