package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2017/2/23.
 */
public class JDBCUtils {
    public static Connection getConnection() {

        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cxh_jdbc","root","root");

            return conn;
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
