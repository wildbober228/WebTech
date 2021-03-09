package servlets;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
public class tt1 {

    public void check() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hero", "root", "1234");
            if(connection.isValid(10)) System.out.println("connection is good");
            else System.out.println("failed");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
