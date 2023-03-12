import Util.DbUtil;
import entity.Personnel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddTest {
    public static void add(Personnel personnel){
        try {
        String sql = "INSERT INTO emp values("+personnel.getId()+","+"'"+personnel.getName()+"'"+",'"+personnel.getJob()+"',"+personnel.getMgr()+",'"+personnel.getHireDate()+"',"+850+","+personnel.getPraise()+","+personnel.getDepartmentNumber()+");";
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

    public static void main(String[] args) throws ParseException {
        Personnel personnel1 = new Personnel();
        personnel1.setId(7992);
        personnel1.setJob("TYPER");
        personnel1.setMgr(5665);
        personnel1.setName("Swiss");
        personnel1.setPraise(50);
        personnel1.setDepartmentNumber(20);
        personnel1.setHireDate(Date.valueOf("1998-07-02"));
        personnel1.setSalary(1225);
        add(personnel1);
    }
}
