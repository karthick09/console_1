package Model;

import Database.Application;
import Interface.SalesmanInterface;

import java.time.LocalDate;

public class SalesMan extends User {
    private final String salesManId;
    private final LocalDate dateOfJoin;
    private final SalesmanInterface salesmanInterface;

    public SalesMan(String name, String email, String phone, Account account, String salesManId, Application application) {
        super(name, email, phone, account);
        this.salesManId = salesManId;
        this.dateOfJoin=LocalDate.of(2022,1,4);
        this.salesmanInterface=application;
    }

    void showList(){
        salesmanInterface.showList();
    }
    void sales(String itemId,float quantity){
        salesmanInterface.sales(itemId,quantity);
    }
    public String getSalesManId() {
        return salesManId;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

}
