package dao;

import model.Product;

public class ProductDAO {
    public static void insertProduct(Product product) {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";

        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.connect(sql, product.getName(), product.getPrice());
    }
}
