package model.repository;

import model.bean.Product;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {

    private static Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Iphone", "30000000", "Đây là Iphone", "Apple"));
        productList.put(2, new Product(2, "Samsung", "20000000", "Đây là Samsung", "Samsung"));
        productList.put(3, new Product(3, "Nokia", "10000000", "Đây là Nokia", "Nokia"));
        productList.put(4, new Product(4, "Sony", "5000000", "Đây là Sony", "sony"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product findByName(String name) {
        Set<Integer> set = productList.keySet();
        Product product = null;
        for (Integer key : set) {
            if (productList.get(key).getNameProduct().equals(name)) {
                product = productList.get(key);
            }
        }
        return product;
    }
}
