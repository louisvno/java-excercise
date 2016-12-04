import java.util.*;

public class Product {

    public static void main(String [ ] args){
    
        //TYPE,  NAME =  new  call CONSTRUCTOR
        Product TV = new Product("TV" , 999.95);
        Product playstation = new Product("Playstation", 399.95);

        ShoppingCart my_cart = new ShoppingCart();
        
        my_cart.addProduct(TV);
        my_cart.addProduct(playstation);
        my_cart.addProduct(playstation);
        my_cart.addProduct(playstation);
        my_cart.addProduct(playstation);
        my_cart.addProduct(playstation);
        System.out.println(my_cart.toString());
}
    
    //declare the properties
    String name;
    double price;
    
    //define the constructor 
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    // RETURN_TYPE,  METHODNAME
    public String toString(){
        return this.name + " " + this.price + "$";
    }
}