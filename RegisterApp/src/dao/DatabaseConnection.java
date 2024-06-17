package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

 public class DatabaseConnection {
    private String url; /*jdbc:mysql://localhost:3306/loja_ap2_2?zeroDateTimeBehavior=convertToNull */
    private String username;
    private String password;
    private String driver; /*"com.mysql.jdbc.Driver" */

    public DatabaseConnection() {
        this.url = System.getenv("URL_LOCALHOST");
        this.username = System.getenv("DB_USERNAME");
        this.password = System.getenv("DB_PASSWORD");
        this.driver = System.getenv("DB_DRIVER");
    }    

   
    public void connect(String query, Object... params) {
        System.out.println("Conectado ao banco, no usuario " + username);
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            pstmt.execute();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public ResultSet consult(String query) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(query);
            return pstmt.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
}