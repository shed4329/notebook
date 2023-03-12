import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
    private static String driverName="com.mysql.cj.jdbc.Driver";//新驱动名称
    private static String url="jdbc:mysql://localhost:3305/dbTest01?serverTimezone=UTC";//必须加时区这个参数，否则时区错误The server time zone value '�й���׼ʱ��' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
    //jdbc6.0以上都有这个问题
    private static String userName="root";
    private static String password="123456";

    public static void main(String[] args) throws Exception {
        Class.forName(driverName);
        System.out.println("数据库驱动加载成功");
        //url格式：jdbc:mysql://IP地址:端口号/数据库名称?额外参数
        Connection connection = DriverManager.getConnection(url,userName,password);
        System.out.println("数据库连接成功");
        System.out.println("数据库操作中...");
        connection.close();
        System.out.println("数据库关闭成功");
    }
}
