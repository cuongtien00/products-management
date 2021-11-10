package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceIpml implements ProductService{
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"IpX","8","90%","USA"));
        products.put(2,new Product(2,"Ip11","10","90%","NA"));
        products.put(3,new Product(3,"Ip12","15","99%","US"));
        products.put(4,new Product(4,"Ip13","17","95%","VN"));
        products.put(5,new Product(5,"IpXS-MAX","12","80%","JP"));
        products.put(6,new Product(6,"Ip13 Pro Max","35","100%","UK"));
        products.put(7,new Product(7,"Ip12 Pro Max","28","100%","OK"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
products.put(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
