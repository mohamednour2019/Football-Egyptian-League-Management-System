/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptian.league;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Egypt_Laptop
 */

public class Team implements Comparable{
    Scanner scan=new Scanner(System.in);
    private String teamName;
    private int points;
    Vector <Player>players;

    
    @Override
    public int compareTo(Object o) {
        if(this.points<((Team)o).getPoint())
        {
            return 1;
        }
        else if(this.points>((Team)o).getPoint())
        {
            return -1;
        }
        else{return 0;}
    }
    

    public Team(String teamName,Vector <Player> p,int pionts)
    {
        this.teamName=teamName;
        this.points=pionts;
        this.players=new Vector<Player>();
        for(int i=0;i<p.size();i++)
        {
            this.players.add(p.get(i));
        }
    }
    /*public Team (Team obj)
    {
        this.teamName=obj.teamName;
        this.players=obj.players;
        
    }*/
    public void setName(String teamName)
    {
        this.teamName=teamName;
    }
    public String getName()
    {
        return teamName;
    }
    public int getPoint()
    {
        return points;
    }
    public void addPlayer()
    {
        boolean found=false;
        System.out.print("Enter Player name: ");
        String playerName=scan.next();
        for(int i=0;i<players.size();i++)
        {
            if(playerName.equalsIgnoreCase(players.get(i).getName()))
            {
                found=true;
            }
        }
        if(found==false){
         System.out.print("Enter Player height: ");
         float height=scan.nextFloat();
         System.out.print("Enter player weight: ");
         float weight=scan.nextFloat();
         System.out.print("Enter player position: ");
         String position=scan.next();
         players.add(new Player(height,weight,playerName,position));
         System.out.println("Successful Added To The Team");
        }
        else{System.out.println("This Player is Already Exist in this team!");}
    }
    
    void deletePlayer(String delPlayer)
    {
     for(int i=0;i<players.size();i++)
     {
         if(delPlayer.equalsIgnoreCase(players.get(i).getName()))
         {
             players.remove(i);
             break;
         }
     }   
    }
    private int DisplayEditmenu()
    {
        
        System.out.println("*******Select What Yow Wanna Edit******");
        System.out.println("1: Edit Name");
        System.out.println("2: Edit Height");
        System.out.println("3: Edit Weight");
        System.out.println("4: Edit Position");
        
        int selector=scan.nextInt();
        return selector;
    }
    
    void editPlayer(String editPlayer)
    { 
        boolean found=false;
        int playerIndex=0;
        for(int i=0;i<this.players.size();i++)
        {
            if(players.get(i).getName().equalsIgnoreCase(editPlayer))
            {
                playerIndex=i;
                found=true;
                break;
            }
        }
        if(found==true){
        switch(DisplayEditmenu())
        {
            case 1:
            {
                System.out.print("Enter player new name: ");
                String newName=scan.next();
                players.get(playerIndex).setName(newName);
                break;
            }
            case 2:
            {
                System.out.print("Enter player new height: ");
                float newHeight=scan.nextFloat();
                players.get(playerIndex).setHeight(newHeight);
                break;
            }
            case 3:
            {
                System.out.print("Enter player new weight: ");
                float newWeight=scan.nextFloat();
                players.get(playerIndex).setWeight(newWeight);
                break;
            }
            case 4:
            {
                System.out.print("Enter player new position: ");
                String newPosition=scan.next();
                players.get(playerIndex).setPosition(newPosition);
                break;
            }    
        }
        }
        else{System.out.println("This Player Doesn't Exist In This Team");}
         
    }
    public void display()
    {
    System.out.println("The Team Name: "+this.teamName+"\n Team Points: "+this.points+"\n Team Players List:");
    System.out.println("*************************");
    
    System.out.println("    Name         Position       Height        weight");
    for(int i=0;i<this.players.size();i++)
    {
        System.out.print( (i+1) +". ");
        this.players.get(i).Display();
    }
    }
}