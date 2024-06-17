/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_java;


public class City {
    public int id;
    public String name, state;

    public City(){

    }
    
    public City(int id){
        this.id = id;
    }

    public City(int id, String name){
        this.id = id;
        this.name = name;
    }

    public City(String name, String state){
        
    }

    public void print(){
        System.out.println("Name: " + this.name);
        System.out.println("Estado: " + this.state);
    }

    public void print(String user){
        System.out.println("Usuario: " + user);
        System.out.println("Name: " + name);
        System.out.println("Estado: " + this.state);
    }
    
}
