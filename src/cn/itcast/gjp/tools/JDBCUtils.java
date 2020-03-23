package cn.itcast.gjp.tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @program: GuanJiaPo
 * @description:
 * @author: Wang Jun
 * @create: 2020-03-18 10:49
 */
public class JDBCUtils {
    private static BasicDataSource dataSource = new BasicDataSource();
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gjp");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(3);
        dataSource.setInitialSize(10);
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
