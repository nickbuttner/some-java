package test;

import dao.ProductDAO;
import model.Product;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        Product product = new Product("Example Product", 29.99);
        ProductDAO.insertProduct(product);
    }
}