package bussiness;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rio
 */
import data.ProductDAO;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<LineItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Cart(List<LineItem> items) {
        this.items = items;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        double sum = 0;
        for (LineItem i : items) {
            sum += i.getAmount();
        }
        return sum;
    }

    public void addItem(String code) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getProdCode().equals(code)) {
                LineItem item = items.get(i);
                item.setQuantity(item.getQuantity() + 1);
                items.set(i, item);
                return;
            }
        }
        Product product = ProductDAO.getProduct(code);
        LineItem item = new LineItem(product, 1);
        items.add(item);
    }

    public void removeItem(String code) {
        System.out.println("code to rm: "+code);
        LineItem item = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getProdCode().equals(code)) {
                item = items.get(i);
                break;
            }
        }
        System.out.println("~~~~item to remove : "+ item);
        if (item != null) {
            items.remove(item);
            System.out.println("rm sucess");
        } else {
            System.out.println("not rm yet");
        }
    }

    public void updateQuantity(String code, int quantity){
        LineItem item = null;
        int found = 0;
        
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getProduct().getProdCode().equals(code)){
                item = items.get(i);
                System.out.println("item == "+item);
                found = i;
                break;
            }
        }
        if(item != null){
            item.setQuantity(quantity);
            items.set(found, item);
        }else{
            System.out.println("item not found, cannot update");
        }
    }
    @Override
    public String toString() {
        return "Cart{" + "items=" + items + '}';
    }

}
