import java.util.*;

public class ShoppingCart {
    
    /*Declare the properties*/
    //TYPE,  TYPE of list, Name
    ArrayList<Product> productsInCart;
    int numberOfProducts;
    double totalPrice;
    double discountFivePlusProducts;
    double discountFourthProduct;
    double totalDiscount;
    double finalPrice;

    //**Initialize the properties with Constructor
    ShoppingCart(){
        this.productsInCart = new ArrayList<Product>();
        this.totalPrice = 0.0;
        this.totalDiscount = 0.0;
        this.finalPrice = 0.0;
    }
    
    /*Set the Methods*/
    private void updateCart() {
        setNumberOfProducts();
        setTotalPrice();
        setDiscountFourthProduct();
        setDiscountFivePlusProducts();
        setTotalDiscount();
        setFinalPrice();
    }

    //add a product to the ArrayList productsInCart (ShoppingCart)
    public void addProduct(Product product) {
        this.productsInCart.add(product);
        updateCart();
        System.out.println(product.name + " added to cart");
    }

    //output the contents of the cart
    public String toString() {
        return "Your cart contains:" + this.productsInCart +
                " Total price = " + this.totalPrice +
                " Discount = " + this.totalDiscount +
                " Final amount = " + this.finalPrice;
    }

    //get price of products
    private HashMap<String , Double> getProductPrices(){
        HashMap<String, Double> productPrices = new HashMap<>();

        this.productsInCart.forEach((Product)->{
            productPrices.put(Product.name,Product.price);
        });
        return productPrices;
    }

    //get count of all products added to Shoppingcart
    private HashMap <String, Integer> getProductCount() {
        HashMap <String, Integer> productsCounter = new HashMap<>();
        String productName;
        Integer productCount;

        for (int i = 0; i < this.numberOfProducts; i++) {
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
    private void setDiscountFivePlusProducts () {
        double totalPrice = this.totalPrice;

        if (this.numberOfProducts >= 5){
            this.discountFivePlusProducts = totalPrice*0.1;
        } else {
            this.discountFivePlusProducts = 0.0;
        }
    }

    private void setDiscountFourthProduct() {
        HashMap<String, Integer> productCount = getProductCount();
        HashMap<String, Double> productPrices = getProductPrices();

            //Fer every element of TYPE > pass variable  :  map entries
        for(HashMap.Entry<String,Integer> entry : productCount.entrySet()){
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println("v = " + v);
            if (v % 4 == 0) {
                this.discountFourthProduct += (v/4) * productPrices.get(k);
            }
        };
    }
    
    private void setTotalDiscount(){
       this.totalDiscount = this.discountFivePlusProducts + this.discountFourthProduct;
    }
    
    //calculate total price of cart content ArrayList<Product>
    private void setTotalPrice(){
        double totalPrice = 0.0;

        for (int i = 0; i < this.numberOfProducts; i++) {
            totalPrice += this.productsInCart.get(i).price;
        }
       this.totalPrice = totalPrice;
    }

    private void setNumberOfProducts(){
        this.numberOfProducts = this.productsInCart.size();
    }

    private void setFinalPrice(){
        this.finalPrice = this.totalPrice - this.totalDiscount;
    }
}
