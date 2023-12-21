package by.it.academy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EShopDataSource {


    private static EShopDataSource dataSource;
    protected EShopDataSource() throws ClassNotFoundException {

        //Load JDBC driver for my sql
    Class.forName("com.mysql.cj.jdbc.Driver");

    }
    protected Connection getEShopConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/eshop",
                "user",
                "user");
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(dataSource == null){
            dataSource = new EShopDataSource();
        }
        return dataSource.getEShopConnection();
    }
}
