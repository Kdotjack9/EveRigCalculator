package com.happycheeseburger.rigbuilder;


public class Construction
{

    public Construction(String name, int number)
    {
        this.name = name;
        this.number = number;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    private String name;
    private int number;
}
