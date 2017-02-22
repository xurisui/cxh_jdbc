package myjdbc;

import org.junit.Test;

import java.sql.*;

/**
 * 在测试类中测试jdbc的增删改查操作
 */
public class PreparedStatementDemo {

    @Test
    //插入操作
    public void insert() {

        try {
//        1.加载MySQL驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

//        2.连接到指定的数据库,返回一个 连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cxh_jdbc?serverTimezone=GMT","root","root");

//        3.通过连接对象,获取sql语句的 执行对象
//            Statement stat = conn.createStatement();

            String sql = "INSERT  INTO sort(sid, sname) VALUES (?,?)";
            PreparedStatement ppstat = conn.prepareStatement(sql);

//        4.通过Statement对象,进行执行指定的sql语句
//            String sql = "INSERT INTO sort(sid,sname) VALUES('c005','食品')";
//            int line = stat.executeUpdate(sql);

            ppstat.setString(1,"c006");
            ppstat.setString(2,"床上用品");
            int line = ppstat.executeUpdate();
//        5.查询结果集中的内容
            System.out.println("line=" + line);

//        6.释放连接数据库的资源
//            stat.close();
//            conn.close();

            ppstat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //更新操作
    @Test
    public void update() {

        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cxh_jdbc?serverTimezone=GMT","root","root");

            //通过连接对象，获取sql语句的执行对象
            String sql = "UPDATE sort SET sname='日用品' WHERE sid=?";
            PreparedStatement ppstat = conn.prepareStatement(sql);

            //通过statement对象，执行指定的sql语句
            ppstat.setString(1,"c004");
            int line = ppstat.executeUpdate();

            //处理结果集
            System.out.println("ling=" + line);

            //释放资源
            ppstat.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    //删除操作
    public void delete() {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cxh_jdbc?serverTimezone=GMT","root","root");

            //通过连接对象，获取sql语句的执行对象
            String sql = "DELETE FROM sort WHERE sid=?";
            PreparedStatement ppstat = conn.prepareStatement(sql);

            //通过Statement对象，执行指定的sql语句
            ppstat.setString(1,"003");
            int line = ppstat.executeUpdate();

            //处理结果集
            System.out.println("line=" + line);

            //释放资源
            ppstat.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    //查询操作
    public void query() {
        try {

            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cxh_jdbc?serverTimezone=GMT","root","root");

            //通过连接对象，获取sql语句的执行对象
            String sql = "SELECT * FROM sort WHERE sname like ?";
            PreparedStatement ppstate = conn.prepareStatement(sql);

            //通过statement对象，执行指定的sql语句
            ppstate.setString(1,"%果%");
            ResultSet rs = ppstate.executeQuery();

            //处理结果集
            while (rs.next()) {
                //获取当前行中指定列名的数据
                String sid = rs.getString("sid");
                String sname = rs.getString("sname");
                System.out.println(sid + "-----" + sname);
            }

            //释放资源
            rs.close();
            ppstate.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

