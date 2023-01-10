package Control;

import Database.Application;
import Model.Manager;
import Model.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerControl {
    private final Manager manager;
    Scanner sc = new Scanner(System.in);

    public ManagerControl(Manager manager) {
        this.manager = manager;
    }

     String validateItemName(Application application)
    {
        String string;
        boolean isItemName;
        do{
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            isItemName=application.checkItemName(string);
        }while (!isItemName);
        return string;
    }
     String validateItemId(Application application)
    {
        String string;
        boolean isItemId;
        do{
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            isItemId=application.checkItemId(string);
        }while (!isItemId);
        return string;
    }
    int validateInteger()
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
    float validateFloat()
    {
        boolean flag;
        float float1 = 0;
        do {
            flag = true;
            try {
                Scanner scanner = new Scanner(System.in);
                float1 = scanner.nextFloat();

            } catch (InputMismatchException ignored) {
            }
            if(float1==0)
            {
                System.out.println("enter a valid input:");
                flag=false;
            }
        }while (!flag);
        return float1;
    }
    public void mangerAccess(Application application){
        String itemId;
        int choice2;
        float quantity;
        boolean flag=true;
        do{
        System.out.println("1.showItemList \n2.Add item \n3.Delete item \n4.sales \n5.purchase\n6.exit");
        choice2 = validateInteger();
        switch (choice2) {
            case 1 -> manager.showList();
            case 2 -> {
                String iName;
                float price;
                System.out.println("enter the item id");
                itemId = validateItemId(application);
                System.out.println("enter the item name");
                iName = validateItemName(application);
                System.out.println("enter the price");
                price = validateFloat();
                System.out.println("enter the quantity");
                quantity = validateFloat();
                Item item = new Item(itemId, iName, price, quantity);
                manager.addItem(item);
            }
            case 3 -> {
                System.out.println("enter the item id");
                itemId = sc.next();
                manager.deleteItem(itemId);
            }
            case 4 -> {
                System.out.println("enter the item no ");
                itemId = sc.next();
                System.out.println("enter the no of quantity");
                quantity = validateFloat();
                manager.sales(itemId, quantity);
            }
            case 5 -> {
                System.out.println("1.To update item \n2.new item");
                int ch = validateInteger();
                if (ch == 1) {
                    System.out.println("enter the item id");
                    itemId = sc.next();
                    System.out.println("enter the count to add");
                    quantity = validateFloat();
                    manager.purchase(itemId, quantity);
                } else if (ch == 2) {
                    String iName;
                    float price;
                    System.out.println("enter the item id");
                    itemId = validateItemId(application);
                    System.out.println("enter the item name");
                    iName = validateItemName(application);
                    System.out.println("enter the price");
                    price = validateFloat();
                    System.out.println("enter the quantity");
                    quantity = validateFloat();
                    Item item = new Item(itemId, iName, price, quantity);
                    manager.addItem(item);
                } else {
                    System.out.println("invalid choice");
                }
            }
            case 6-> {
                System.out.println("Exited successfully");
                flag=false;
            }
            default -> System.out.println("invalid choice");
        }
    } while (flag);
    }
}
