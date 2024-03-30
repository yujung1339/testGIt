import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yujung";
        String user = "root";
        String password = "00000000";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String userId = "id1234";

            String query = "DELETE FROM User WHERE userid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, userId);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("삭제된 행의 수 : " + rowsAffected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}