package Interface;

import Model.Manager;
import Model.SalesMan;

public interface OwnerInterface {
    void addManager(Manager manager);
    void addSalesman(SalesMan salesman);
    void salary(String empId,int designation);
    void turnover(int choice);
}
