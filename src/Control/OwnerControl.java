
package Control;


import java.util.Scanner;
import java.util.regex.Pattern;

import Database.Application;
import Model.Owner;

public class OwnerControl{
    private final Owner owner;

    public OwnerControl(Owner owner) {
        this.owner = owner;
    }

    static String validateName()
    {
        int stringLength;
        boolean value=true;
        String string;
        boolean isAlphabet=true;
        do {
            if(!value||!isAlphabet) {
                System.out.println("(Input size should be greater than 4 and should not contain any numbers or special characters)" +
                        "Enter again:");
            }
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            for (int i=0; i<string.length(); i++) {
                char c = string.charAt(i);
                isAlphabet=(c>=0x41&&c<=0x5a)||(c>=0x61&&c<=0x7a)||(c==0x20);
                if(!isAlphabet)
                    break;
            }
            stringLength=string.length();
            value=(stringLength>=5);
        }while (!value||!isAlphabet);
        return string;
    }

    static String validateEmail()
    {
        String string;
        boolean isEmail=true;
        do{
            if(!isEmail)
            {
                System.out.println("enter valid email");
            }
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";
            Pattern pat = Pattern.compile(emailRegex);
            isEmail=pat.matcher(string).matches();
        }while (!isEmail);
        return string;
    }

    static String validateUserName(int choice,Application application)
    {
        int stringLength;
        String string;
        boolean value=true;
        boolean isUserName;
        do{
            if(!value)
            {
                System.out.println("(Input size should be greater than 4)"+"Enter again:");
            }
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            stringLength=string.length();
            isUserName=application.checkUserName(string,choice);
            value=stringLength>=5;
        }while (!isUserName||!value);
        return string;
    }


    static String validateMId(Application application)
    {
        String string;
        boolean isMID;
        do{
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            isMID=application.checkMId(string);
        }while (!isMID);
        return string;
    }
    static String validateSId(Application application)
    {
        String string;
        boolean isSID;
        do{
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            isSID=application.checkSId(string);
        }while (!isSID);
        return string;
    }
    static String validatePhoneNumber()
    {
        int stringLength;
        boolean value=true;
        String string;
        boolean isNumber=true;
        do{
            if(!value||!isNumber)
            {
                System.out.println("(Input size should be equal to 10 and contain only numbers)"+
                        "Enter again:");
            }
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            for (int i=0; i<string.length(); i++) {
                char c = string.charAt(i);
                isNumber=(c>=0x30&&c<=0x39);
                if(!isNumber)
                    break;
            }

            stringLength=string.length();
            value=stringLength==10;
        }while (!value||!isNumber);
        return string;
    }
    static String validatePassword()
    {
        int stringLength;
        String string;
        boolean isPassword=true;
        do{
            if(!isPassword)
            {
                System.out.println("(Input size should be greater than 7)"+
                        "Enter again:");
            }
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            stringLength=string.length();
            isPassword=stringLength>=8;
        }while (!isPassword);
        return string;
    }
    public void ownerAccess(Application application){

    }
}
