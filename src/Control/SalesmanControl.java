package Control;


import Model.SalesMan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SalesmanControl {
    private final SalesMan salesMan;

    public SalesmanControl(SalesMan salesman) {
        this.salesMan = salesman;
    }
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

    public static float validateFloat()
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
    public void salesManAccess(){
        int choice2;
        String itemId;
        float quantity;
        boolean flag=true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.view list \n2.sales\n3.exit");
            choice2 = validateInteger();
            switch (choice2) {
                case 1 -> salesMan.showList();
                case 2 -> {
                    System.out.println("enter the item no ");
                    itemId = sc.next();
                    System.out.println("enter the no of quantity");
                    quantity = validateFloat();
                    salesMan.sales(itemId, quantity);
                }
                case 3 -> {
                    System.out.println("Exited successfully");
                    flag=false;
                }
                default -> System.out.println("invalid choice");
            }
        } while (flag);
    }

}
