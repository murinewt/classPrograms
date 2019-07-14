/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

public class Movie
{
private String title; 
private int year;
private double price;
public Movie() 
{
this.title = "";
this.year = 0;
this.price = 0.0;
}
public Movie(String title, int year, double price) 
{
this.title = title;
this.year = year;
this.price = price;
}
public String getTitle() 
{
return this.title;
}
public void setTitle(String title) 
{
this.title = title;
}
public int getYear() 
{
return this.year;
}
public void setYear(int year)
{
this.year = year;
}
public double getPrice()
{
return this.price;
}
public void setPrice(double price) 
{
this.price = price;
}
}