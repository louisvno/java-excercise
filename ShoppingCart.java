import java.util.*;

public class ShoppingCart {
    
    /*Declare the properties*/
    //TYPE,  TYPE of list, Name
    ArrayList<Product> products;
    
    //**Initialize the properties with Constructor
    ShoppingCart(){
        this.products = new ArrayList<Product>();
    }
    
    /*Methods*/

    //add a product to the ArrayList products (ShoppingCart)
    public void addProduct(Product product) {
        this.products.add(product);
        
        System.out.println(product.name + " added to cart");
    }
    
    //output the contents of the cart
    public String toString() {
        return "Your cart contains:" + this.products + " total price = " + getTotalPrice();
    }
    
    //calculate total price of cart content ArrayList<Product> p
    double getTotalPrice(){
        double totalPrice = 0.0;
        int numberOfProducts = this.products.size();
        
        for (int i= 0 ; i < numberOfProducts ;i++){
            totalPrice += this.products.get(i).price;
        }
        
        if (numberOfProducts >= 5){
            System.out.println("original price was" + totalPrice + ", 10% discount applied!");
            return totalPrice*0.9;
        } else { 
            return totalPrice;
        }
    }
}