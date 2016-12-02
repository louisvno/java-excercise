import java.util.*;

public class Product {

    public static void main(String [ ] args){
    
        //TYPE,  NAME =  new  call CONSTRUCTOR
        Product p1 = new Product("TV" , 999.95);
        Product p2 = new Product("Playstation", 399.95);
        System.out.println(p1.toString());
        
        ShoppingCart my_cart = new ShoppingCart();
        
        my_cart.addProduct(p1);
        my_cart.addProduct(p2);
        my_cart.addProduct(p2);
        my_cart.addProduct(p2);
        my_cart.addProduct(p2);
        my_cart.addProduct(p2);
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