package Database;

import java.util.ArrayList;
import java.util.HashMap;

import Model.*;
public class Database {
    private static Database database = null;
    private Database(){

    }

     static Database getInstance(){
        if(database==null){
            database = new Database();
        }
        return database;
    }
    private ArrayList<Item> itemList = new ArrayList<>();
    private final ArrayList<Manager> managerList = new ArrayList<>();
    private final ArrayList<SalesMan> salesManList = new ArrayList<>();
    private  HashMap<Item, Float> salesList = new HashMap<>();
    private  HashMap<Item, Float> purchaseList = new HashMap<>();


    HashMap<Item, Float> getSalesList(){
        return salesList;
    }

    HashMap<Item, Float> getPurchaseList(){
        return purchaseList;
    }

    ArrayList<Manager> getManagerList(){
        return managerList;
    }

    ArrayList<SalesMan> getSalesManList(){
        return salesManList;
    }
    ArrayList<Item> getItemList(){
        return itemList;
    }

    void setSalesList(HashMap<Item ,Float> newSalesList){
        salesList=newSalesList;
    }
    void setPurchaseList(HashMap<Item,Float> newPurchaseList ){
        purchaseList=newPurchaseList;
    }
    void setItemList(ArrayList<Item> newItemList){
        itemList=newItemList;
    }
    void addManager(Manager manager){
        managerList.add(manager);
    }
    void addSaleMan(SalesMan salesman){
        salesManList.add(salesman);
    }
    void addItem(Item item){
        itemList.add(item);
    }
    void removeItem(Item item){
        itemList.remove(item);
    }
    void addSales(Item id){
        salesList.put(id, (float) 0.0);
    }
    void addPurchase(Item id,float quantity){
        purchaseList.put(id,quantity);
    }

}
