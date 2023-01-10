package Database;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;



public class DatabaseManger {

    Database database =Database.getInstance();

    HashMap<String, Float> getSalesList(){
        return database.getSalesList();
    }

    HashMap<String, Float> getPurchaseList(){
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

    void addSales(HashMap<String ,Float> salesList){
       database.setSalesList(salesList);
    }
    void addPurchase(HashMap<String ,Float> purchaseList){
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
    void addSales(String id){
        database.addSales(id, (float) 0.0);
    }
    void addPurchase(String id,float quantity){
        database.addPurchase(id, quantity);
    }
    void updateItem(ArrayList<Item> itemList){
        database.setItemList(itemList);
    }
}
