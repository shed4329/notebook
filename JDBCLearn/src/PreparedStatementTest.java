import Util.DbUtil;
import entity.Personnel;

import java.sql.*;

public class PreparedStatementTest {
    //一般用PreparedStatement预编译，方便快捷
    public static void add(Personnel personnel){
        try {
            String sql = "INSERT INTO emp values(?,?,?,?,?,?,?,?)";
            System.out.println(sql);
            DbUtil dbUtil = new DbUtil();
            Connection connection = dbUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);//sql预编译
            statement.setInt(1,personnel.getId());//参数1，值为7765
            statement.setString(2,personnel.getName());
            statement.setString(3, personnel.getJob());
            statement.setInt(4,personnel.getMgr());
            statement.setDate(5, personnel.getHireDate());
            statement.setInt(6,personnel.getSalary());
            statement.setInt(7,personnel.getPraise());
            statement.setInt(8,personnel.getDepartmentNumber());
            int num = statement.executeUpdate();
            System.out.println("操作了"+num+"条数据");
            statement.close();
            dbUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Personnel personnel1 = new Personnel();
        personnel1.setId(7992);
        personnel1.setJob("TYPER");
        personnel1.setMgr(5665);
        personnel1.setName("狂三");//可能乱码，在URL连接时加上?useUnicode=true&characterEncoding=utf-8
        //当前操作没有乱码
        personnel1.setPraise(50);
        personnel1.setDepartmentNumber(20);
        personnel1.setHireDate(Date.valueOf("1998-07-02"));
        personnel1.setSalary(1225);
        add(personnel1);
        delete(personnel1.getId());
        update(7844,40);
    }
    public static void delete(Integer id){
        try {
            String sql = "delete from emp where empno=?;";
            System.out.println(sql);
            DbUtil dbUtil = new DbUtil();
            Connection connection = dbUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int num = statement.executeUpdate();
            System.out.println("操作了"+num+"条数据");
            statement.close();
            dbUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void update(Integer id,Integer departmentId){
        try {
            String sql ="update emp set deptno=? where empno=?;";
            System.out.println(sql);
            DbUtil dbUtil = new DbUtil();
            Connection connection = dbUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,departmentId);
            statement.setInt(2,id);
            int num = statement.executeUpdate();
            System.out.println("操作了"+num+"条数据");
            statement.close();
            dbUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
