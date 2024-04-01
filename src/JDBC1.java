import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yujung";
        String que = "insert into user(userid, username, pw)" + "values(?,?,?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "00000000");

            pstmt = con.prepareStatement(que);

            pstmt.setString(1, "id1234");
            pstmt.setString(2, "name1234");
            pstmt.setString(3, "pw1234");

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("삽입된 행의 수 : " + rowsAffected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
