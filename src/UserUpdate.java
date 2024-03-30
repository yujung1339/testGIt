import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yujung";
        String user = "root";
        String password = "00000000";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String userId = "id1234"; // 업데이트할 사용자의 아이디
            String newUserId = "id5678"; // 새로운 사용자 아이디
            String newUsername = "namehihi"; // 새로운 사용자 이름
            String newPw = "pw5678"; // 새로운 비밀번호

            String query = "UPDATE User SET userid = ?, username = ?, pw = ? WHERE userid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, newUserId);
            pstmt.setString(2, newUsername);
            pstmt.setString(3, newPw);
            pstmt.setString(4, userId);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("수정된 행의 수 : " + rowsAffected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}