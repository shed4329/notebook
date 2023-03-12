import Util.DbUtil;
import entity.Personnel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class updateTest {
    public static void delete(Personnel personnel){
        try {
            String sql ="update emp set deptno="+personnel.getDepartmentNumber()+",sal="+personnel.getSalary()+" where empno="+personnel.getId()+";";
            System.out.println(sql);
            DbUtil dbUtil = new DbUtil();
            Connection connection = dbUtil.getConnection();
            Statement statement = connection.createStatement();
            int num = statement.executeUpdate(sql);
            System.out.println("操作了"+num+"条数据");
            statement.close();
            dbUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Personnel personnel = new Personnel();
        personnel.setDepartmentNumber(10);
        personnel.setSalary(2000);
        personnel.setId(7499);
        delete(personnel);
    }
}
