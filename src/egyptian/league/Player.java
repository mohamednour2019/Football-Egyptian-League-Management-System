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
public class Player extends Person 
{
    private String position;
    
    public Player(float height,float weight,String name,String position){
    super(height,weight,name);
    this.position=position;
    
    }
    
    public void setPosition(String position)
    {
        this.position=position;
    }
    @Override
    public void Display()
    {
        System.out.println(getName()+"         "+this.position+"               "+getHeight()+"          "+getWeight());
    }
            
}
