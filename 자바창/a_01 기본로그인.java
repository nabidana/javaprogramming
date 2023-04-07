package JAVAFD;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Qslad extends JFrame{
    private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
    private JLabel idLabel = new JLabel("ID ");
    private JLabel pwLabel = new JLabel("PW ");
    private JTextField idText = new JTextField();
    private JPasswordField pwText = new JPasswordField();
    private JButton loginBtn = new JButton("LOGIN");
    private JButton searchBtn = new JButton("ID/PW 찾기");

    public Qslad() {
        super("LOGIN CASE");
        this.setContentPane(loginPanel);
        loginPanel.add(idLabel);
        loginPanel.add(pwLabel);
        loginPanel.add(idText);
        loginPanel.add(pwText);
        loginPanel.add(searchBtn);
        loginPanel.add(loginBtn);

        //라벨 가운데 정렬
        idLabel.setHorizontalAlignment(NORMAL);
        pwLabel.setHorizontalAlignment(NORMAL);

        //창 가운데 정렬
        setSize(350,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //login버튼 눌럿을 때
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //ID,PW 확인
                String id = idText.getText().trim();
                String pw = pwText.getText().trim();

                if(id.length() == 0 || pw.length() == 0) {
                    JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력해야 합니다."
                    ,"아이디나 비밀번호를 입력하세요", JOptionPane.DEFAULT_OPTION);
                    return;
                }

                if(id.equals("test") && pw.equals("test1")) {
                    JOptionPane.showMessageDialog(null, "LOGIN SUCCESS",
                    "로그인 성공", JOptionPane.DEFAULT_OPTION);
                    return;
                }

                JOptionPane.showMessageDialog(null, "로그인 실패",
                "LOGINFAIL", JOptionPane.DEFAULT_OPTION);
            }
        });

        // 아이디비번 찾기 버튼 클릭시
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "아이디 비번 찾기",
                "ID/PW찾기", JOptionPane.DEFAULT_OPTION);
            }
        });
    }
    public static void main(String[] args) {
        new Qslad();
    }
}
