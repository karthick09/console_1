package Database;

import Interface.ManagerInterface;
import Interface.OwnerInterface;
import Interface.SalesmanInterface;
import Model.Account;
import Model.Item;
import Model.Manager;
import Model.SalesMan;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Application implements ManagerInterface, SalesmanInterface, OwnerInterface {
    DatabaseManger databaseManger =new DatabaseManger();
    @Override
    public void addItem(Item item) {
        databaseManger.addItem(item);
        databaseManger.addSales(item.getItemId());
        databaseManger.addPurchase(item.getItemId(), item.getQuantity());
    }

    @Override
    public void deleteItem(String itemId) {
        Item item;
        item=getItem(itemId);
        if(item != null){
            databaseManger.removeItem(item);
        }
        else
        {
            System.out.println("item not found");
        }
    }

    @Override
    public void sales(String itemId, float salesQuantity) {
        Item item;
        float updateQuantity;
        item=getItem(itemId);
        if(item!= null){
            if (salesQuantity<=item.getQuantity()){
                float price;
                price=salesQuantity* item.getItemPrice();
                System.out.println("the total amount rs:"+price);
                updateQuantity= item.getQuantity()-salesQuantity;
                updateItem(item,updateQuantity);
                updateSalesList(item,salesQuantity);
            }
            else {
                System.out.println("insufficient stock");
                System.out.println("available stock is "+item.getQuantity());
            }
        }
        else {
            System.out.println("item not found");
        }
    }

    @Override
    public void purchase(String id, float purchaseQuantity) {
        Item item;
        float updateQuantity;
        item=getItem(id);
        if(item != null){
            updateQuantity= item.getQuantity()+purchaseQuantity;
            updateItem(item,updateQuantity);
            updatePurchaseList(item,purchaseQuantity);
        }
        else {
            System.out.println("item not found");
        }
    }

    @Override
    public void showList() {
        ArrayList<Item> itemList=databaseManger.getItemList();
        for(Item i : itemList){
            System.out.println("item id :"+i.getItemId()+" --item name :"+i.getItemName()+" --item price :"+i.getItemPrice()+" --item quantity :"+i.getQuantity());
        }
    }

    @Override
    public void addManager(Manager manager) {
        databaseManger.addManager(manager);
    }

    @Override
    public void addSalesman(SalesMan salesman) {
        databaseManger.addSaleMan(salesman);
    }

    @Override
    public void salary(String empId, int designation) {
        float salary;
        if(designation==1){
            Manager manger=getManager(empId);
            if (manger != null) {
                LocalDate doj=manger.getDateOfJoin();
                LocalDate presentDate=LocalDate.now();
                long noOfDays= ChronoUnit.DAYS.between(doj,presentDate);
                salary=(float)noOfDays/30;
                salary=Math.round(salary);
                salary=salary*20000;
                System.out.println("Salary:"+salary);
            }
            else {
                System.out.println("manager not found");
            }
        }
        else if(designation==2){
            SalesMan salesMan=getSalesMan(empId);
            if(salesMan != null){
                LocalDate doj=salesMan.getDateOfJoin();
                LocalDate presentDate=LocalDate.now();
                long noOfDays=ChronoUnit.DAYS.between(doj,presentDate);
                salary=(float)noOfDays/30;
                salary=salary*15000;
                salary=Math.round(salary);
                System.out.println("Salary:"+salary);
            }
            else {
                System.out.println("salesman not found");
            }
        }
        else {
            System.out.println("designation not found ");
        }
    }

    @Override
    public void turnover(int choice) {
        if(choice==1){
            HashMap<String, Float> salesList = databaseManger.getSalesList();
            for (Map.Entry<String, Float> entry : salesList.entrySet()) {
                Item item=getItem(entry.getKey());
                if (item != null) {
                    System.out.println("item id :"+entry.getKey()+" item name :"+item.getItemName()+" total sales count "+entry.getValue());
                }
                else{
                    System.out.println("item id :"+entry.getKey()+" total sales count "+entry.getValue());
                }
            }
        }
        else if (choice==2){
            HashMap<String, Float> purchaseList  = databaseManger.getPurchaseList();
            for (Map.Entry<String, Float> entry : purchaseList.entrySet()) {
                Item item=getItem(entry.getKey());
                if (item != null) {
                    System.out.println("item id :"+entry.getKey()+"item name:"+item.getItemName()+" total purchase count "+entry.getValue());
                }
                else {
                    System.out.println("item id :"+entry.getKey()+" total purchase count "+entry.getValue());

                }
            }
        }
        else {
            System.out.println("invalid choice");
        }

    }
    Item getItem(String id){
        for (Item I : databaseManger.getItemList()) {
            if (id.equals(I.getItemId())) {
                return I;
            }
        }
        return null;
    }
    public Manager getManager(String id){
        for (Manager m : databaseManger.getManagerList()) {
            Account account=m.getAccount();
            if (id.equals(account.getId()) || id.equals(m.getMangerId())) {
                return m;
            }
        }
        return null;
    }
    public SalesMan getSalesMan(String id){
        for (SalesMan SM : databaseManger.getSalesManList()) {
            Account account=SM.getAccount();
            if (id.equals(account.getId()) || id.equals(SM.getSalesManId())) {
                return SM;
            }
        }
        return null;
    }
    public boolean getLoginDetails(String id,String password,int choice){
        if(choice==2){
            for(Manager p : databaseManger.getManagerList()){
                Account account =p.getAccount();
                if(id.equals(account.getId()) && password.equals(account.getPassword())){
                    return true;
                }
            }
        }
        else if(choice==3){
            for(SalesMan p : databaseManger.getSalesManList()){
                Account account =p.getAccount();
                if(id.equals(account.getId()) && password.equals(account.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkUserName(String username,int choice){
        boolean flag=true;
        Account account;
        if (choice == 1) {
            for(Manager p : databaseManger.getManagerList()){
                account=p.getAccount();
                if(account.getId().equals(username)){
                    System.out.println("User name already exist!");
                    flag=false;
                    break;
                }
            }
        }
        if(choice==2){
            for(SalesMan p : databaseManger.getSalesManList()){
                account=p.getAccount();
                if(account.getId().equals(username)){
                    System.out.println("User name already exist!");
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

    public boolean checkItemName(String itemName){
        boolean flag=true;
        for(Item item : databaseManger.getItemList()){
            if(item.getItemName().equals(itemName)){
                System.out.println("item name already exits");
                flag=false;
                break;
            }
        }
        return flag;
    }
    public boolean checkItemId(String itemId){
        boolean flag=true;
        for(Item item :databaseManger.getItemList()){
            if(item.getItemId().equals(itemId)){
                System.out.println("item id already exits");
                flag=false;
                break;
            }
        }
        return flag;
    }

    public boolean checkMId(String MID){
        boolean flag=true;
        for(Manager manger :databaseManger.getManagerList()){
            if(manger.getMangerId().equals(MID)){
                System.out.println("manager id already exits");
                flag=false;
                break;
            }
        }
        return flag;
    }

    public boolean checkSId(String SID){
        boolean flag=true;
        for(SalesMan salesMan : databaseManger.getSalesManList()){
            if(salesMan.getSalesManId().equals(SID)){
                System.out.println("salesman id already exits");
                flag=false;
                break;
            }
        }
        return flag;
    }

    void updateSalesList(Item item,float Quantity){

        HashMap<String ,Float> salesList=databaseManger.getSalesList();
        float value=salesList.get(item.getItemId());
        value=value+Quantity;
        salesList.put(item.getItemId(),value);
        databaseManger.addSales(salesList);
    }

    void updateItem(Item item,float quantity){
        ArrayList<Item> itemList=databaseManger.getItemList();
        Item item1;
        item1=item;
        item1.setQuantity(quantity);
        itemList.set(itemList.indexOf(item),item1);
        databaseManger.updateItem(itemList);
    }
    void updatePurchaseList(Item item,float Quantity){
        HashMap<String ,Float> purchaseList=databaseManger.getSalesList();
        float value=purchaseList.get(item.getItemId());
        value=value+Quantity;
        purchaseList.put(item.getItemId(),value);
        databaseManger.addPurchase(purchaseList);
    }
}
