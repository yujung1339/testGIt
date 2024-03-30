import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UpdateView extends JFrame implements ActionListener {
    // 필드 정의하기
    private JTextField inputId;
    private JTextField inputName;
    private JTextField inputPw;

    // 생성자
    public UpdateView() {
        setSize(500, 300);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame이 닫힐 때 프로그램을 종료하도록 설정하는 메서드

        // FlowLayout 객체 전달하기
        setLayout(new BorderLayout());

        // "ID: "라는 JLabel 생성
        JLabel LabelId = new JLabel("아이디: ");
        JLabel LabelName = new JLabel("이름: ");
        JLabel LabelPw = new JLabel("비밀번호: ");

        // 문자열을 입력할 수 있는 JTextField 생성
        inputId = new JTextField(10);
        inputName = new JTextField(10);
        inputPw = new JTextField(10);

        // 전송버튼
        JButton update = new JButton("수정");
        update.setActionCommand("update");
        update.addActionListener(this);

        // 삭제버튼
        JButton delete = new JButton("삭제");
        delete.setActionCommand("delete");
        delete.addActionListener(this);

        // 패널 객체를 생성해서
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.setSize(800,500);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        // 패널에 UI를 추가하고
        panel.add(LabelId);
        panel.add(inputId);
        panel.add(LabelName);
        panel.add(inputName);
        panel.add(LabelPw);
        panel.add(inputPw);
        panel2.add(update);
        panel2.add(delete);
        // 패널 통째로 프레임에 추가하기
        add(panel,BorderLayout.NORTH);
        add(panel2,BorderLayout.SOUTH);
//코드추가
        setVisible(true);
        
        //유정아 안녕
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
            // JOptionPane을 통해 메시지 보여주기
            JOptionPane.showMessageDialog(this, "아이디: " + msgId + "\n이름: " + msgName + "\n비밀번호: " + msgPw);
        } else if (command.equals("delete")) {
            // 빈 문자열을 넣어주어서 삭제하기
            inputId.setText("");
            inputName.setText("");
            inputPw.setText("");
            //.......

        }
    }
}
