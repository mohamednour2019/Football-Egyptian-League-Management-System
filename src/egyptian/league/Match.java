/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptian.league;

import java.util.Scanner;

/**
 *
 * @author Egypt_Laptop
 */
public class Match {
    private Team matchTeams[];
    private Stadium matchStadium;
    private Referee matchReferee;
    private String matchDate;
    private String matchTime;
    
    Scanner scan=new Scanner(System.in);
    /*
    
    team teams[]=team[2]
    Match(tesms)
    */
   
    public Match(Team[]teamsMatch,Stadium matchStadium,Referee matchReferee,String matchDate,String matchTime)
    {
        this.matchTeams=new Team[2];
        this.matchTeams=teamsMatch;
        this.matchStadium=matchStadium;
        this.matchReferee=matchReferee;
        this.matchDate=matchDate;
        this.matchTime=matchTime;
    }
    public void changeReferee()
    {
        System.out.print("Enter Referee height: ");
        float height=scan.nextFloat();
        System.out.print("Enter Referee weight: ");
        float weight=scan.nextFloat();
        System.out.print("Enter Referee name: ");
        String refName=scan.next();
        this.matchReferee =new Referee(height, weight,refName );
    }
    public void changeStadium()
    {
         System.out.print("Enter stadium name: ");
         String stadName=scan.next();
         System.out.print("Enter stadium Location: ");
         String stadLocation=scan.next();
         System.out.print("Enter stadium capacity: ");
         int capacity=scan.nextInt();
         this.matchStadium=new Stadium(stadName,stadLocation,capacity);
    }
    public void setDate(String date)
    {
        this.matchDate=date;
    }
    public void setTime(String time)
    {
        this.matchTime=time;
    }
    public String getMatchDate()
    {
        return matchDate;
    }
    public String getFirstTeamName()
    {
        return matchTeams[0].getName();
      
    }
       public String getSecondTeamName()
    {
        return matchTeams[1].getName();
      
    }
    
    public void DisplayMatchData()
    {
     System.out.println(matchTeams[0].getName()+" VS "+matchTeams[1].getName()+"\n Date: "
     +matchDate+"\n Time: "+matchTime+"\n Referee: "+matchReferee.getName()+"\n Stadium: "+matchStadium.getName());
    }
}
