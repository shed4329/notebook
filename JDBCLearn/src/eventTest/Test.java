package eventTest;

import Util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    /**
     * 转出操作
     * @param connection
     * @param userName
     * @param count
     */
    public static void outMoney(Connection connection,String userName,int count){
        try {
            String sql ="update count set money=money-? where userName=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,count);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            int a = 1/0;//出现异常，李四收不到前
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void inMoney(Connection connection,String userName,int count){
        try {
            String sql ="update count set money=money+? where userName=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,count);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        Connection connection = dbUtil.getConnection();
        try {
            connection.setAutoCommit(false);//取消自动提交
            System.out.println("张三开始转账给李四");
            outMoney(connection,"张三",200);
            inMoney(connection,"李四",200);
            System.out.println("转账成功");
        }catch (Exception e){
            try {
                System.out.println("转账失败，开始回滚");
                connection.rollback();//事务回滚
            } catch (SQLException ex) {
                System.out.println("会滚失败");
                throw new RuntimeException(ex);
            }
        }
        dbUtil.closeConnection(connection);
    }
}
