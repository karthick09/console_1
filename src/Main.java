import Control.ManagerControl;
import Control.OwnerControl;
import Control.SalesmanControl;
import Database.Application;
import Model.Account;
import Model.Manager;
import Model.Owner;
import Model.SalesMan;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static int validateInteger()
    {
        boolean flag;
        int integer1 = 0;
        do {
            flag = true;
            try {
                Scanner scanner = new Scanner(System.in);
                integer1 = scanner.nextInt();

            } catch (InputMismatchException ignored) {
            }
            if(integer1==0)
            {
                System.out.println("enter integer only:");
                flag=false;
            }
        }while (!flag);
        return integer1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Application application =new Application();
        String username,password;
        Owner o =new Owner("owner",application);
        Account ac = new Account("karthick","muthu1309");
        Manager man = new Manager("karthick","karthiock@gmail.com","1234567890",ac,"m101",application);
        o.addManager(man);
        Account ac1 = new Account("raghul","muthu1234");
        SalesMan sa = new SalesMan("karthick","karthiock@gmail.com","1234567890",ac1,"s101",application);
        o.addSalesman(sa);
        int choice1;
        do {
            System.out.println("1.owner login \n2.manger login \n3.salesman \n4.exit");
            choice1 = validateInteger();
            if (choice1 == 4) {
                System.exit(0);
            }
            switch (choice1) {
                case 1 -> {
                    System.out.println("enter the username");
                    username = sc.next();
                    System.out.println("enter the password");
                    password = sc.next();
                    if (username.equals("abc") && password.equals("123")) {
                        Owner owner = new Owner("owner", application);
                        OwnerControl ownerControl = new OwnerControl(owner);
                        ownerControl.ownerAccess(application);
                    } else {
                        System.out.println("invalid username or password");
                    }
                }
                case 2 -> {
                    System.out.println("enter the username");
                    username = sc.next();
                    System.out.println("enter the password");
                    password = sc.next();
                    if (application.getLoginDetails(username, password, choice1)) {
                        Manager manager;
                        manager = application.getManager(username);
                        ManagerControl managerControl = new ManagerControl(manager);
                        managerControl.mangerAccess(application);
                    } else {
                        System.out.println("invalid username or password");
                    }
                }
                case 3 -> {
                    System.out.println("enter the username");
                    username = sc.next();
                    System.out.println("enter the password");
                    password = sc.next();
                    if (application.getLoginDetails(username, password, choice1)) {
                        SalesMan salesMan;
                        salesMan = application.getSalesMan(username);
                        SalesmanControl salesmanControl = new SalesmanControl(salesMan);
                        salesmanControl.salesManAccess();
                    } else {
                        System.out.println("invalid username or password");
                    }
                }
            }
        }while (true);
    }
}