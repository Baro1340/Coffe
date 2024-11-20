import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomPasswordFieldExample extends JFrame {
    private JPasswordField passwordField;
    private JButton showPasswordButton;

    public CustomPasswordFieldExample() {
        setTitle("Custom Password Field Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Tạo Password Field
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        add(passwordField);

        // Tạo Button để hiển thị mật khẩu
        showPasswordButton = new JButton("Show Password");
        add(showPasswordButton);

        // Tạo Action Listener cho button "Show Password"
        ActionListener showPasswordActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra trạng thái hiển thị mật khẩu
                if (passwordField.getEchoChar() == '*') {
                    // Nếu đang ẩn, hiển thị mật khẩu
                    passwordField.setEchoChar((char) 0);
                    showPasswordButton.setText("Hide Password");
                } else {
                    // Nếu đang hiển thị, ẩn mật khẩu
                    passwordField.setEchoChar('*');
                    showPasswordButton.setText("Show Password");
                }
            }
        };
        showPasswordButton.addActionListener(showPasswordActionListener);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CustomPasswordFieldExample example = new CustomPasswordFieldExample();
                example.setVisible(true);
            }
        });
    }
}