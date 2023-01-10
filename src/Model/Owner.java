package Model;

import Database.Application;
import Interface.OwnerInterface;

public class Owner {
    private final String password;
    private final OwnerInterface ownerInterface;

    public Owner(String password, Application application) {
        this.password = password;
        this.ownerInterface=application;
    }

    public void addManager(Manager manager){
        ownerInterface.addManager(manager);
    }
    public void addSalesman(SalesMan salesman){
        ownerInterface.addSalesman(salesman);
    }
    public void salary(String empId,int designation){
        ownerInterface.salary(empId,designation);
    }
    public void turnover(int choice){
        ownerInterface.turnover(choice);
    }
    public String getPassword() {
        return password;
    }
}
