package oo_java;

/* Pessoa física herda os atributos de cliente */
public class Person extends Costumer {
    public double height;    

    public void print(){      
        super.print(); 
        System.out.println("Altura: " + height);
    }

    public void print(int id){
        super.print(id);
        System.out.println("Altura: " + height);
    }

    public double bmiCalculator(double weight){
        double bmi = weight / (height*height);
        return bmi;
    }
}