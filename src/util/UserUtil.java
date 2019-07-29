package util;

import beans.User;

import java.util.Scanner;

public class UserUtil {
    public static User login(String username, String password){
        if("Murad".equals(username) && "12345".equals(password)){
            User user = new User(username,password);
            return user;
        }
        throw new IllegalArgumentException("Username or password is incorrect");
    }
    public static User requiredInputAndLogin(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your username");
        String username = sc.nextLine();

        System.out.println("Please enter your password");
        String password = sc.nextLine();

        User user = UserUtil.login(username,password);

        return user;
    }
    public static User requiredInputAndLogin(int tryCount,boolean exception){
        for(int i=0;i<tryCount;i++){
            try{
                User user = requiredInputAndLogin();
                return user;
            }catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                System.out.println("Try again!");
            }
        }
        if(exception) {
            throw new IllegalArgumentException("You have banned!");
        }
        else{
            return null;
        }
    }




}
