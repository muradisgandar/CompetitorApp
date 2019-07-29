package util;

import java.util.Scanner;

public class MenuUtil {
    public static int showMenu(){
        System.out.println("Please select menu:");
        String menuStr =
                "1-Register gamers\n" +
                        "2-Start game\n" +
                        "3-Show points\n" +
                        "4-Increase gamers\n" +
                        "5-Show competitors\n"+
                        "6-Logout\n";
        System.out.println(menuStr);
        Scanner sc = new Scanner(System.in);
        int selectMenu = sc.nextInt();
        if(selectMenu>0 && selectMenu<7) {
            return selectMenu;
        }
        else {
            System.out.println("Invalid menu selected!");
            return -1;
        }

    }
    public static int showMenuInfinite(){
        while(true) {
            int selectMenu = showMenu();
            if(selectMenu==1){
                CompetitionUtil.registerCompetitorsAndShowInfo();
            }
            else if(selectMenu==2){
                CompetitionUtil.startCompetition();
            }
            else if(selectMenu==3){
                CompetitionUtil.showPoint();
            }
            else if(selectMenu==4){
                CompetitionUtil.increaseCompetitors();
            }
            else if(selectMenu==5){
                CompetitionUtil.printCompetitors();
            }
            else if(selectMenu==6){
                UserUtil.requiredInputAndLogin(3,true);
            }
        }

    }


}
