/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptian.league;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Egypt_Laptop
 */
public class League {
    Scanner scan=new Scanner(System.in);
    String starting_date;
    String ending_date;
   private static Vector <Team>team;
   private static Vector <Match>match;
    
    public League(){}
    public League(String starting_date,String ending_date,Team[]teams,Match[]matchs)
    {
        this.starting_date=starting_date;
        this.ending_date=ending_date;
        team=new Vector<Team>();
        for(int i=0;i<teams.length;i++)
        {
            team.add(teams[i]);
        }
        match=new Vector<Match>();
        for(int i=0;i<matchs.length;i++)
        {
            match.add(matchs[i]);
        }
    }
    public League(String starting_date,String ending_date)
    {
        this.starting_date=starting_date;
        this.ending_date=ending_date;
        team=new Vector<Team>();
        match=new Vector<Match>();
    }
    public static void displaySheule()
    {
        if(match.size()<1)
        {
            System.out.println("You Dont Have Aany Matchs in The Shcedule");
        }
        else
        {
        for(int i=0;i<match.size();i++)
        {
            match.get(i).DisplayMatchData();
            System.out.println("***********************");
        }
        }
    }
    public static void displayeAllTeams()
    {
        Collections.sort(team);
        if(team.size()<1) 
        {
            System.out.println("You Dont Have Aany Teams in The League, Add Some");
        }
        else 
        {    
        System.out.println("**************LEAGUE TEAMS******************");
        System.out.println("Team Name"+"           "+"Points");
        for(int i=0;i<team.size();i++)
        {
            System.out.println(team.get(i).getName()+"             "+team.get(i).getPoint());
        }
        }
       
    }
    public static void displayTeamDetails(String name)
    {
        boolean found =false;
        for(int i=0;i<team.size();i++)
        {
            if(name.equalsIgnoreCase(team.get(i).getName()))
            {
                team.get(i).display();
                found=true;
            }
        }
        if(found==false)
        {
            System.out.println("This Team Dosen't Exist in The Leagu!");
        }
    }
    public void addTeam()
    {
          boolean found=false;
          System.out.print("Enter The new Team Name: ");
                                String newTeamName=scan.next();
                                for(int i=0;i<team.size();i++)
                                {
                                    if(newTeamName.equalsIgnoreCase(team.get(i).getName()))
                                    {
                                        {
                                            found=true;
                                            break;
                                        }
                                    }
                                }
                                if(found==false)
                                {
                                System.out.print("Enter The Team Points: ");
                                int points=0;
                                points=scan.nextInt();
                                System.out.print("Enter How many Players you wanna add to The new Team: ");
                                int numberOfPlayers=scan.nextInt();
                                Vector<Player>players=new Vector();
                                for(int i=0;i<numberOfPlayers;i++)
                                {
                                    System.out.print("Enter Player "+(i+1)+" height: ");
                                    float height=scan.nextFloat();
                                    System.out.print("Enter Player "+(i+1)+" weight: ");
                                    float weight=scan.nextFloat();
                                    System.out.print("Enter Player "+(i+1)+" name: ");
                                    String playerName=scan.next();
                                    System.out.print("Enter Player "+(i+1)+" position: ");
                                    String playerPosition=scan.next();
                                    players.add(new Player(height,weight,playerName,playerPosition));
                                }
                                team.add(new Team(newTeamName,players,points));
                                System.out.println("Successful Added the Team");
                                }
                                else{System.out.println("This Team is Already Exist!");}
      
    }
    public void addMatch()
    {
        System.out.print("Enter First Team Name: ");
        String team1=scan.next();
        System.out.print("Enter Second Team Name: ");
        String team2=scan.next();
        System.out.print("Enter Stadium Name: ");
        String newstadName=scan.next();
        System.out.print("Enter Stadium Location: ");
        String location=scan.next();
        System.out.print("Enter Stadium capacity: ");
        int capacity=scan.nextInt();
        System.out.print("Enter Referee Name: ");
        String refName=scan.next();
        System.out.print("Enter Match Date: ");
        String date=scan.next();
        System.out.print("Enter Match time: ");
        String time=scan.next();

        Referee newRef=new Referee(refName);
        Stadium stadium=new Stadium(newstadName, location, capacity);
        //******************************************************************
        int team1Index=0;
        int team2Index=0;
        int exist=0;
        for(int i=0;i<team.size();i++)
        {
            if(team1.equalsIgnoreCase(team.get(i).getName()))
            {
                team1Index=i;
                exist++;
            }
        }
        
        for(int i=0;i<team.size();i++)
        {
            if(team2.equalsIgnoreCase(team.get(i).getName()))
            {
                team2Index=i;
                exist++;
            }
        }
        if(exist==2)
        {
        Team[]matchteams=new Team[2];
        matchteams[0]=team.get(team1Index);
        matchteams[1]=team.get(team2Index);
        match.add(new Match(matchteams,stadium,newRef,date,time));
        System.out.println("Successful Added");
        }
        else{System.out.println("The Teams Dont Exist in league Add The Teams!");}
      
    }
    public static void removeTeam(String removeTeam)
    {
        for(int i=0;i<match.size();i++)
        {
            if(match.get(i).getFirstTeamName().equalsIgnoreCase(removeTeam)||match.get(i).getSecondTeamName().equalsIgnoreCase(removeTeam))
            {
                removeMatch(match.get(i).getMatchDate());
            }  
     
        }
              
        for(int i=0;i<team.size();i++)
        {
            if(team.get(i).getName().equalsIgnoreCase(removeTeam))
            {
                team.remove(i);
                break;
            }    
        }
  
    }
    public static void removeMatch(String match_date)
    {
        for(int i=0;i<match.size();i++)
        {
            if(match.get(i).getMatchDate().equals(match_date))
            {
                match.remove(i);
            }
        }
    }
    private int diplayEditTeamMenu()
    {
        System.out.println("*******Select What Yow Wanna Edit******");
        System.out.println("1: Edit TeamName");
        System.out.println("2: Edit Player");
        System.out.println("3: Add Player");
        System.out.println("4: Delete Player");
        int selector=scan.nextInt();
        return selector;
    }
    
    public void editTeam(String teamName)
    {
        for(int i=0;i<team.size();i++)
        {
            if(team.get(i).getName().equalsIgnoreCase(teamName))
            {
                switch(diplayEditTeamMenu())
                {
                    case 1:
                    {
                        System.out.print("Enter new team name: ");
                        String newName=scan.next();
                        team.get(i).setName(newName);
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Enter The Player Name you Wanna to Change: ");
                        String playerName=scan.next();
                        team.get(i).editPlayer(playerName);
                        break;
                    }
                    case 3:
                    {
                       team.get(i).addPlayer();
                       break;
                    }
                    case 4:
                    {
                        System.out.print("Enter the name of Player you want to Delete");
                        String name=scan.next();
                        team.get(i).deletePlayer(name);
                        break;
                    }
                }
            }
        }
    }
    public int displayEditMatchMenu()
    {
        System.out.println("*******Select What Yow Wanna Edit******");
        System.out.println("1: Change Stadium");
        System.out.println("2: Chanege Referee");
        System.out.println("3: Change Date");
        System.out.println("4: Change Time");
        int selector=scan.nextInt();
        return selector;
    }
    public void editMatch(String match_date)
    {
     for(int i=0;i<match.size();i++)
        {
            if(match.get(i).getMatchDate().equals(match_date))
            {
                match.get(i).DisplayMatchData();
                switch(displayEditMatchMenu())
                {
                    case 1:
                    {
                        match.get(i).changeStadium();
                        break;
                    }
                    case 2:
                    {
                        match.get(i).changeReferee();
                        break;
                    }
                    case 3:
                    {
                        System.out.print("Enter new date: ");
                        String newDate=scan.next();
                        match.get(i).setDate(newDate);
                        break;
                    }
                    case 4:
                    {
                        System.out.print("Enter new time: ");
                        String newTime=scan.next();
                        match.get(i).setTime(newTime);
                        break;
                    }
                }
            }
        }   
    }
    
   public static void initialStore(){

        Team teams[]=new Team[2];
        
        Vector <Player>p1=new Vector<Player>();
        p1.add(new Player(170,70,"Maloul","LB"));
        
        Team t1=new Team("Alahly",p1,30);
        team.add(t1);
       

        Vector <Player>p2=new Vector<Player>();
        p2.add(new Player(170,70,"Tarek Hamed","DM"));
        
        Team t2=new Team("Zamalek",p2,20);
        team.add(t2);
        
         teams[0]= t1;
         teams[1]= t2;
         match.add(new Match(teams,new Stadium("Borg Alarab","Alex",30000), new Referee("Gehad Gresha"),"26/3/2021", "7:00PM"));
   }
}
