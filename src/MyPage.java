import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class MyPage extends JFrame {
    private JButton updateButton;

    public MyPage() {
        setTitle("마이페이지");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫을때 프로그램을 종료하도록 설정하는 메서드
        setSize(150, 150);

        updateButton = new JButton("정보 수정"); //사용자가 "정보 수정" 버튼을 클릭했을 때 수행되는 동작을 정의
        updateButton.addActionListener(new ActionListener() { //사용자가 버튼을 클릭할 때마다 이벤트가 발생
            public void actionPerformed(ActionEvent e) { //사용자가 버튼을 클릭하면 actionPerformed 메서드가 호출
                Map<String, String> userInfo = new HashMap<String, String>(); //이 HashMap은 사용자의 아이디, 이름, 비밀번호를 저장
                userInfo.put("userId", "yujung1339");
                userInfo.put("userName", "손유정");
                userInfo.put("pw", "1234");
                updateUserInfo(userInfo);
            }
        });

        getContentPane().add(updateButton);
        setVisible(true);
    }

    public void updateUserInfo(Map<String, String> userInfo) {
        // 사용자 정보를 수정하는 코드
        // 위에서 작성한 UserUpdate 클래스의 코드를 활용하여 사용자 정보를 수정합니다.
        String url = "jdbc:mysql://localhost:3306/yujung";

        String user = "root";
        String password = "00000000";

        System.out.println("userInfo>>" + userInfo);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String userId = userInfo.get("userId"); // 업데이트할 사용자의 아이디
            String newUsername = userInfo.get("userName"); // 새로운 사용자 이름
            String newPw = userInfo.get("pw"); // 새로운 비밀번호

            String query = "UPDATE User SET userid = ?, username = ?, pw = ? WHERE userid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.setString(2, newUsername);
            pstmt.setString(3, newPw);
            pstmt.setString(4, userId);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("수정된 행의 수 : " + rowsAffected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyPage();
    }
}