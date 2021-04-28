/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptian.league;

/**
 *
 * @author Egypt_Laptop
 */
public class Stadium {
   private  String stadiumName;
   private  String location;
   private  int seat_capacity;
   
   public Stadium(String stadiumName,String location,int seat_capacity)
   {
       this.stadiumName=stadiumName;
       this.location=location;
       this.seat_capacity=seat_capacity;
   }
   public String getName()
   {
       return stadiumName;
   }
}
