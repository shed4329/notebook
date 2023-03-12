import Util.DbUtil;

import java.sql.*;
//结果集
public class ResultSetTest {
    public static void listData() {
        try {
            String sql = "select * from emp;";
            DbUtil dbUtil = new DbUtil();
            Connection connection = dbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {//如果还有下一条数据
                int id = resultSet.getInt("empno");
                String name = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hireDate = resultSet.getDate("hireDate");
                int salary = resultSet.getInt("sal");
                int praise = resultSet.getInt("comm");
                int deptNo = resultSet.getInt("deptno");
                System.out.println("id="+id+" name="+name+" job="+job+" mgr="+mgr+" hireDate="+hireDate+" salary="+salary+" comm="+praise+" deptNumber="+deptNo);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        listData();
    }
}
