package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static String driverName="com.mysql.cj.jdbc.Driver";//新驱动名称
    private static String url="jdbc:mysql://localhost:3305/dbTest01?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";//必须加时区这个参数，否则时区错误The server time zone value '�й���׼ʱ��' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
    //jdbc6.0以上都有这个问题
    private static String userName="root";
    private static String password="123456";

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        try {
            Class.forName(driverName);
            System.out.println("数据库驱动加载成功");
            Connection connection = DriverManager.getConnection(url,userName,password);
            System.out.println("数据库连接成功");
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭连接
     * @param connection
     */
    public void closeConnection(Connection connection){
        if (connection==null){
            System.err.println("数据库连接为空");
        }else{
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
