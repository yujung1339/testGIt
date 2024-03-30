import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

public class UpdateView extends JFrame implements ActionListener {
    // 필드 정의하기
    private JTextField inputId;
    private JTextField inputName;
    private JTextField inputPw;

    // 생성자
    public UpdateView() {
        setSize(500, 200);
        setLocationRelativeTo(null); // 화면 가운데에 위치하도록 설정
        setDefaultCloseOperation(EXIT_ON_CLOSE); // JFrame이 닫힐 때 프로그램을 종료하도록 설정하는 메서드
        setLayout(new BorderLayout());

        JLabel title = new JLabel("마이페이지", JLabel.CENTER);

        inputId = new JTextField(10);
        inputName = new JTextField(10);
        inputPw = new JTextField(10);

        // "ID: "라는 JLabel 생성
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // 패널에 UI를 추가
        idPanel.add(new JLabel("아이디: "));
        idPanel.add(inputId);

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        namePanel.add(new JLabel("이름: "));
        namePanel.add(inputName);


        JPanel pwPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pwPanel.add(new JLabel("비밀번호: "));
        pwPanel.add(inputPw);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 1));
        formPanel.add(idPanel);
        formPanel.add(namePanel);
        formPanel.add(pwPanel);

        JPanel contentPanel = new JPanel(new FlowLayout());
        contentPanel.add(formPanel);


        // 문자열을 입력할 수 있는 JTextField 생성

        // 전송버튼
        JButton update = new JButton("수정");
        update.setActionCommand("update");
        update.addActionListener(this);

        // 삭제버튼
        JButton delete = new JButton("삭제");
        delete.setActionCommand("delete");
        delete.addActionListener(this);

        // 패널 객체를 생성해서
        JPanel buttonPanel = new JPanel(new FlowLayout());// FlowLayout 사용하여 버튼들이 화면 가운데에 위치하도록 설정

        // 버튼 패널에 버튼 추가
        buttonPanel.add(update);
        buttonPanel.add(delete);

        add(title, BorderLayout.NORTH);
        // 패널 통째로 프레임에 추가하기
        add(contentPanel, BorderLayout.CENTER);

        // 버튼 패널 프레임에 추가하기
        add(buttonPanel, BorderLayout.SOUTH);


        setVisible(true);
    }

    // run 했을 때 실행 순서가 시작되는 main 메소드
    public static void main(String[] args) {
        new UpdateView();
    }

    // ActionListener 인터페이스를 구현해서 강제로 Override 한 메소드
    @Override
    public void actionPerformed(ActionEvent e) {
        // 이벤트가 발생한 버튼에 설정된 action command 읽어오기
        String command = e.getActionCommand();
        if (command.equals("update")) {
            // JTextField에 입력한 문자열 읽어오기
            String msgId = inputId.getText();
            String msgName = inputName.getText();
            String msgPw = inputPw.getText();
            String url = "jdbc:mysql://localhost:3306/yujung";

            String user = "root";
            String password = "00000000";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);

                String userId = msgId; // 업데이트할 사용자의 아이디
                String newUsername = msgName; // 새로운 사용자 이름
                String newPw = msgPw; // 새로운 비밀번호

                String query = "UPDATE User SET userid = ?, username = ?, pw = ? WHERE userid = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, userId);
                pstmt.setString(2, newUsername);
                pstmt.setString(3, newPw);
                pstmt.setString(4, userId);

                int rowsAffected = pstmt.executeUpdate();

                // JOptionPane을 통해 메시지 보여주기
                if (rowsAffected == 1) {
                    JOptionPane.showMessageDialog(this, "회원정보 수정이 완료되었습니다.");
                } else {
                    JOptionPane.showMessageDialog(this, "회원정보 수정에 실패하였습니다.");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }


        } else if (command.equals("delete")) {

            String url = "jdbc:mysql://localhost:3306/yujung";
            String user = "root";
            String password = "00000000";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);

                String msgId = inputId.getText();

                String query = "DELETE FROM User WHERE userid = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, msgId);

                int rowsAffected = pstmt.executeUpdate();
                // JOptionPane을 통해 메시지 보여주기
                if (rowsAffected == 1) {
                    JOptionPane.showMessageDialog(this, "회원정보 삭제가 완료되었습니다.");
                } else {
                    JOptionPane.showMessageDialog(this, "회원정보 삭제에 실패하였습니다.");
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}