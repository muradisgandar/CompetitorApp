package util;

import beans.Competitor;
import beans.User;
import config.Config;
import config.Initilization;

import java.util.Scanner;

public class CompetitionUtil {
    public static Competitor[] registerCompetitors(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many competitors will participate in competition?");
        int competitorCount = sc.nextInt();
        Competitor [] competitors = new Competitor[competitorCount];
        for(int i=0;i<competitorCount;i++){
                Competitor competitor = registerCompetitor();
                competitors[i] = competitor;
        }
        Initilization.config.setCompetitors(competitors);
        System.out.println("All competitors successfully registered!");
        return competitors;

    }
    public static Competitor[] registerCompetitorsAndShowInfo(){
        Competitor [] competitors = registerCompetitors();
        CompetitionUtil.printCompetitors(competitors);
        return competitors;
    }

    public static Competitor registerCompetitor(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Competitor name: ");
        String name = sc.nextLine();

        System.out.println("Competitor surname: ");
        String surname = sc.nextLine();

        System.out.println("Competitor age: ");
        int age = sc.nextInt();

        Competitor competitor = new Competitor(name,surname,age);

        return competitor;

    }

    public static void printCompetitors(Competitor [] competitors){
        if(competitors==null || competitors.length==0){
            return;
        }
        for(int i=0;i<competitors.length;i++){
            Competitor c = competitors[i];
            System.out.println(c);
        }
    }
    public static void printCompetitors() {
        printCompetitors(Initilization.config.getCompetitors());

    }
    public static boolean startCompetition(){
        int winner = (int) (Math.random()*11);

        System.out.println("Guess winner?");
        Scanner sc = new Scanner(System.in);

        int guessedwinner = sc.nextInt();
        if(guessedwinner==winner){
            increase();
            System.out.println("You won! You point increase"+ Initilization.config.getUser().getPoint());
            return true;
        }else{
            System.out.println("You lost!");
            System.out.println("Winner is: "+winner);
            return false;
        }

    }
    public static void increase(){
        User user = Initilization.config.getUser();
        user.setPoint(user.getPoint()+10);
    }
    public static void showPoint(){
        System.out.println("Your point: "+Initilization.config.getUser().getPoint());
    }
    public static void increaseCompetitors(){
        Competitor [] competitorsOld = Initilization.config.getCompetitors();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many competitors will be append? ");
        int increaseCount = sc.nextInt();
        Competitor [] competitorsNew = new Competitor[competitorsOld.length+increaseCount];
        for(int i=0;i<competitorsOld.length;i++){
            competitorsNew[i] = competitorsOld[i];
        }
        for(int i=competitorsOld.length;i<competitorsOld.length+increaseCount;i++){
            competitorsNew[i] = registerCompetitor();
        }
        Initilization.config.setCompetitors(competitorsNew);
    }



}