
package bussiness;


public class LineItem {
    private Product product;
    private int quantity;
    public LineItem(Product pr, int quantity) {
        this.product = pr;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     
    public double getAmount(){
        return product.getProdPrice()*quantity;
    }

    @Override
    public String toString() {
        return "LineItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }
    
}
