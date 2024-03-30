import java.sql.*;

public class JDBC2 {
    public static void main(String[] args) throws SQLException {

        Connection con = null; // DB와 연결하는 인터페이스
        PreparedStatement psmt = null; // sql문 객체
        ResultSet rs = null; // sql에 대한 반환 (쿼리 실행에 대한 결과값 저장)

        String url = "jdbc:mysql://localhost:3306/yujung";

        try {
            String que = "select * from user";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "00000000");

            psmt = con.prepareStatement(que);
            rs = psmt.executeQuery();

            while (rs.next()) {
                // DB에 있는 값들을 가져옴(행 기준)
                String userid = rs.getString(1);
                String username = rs.getString(2);
                String pw = rs.getString(3);

                System.out.println(userid + " " + username + " " + pw);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        rs.close();
        psmt.close();
        con.close();
    }
}
