/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooljdbc;
import capadatos.pool.PoolConexionesMySql;
import capadatos.pool.PoolConexionesOracle;
import java.sql.*;
/**
 *
 * @author rperez
 */
public class PoolJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = PoolConexionesMySql.getConnection();
            System.out.println("Utilizamos el pool de conexiones de MYSQL");
            preparedStatement = connection.prepareStatement("SELECT * FROM persona");
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                System.out.println(" " + resultSet.getInt(1));
                System.out.println(" " + resultSet.getString(2));
                System.out.println(" " + resultSet.getString(3));
            }
            
            connection.close();
            
            connection = PoolConexionesOracle.getConnection();
            System.out.println("Utilizamos el pool de conexiones de Oracle");
            preparedStatement = connection.prepareStatement("SELECT * FROM  employees WHERE employee_id in(100,101,102)");
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                System.out.println(" " + resultSet.getInt(1));
                System.out.println(" " + resultSet.getString(2));
                System.out.println(" " + resultSet.getString(3));
            }
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
