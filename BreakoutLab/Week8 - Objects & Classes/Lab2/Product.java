 public class Product {
   
   /* Type your code here */
     private String productCode;
     private double productPrice;
     private int productCount;
     public Product(String code, double price, int count) {
         productCode = code;
         productPrice = price;
         productCount = count;
     }

     public void setCode(String code) {
         productCode = code;
     }

     public String getCode() {
         return productCode;
     }

     public void setPrice(double p) {
         productPrice = p;
     }

     public double getPrice() {
         return productPrice;
     }

     public void setCount(int num) {
         productCount = num;
     }

     public int getCount() {
         return productCount;
     }

     public void addInventory(int amt) {
         productCount += amt;
     }

     public void sellInventory(int amt) {
         productCount -= amt;
     }


}
