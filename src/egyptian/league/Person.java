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
public abstract class Person {
    private float height;
    private float weight;
    private String name;
    public Person(float height ,float weight,String name )
    {
        this.height=height;
        this.weight=weight;
        this.name=name;
    }
    void setHeight(float height)
    {
        this.height=height;
    }
    float getHeight()
    {
        return height;
    }
    void setWeight(float weight)
    {
        this.weight=weight;
    }
    float getWeight()
    {
        return weight;
    }
    void setName(String name)
    {
        this.name=name;
    }
    String getName()
    {
        return name;
    }
    public void Display()
    {
        System.out.println("Name: " +name);
        System.out.println("Weight: " +weight);
        System.out.println("Height: " +height);
    }
    
}
