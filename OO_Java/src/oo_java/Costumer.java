package oo_java;

public class Costumer {
    private int id;
    public String name;
    public String neighborhood;
    public City city;

    public Costumer(){

    }

    public void print(){
        System.out.println("Name: " + this.name);
        System.out.println("Bairro: " + this.neighborhood);
        System.out.println("Cidade: " + this.city.name + "/" + this.city.state);

    }

    public void print(int id){
        System.out.println("Name: " + this.name);
        System.out.println("Bairro: " + this.neighborhood);
        System.out.println("Cidade: " + this.city.name + "/" + this.city.state);

    }

    public String nameSearch(){
        return name;
    }

    public String fullNameSearch(String lastName){
        return name + lastName;
    }


}