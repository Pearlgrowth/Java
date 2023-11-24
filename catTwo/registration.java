package catTwo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class registration extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField NAME;
    private JTextField USERNAME;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JTextField EMAIL;
    private JTextField PHONE;
    private JTextField ADDRESS;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    registration frame = new registration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public registration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 679, 489);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Register Form");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 27));
        lblNewLabel.setBounds(10, 0, 206, 34);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(130, 45, 46, 14);
        contentPane.add(lblNewLabel_1);

        NAME = new JTextField();
        NAME.setBounds(207, 44, 408, 20);
        contentPane.add(NAME);
        NAME.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Username:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(102, 87, 74, 14);
        contentPane.add(lblNewLabel_2);

        USERNAME = new JTextField();
        USERNAME.setBounds(207, 86, 408, 20);
        contentPane.add(USERNAME);
        USERNAME.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Password:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(102, 124, 85, 14);
        contentPane.add(lblNewLabel_3);

        passwordField = new JPasswordField();
        passwordField.setBounds(209, 123, 406, 20);
        contentPane.add(passwordField);

        JLabel lblNewLabel_4 = new JLabel("Confirm Password:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(46, 166, 141, 14);
        contentPane.add(lblNewLabel_4);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(207, 165, 406, 20);
        contentPane.add(passwordField_1);

        JLabel lblNewLabel_5 = new JLabel("Email:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(130, 202, 46, 14);
        contentPane.add(lblNewLabel_5);

        EMAIL = new JTextField();
        EMAIL.setBounds(207, 196, 408, 20);
        contentPane.add(EMAIL);
        EMAIL.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Phone:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(123, 244, 74, 14);
        contentPane.add(lblNewLabel_6);

        PHONE = new JTextField();
        PHONE.setBounds(207, 243, 408, 20);
        contentPane.add(PHONE);
        PHONE.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Address:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_7.setBounds(112, 298, 85, 14);
        contentPane.add(lblNewLabel_7);

        ADDRESS = new JTextField();
        ADDRESS.setBounds(207, 297, 408, 20);
        contentPane.add(ADDRESS);
        ADDRESS.setColumns(10);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/catTwo", "root",
                            "hainapassword");
                    String sql = "INSERT INTO UserRegistration (Name,Username,Password,ConfirmPassword,Email,Phone,Address) VALUES (?, ?, ?,?,?,?,?)";
                    PreparedStatement pr = con.prepareStatement(sql);
                    pr.setString(1, NAME.getText());
                    pr.setString(2, USERNAME.getText());
                    pr.setString(3, passwordField.getText());
                    pr.setString(4, passwordField_1.getText());
                    pr.setString(5, EMAIL.getText());
                    pr.setString(6, PHONE.getText());
                    pr.setString(7, ADDRESS.getText());
                    int count = pr.executeUpdate();
                    if (count == 1) {
                        JOptionPane.showMessageDialog(null, "Record added successfully");
                        NAME.setText("");
                        USERNAME.setText("");
                        passwordField.setText("");
                        passwordField_1.setText("");
                        EMAIL.setText("");
                        PHONE.setText("");
                        ADDRESS.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No record added");
                    }
                    con.close();

                } catch (Exception d) {
                    d.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(179, 383, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Reset");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(306, 383, 89, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Close");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_2.setBounds(451, 383, 89, 23);
        contentPane.add(btnNewButton_2);
    }
}
