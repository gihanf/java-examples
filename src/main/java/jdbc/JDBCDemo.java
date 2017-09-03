package jdbc;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {
        String sql = "select * from animal";

        try (Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_FORWARD_ONLY,
                     ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println(rs.absolute(5));
            System.out.println(rs.previous());
            System.out.println(rs.relative(-2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
