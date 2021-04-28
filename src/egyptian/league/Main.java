/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptian.league;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(System.in);
        
        

        League myleague=new League("1/10","10/10");
        League.initialStore();
        
        
        
        //strored data for admin
        String adminpassword="12345";
        String adminname="admin";

        //stored data for user
        String username="user";
        String userpassword="678910";
         System.out.print("Enter Username: ");
        String inputusername=scan.next();

        System.out.print("Enter Password: ");
        String inputpassword=scan.next();

  
        while(true){
       
        if(inputusername.equalsIgnoreCase(adminname)&&inputpassword.equalsIgnoreCase(adminpassword))//check if the input for admin
        {
            System.out.println("******Welcome To Admin Mode******");
            while(true){
                Menu();
                int menuSelect=scan.nextInt();
                switch(menuSelect)
                {
                    case 1://display league matchs
                    {
                        System.out.println("*********League Shcedule*********");
                        League.displaySheule();
                        break;
                    }
                    case 2://diplay teams that stored in league
                    {
                        League.displayeAllTeams();
                        break;
                    }
                    case 3: //go to another menu for edit team
                    {
                        displayTeamEditModeOptions();
                        int selector=scan.nextInt();
                        switch(selector)
                        {
                            case 1: //add new team
                            {
                               myleague.addTeam();
                               break;
                            }
                            case 2://remove team from league
                            {
                                System.out.print("Enter The team name: ");
                                String name;
                                name=scan.next();
                                League.removeTeam(name);
                                break;
                            }
                            case 3://method editTeam include:edit team name, player, add player, remove player
                            {
                                System.out.print("Enter Team Name: ");
                                String teamName=scan.next();
                                new League().editTeam(teamName);
                                break;
                            }
                            case 4: break;

                        }

                        break;

                    }
                    case 4://go to another menu to edit matchs in league
                    {
                        System.out.print("*****Choose option*****");
                        displayMatchEditModeOptions();
                        int selector=scan.nextInt();
                        switch(selector)
                        {
                            case 1://add new match
                            {
                                myleague.addMatch();
                                break;
                            }
                            case 2://delete match by date
                            {
                                System.out.print("Enter the match date you want to delete: ");
                                String match_date=scan.next();
                                League.removeMatch(match_date);

                            }
                            case 3://edit match by date
                            {   System.out.print("Enter the date of match you wann to edit: ");
                                String date=scan.next();
                                new League().editMatch(date);
                                break;
                            }
                            case 4: break;

                        }
                        break;
                    }
                    case 5://display team details
                    {
                        System.out.print("Enter the team name: ");
                        String detailsTeam=scan.next();
                        League.displayTeamDetails(detailsTeam);
                        break;
                    }

                    

                }
            }
        }
        else if(inputusername.equalsIgnoreCase(username)&&inputpassword.equalsIgnoreCase(userpassword))//check if the input date for default user
        {
            while(true)
            {
                System.out.print("******Select Option******");
                displayDefualtUserMinue();//has 3 display options schedule,teams,teams details
                int userMenuSelect=scan.nextInt();
                if(userMenuSelect>0&&userMenuSelect<=4){
                    switch(userMenuSelect)
                    {
                        case 1://display schedule
                        {
                            System.out.println("*********League Shcedule*********");
                            League.displaySheule();
                            break;
                        }
                        case 2://display the teams in the league
                        {

                            League.displayeAllTeams();
                            break;
                        }
                        case 3://display a team details by its name
                        {
                            System.out.print("Enter the team name: ");
                            String detailsTeam=scan.next();
                            League.displayTeamDetails(detailsTeam);
                            break;
                        }

                    }}
                else{System.out.println("*****Invalid Input*****");}//if the data for not admin user or default user

            }
        }
        else{System.out.println("Invalid Data Try Again");}
        }


    }

    public static void Menu()
    {
        System.out.println("********Select What You Want********");
        System.out.println("1: View League Schedule");
        System.out.println("2: View League Teams");
        System.out.println("3: Teams Edit Mode");
        System.out.println("4: Match Edit Mode");
        System.out.println("5: Display Team Details");
    }
    public static void displayTeamEditModeOptions()
    {
        System.out.println("******Choose Option******");
        System.out.println("1: Add New Team");
        System.out.println("2: Delete Team");
        System.out.println("3: Edit Team Or player");
        System.out.println("4: Return To Main Menu");


    }
    public static void displayMatchEditModeOptions()
    {
        System.out.println("******Choose Option******");
        System.out.println("1: Add New Match");
        System.out.println("2: Delete Math");
        System.out.println("3: Edit Match");
        System.out.println("4: Return To Main Menu");


    }
    public static void displayDefualtUserMinue()
    {
        System.out.println("******Choose Option******");
        System.out.println("1: View League Schedule");
        System.out.println("2: View League Teams");
        System.out.println("3: Display Team Details");


    }
}
