package Model;

import Database.Application;
import Interface.ManagerInterface;

import java.time.LocalDate;

public class Manager extends User {

    private final String mangerId;
    private final LocalDate dateOfJoin;
    private final ManagerInterface managerInterface;

    public Manager(String name, String email, String phone, Account account, String mangerId, Application application) {
        super(name, email, phone, account);
        this.mangerId = mangerId;
        this.dateOfJoin=LocalDate.of(2022,1,4);
        this.managerInterface=application;
    }

    public void addItem(Item item){
        managerInterface.addItem(item);
    }
    public void deleteItem(String itemId){
        managerInterface.deleteItem(itemId);
    }
    public void sales(String itemId,float quantity){
        managerInterface.sales(itemId,quantity);
    }
    public void purchase(String item,float quantity){
        managerInterface.purchase(item,quantity);
    }
    public void showList(){
        managerInterface.showList();
    }

    public String getMangerId() {
        return mangerId;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }


}
