package myjdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/2/20.
 */
public class JDBCDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        1.加载MySQL驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

//        2.连接到指定的数据库,返回一个连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cxh_jdbc?serverTimezone=GMT","root","root");

//        3.通过连接对象,获取sql语句的执行对象
        Statement stat = conn.createStatement();

//        4.通过sql语句的执行对象,进行执行指定的sql语句,得到sql语句的执行结果集
        String sql = "INSERT INTO sort(sid,sname) VALUES('c005','食品')";
        int line = stat.executeUpdate(sql);

//        5.查询结果集中的内容
        System.out.println("line=" + line);

//        6.释放连接数据库的资源
        stat.close();
        conn.close();
    }

}
