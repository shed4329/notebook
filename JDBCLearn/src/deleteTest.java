import Util.DbUtil;
import entity.Personnel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteTest {
    public static void delete(Integer id){
        try {
            String sql = "delete from emp where empno="+id+";";
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
        delete(7992);
    }
}
