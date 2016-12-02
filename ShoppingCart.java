import java.util.*;

public class ShoppingCart {
    
    /*Declare the properties*/
    //TYPE,  TYPE of list, Name
    ArrayList<Product> productsInCart;
    
    //**Initialize the properties with Constructor
    ShoppingCart(){
        this.productsInCart = new ArrayList<Product>();
    }
    
    /*Methods*/

    //add a product to the ArrayList productsInCart (ShoppingCart)
    public void addProduct(Product product) {
        this.productsInCart.add(product);

        System.out.println(product.name + " added to cart");
    }
    
    //output the contents of the cart
    public String toString() {
        return "Your cart contains:" + this.productsInCart + " total price = " + getTotalPrice();
    }
    
    //calculate total price of cart content ArrayList<Product> p
    double getTotalPrice(){
        double totalPrice = 0.0;
        int numberOfProducts = this.productsInCart.size();
        HashMap <String, Integer> productsCounter = new HashMap<>();
        String productName;
        Integer productCount;

        for (int i = 0; i < numberOfProducts; i++){
            //get product name
            productName = this.productsInCart.get(i).name;
            //check if the productname exists in the hashmap
            if (productsCounter.containsKey(productName)){
                productCount = productsCounter.get(productName);
                productsCounter.put(productName, (productCount + 1));
            }else {
                productsCounter.put(productName, 1);
            };

            totalPrice += this.productsInCart.get(i).price;
        }

        System.out.println(productsCounter);

        if (numberOfProducts >= 5){
            System.out.println("original price was" + totalPrice + ", 10% discount applied!");
            return totalPrice*0.9;
        } else { 
            return totalPrice;

        }
    }
}