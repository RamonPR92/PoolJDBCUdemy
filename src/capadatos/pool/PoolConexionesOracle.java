/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos.pool;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author rperez
 */
public class PoolConexionesOracle {
   
    public static DataSource getDataSource(){
        BasicDataSource basicDataSource =  new BasicDataSource();
        basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        basicDataSource.setUsername("hr");
        basicDataSource.setPassword("hr");
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        basicDataSource.setInitialSize(5);
        return basicDataSource;
    }
    
    public static Connection getConnection()throws SQLException{
        return getDataSource().getConnection();
    }
}
