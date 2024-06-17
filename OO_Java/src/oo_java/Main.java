
package oo_java;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hello World");
        City poa = new City();
        poa.name = "Porto Alegre";
        poa.state = "RS";
        poa.print();
        poa.print("Joao");

        Costumer cliente = new Costumer();
        cliente.name = "Julia";
        cliente.neighborhood = "Centro";
        cliente.city = poa;

        cliente.print();
        Person costPerson = new Person();
        costPerson.name = "Suzy";
        costPerson.neighborhood = "Petrópolis";
        costPerson.city = poa;
        costPerson.height = 1.72;
        costPerson.print();

        String name = costPerson.nameSearch();
        String fullName = costPerson.fullNameSearch(" Silva");
        Double bmi = costPerson.bmiCalculator(80.9);
        System.out.println(fullName + " bmi: " + bmi);
        

    }
    
}
