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
        return "Your cart contains:" + this.productsInCart +
                " Total price = " + getTotalPrice() +
                " Discount = " +
                " Final amount = " +;
    }

    //get count of each product added to Shoppingcart
    private HashMap <String, Integer> getProductCount() {
        HashMap <String, Integer> productsCounter = new HashMap<>();
        String productName;
        Integer productCount;
        int numberOfProducts = getNumberOfProducts();

        for (int i = 0; i < numberOfProducts; i++) {
            //get product name
            productName = this.productsInCart.get(i).name;
            //check if the product name exists in the hash map
            if (productsCounter.containsKey(productName)) {
                productCount = productsCounter.get(productName);
                productsCounter.put(productName, (productCount + 1));
            } else {
                productsCounter.put(productName, 1);
            }
        }
        return productsCounter;
    }

    //calculate discounts
    private double getDiscountOverFiveItems () {
        double totalPrice = getTotalPrice();
        int numberOfProducts = getNumberOfProducts();

        if (numberOfProducts >= 5){
            return totalPrice*0.1;
        } else {
            return 0.0;
        }
    }

    private double getDiscountFourthItem(){
        HashMap <String, Integer> productCount = getProductCount();

    }

    //calculate total price of cart content ArrayList<Product>
    private double getTotalPrice(){
        double totalPrice = 0.0;
        int numberOfProducts = getNumberOfProducts();

        for (int i = 0; i < numberOfProducts; i++) {
            totalPrice += this.productsInCart.get(i).price;
        }
       return totalPrice;
    }

    private int getNumberOfProducts(){
        return this.productsInCart.size();
    }
}
