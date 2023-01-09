package Interface;

import Model.Manager;
import Model.SalesMan;

public interface OwnerInterface {
    void addManager(Manager manager);
    void addSalesman(SalesMan salesman);
    float salary(String empId,String designation);
    void turnover(int choice);
}
