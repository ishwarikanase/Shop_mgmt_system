import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Page1 {
    private JPanel p1;
    private JLabel l1;
    private JLabel l2;
    private JTextField t1;
    private JLabel l3;
    private JPasswordField password;
    private JButton b1, b2;

    JFrame j1;

    JLabel background;


    public Page1() {

        j1 = new JFrame("Login");

        j1.setLayout(null);

        try {
            j1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\src\\coffee.jpg")))));
        } catch (Exception ie) {
            ie.printStackTrace();
        }

        j1.add(l1);

        l1.setBounds(175, 15, 100, 50);
        l1.setForeground(Color.white);

        l2.setBounds(50, 75, 100, 30);
        l2.setForeground(Color.white);
        t1.setBounds(150, 75, 200, 30);


        l3.setBounds(50, 130, 100, 30);
        l3.setForeground(Color.white);
        password.setBounds(150, 130, 200, 30);

        b1.setBounds(100, 200, 100, 30);
        b1.setBackground(Color.white);

        b2.setBounds(210, 200, 100, 30);
        b2.setBackground(Color.white);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String d1, d2;
                    d1 = t1.getText();
                    d2 = new String(password.getPassword());
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/project", "root", "ishwari");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from login");
                    while (rs.next()) {
                        String uname = rs.getString(1);
                        String pass = rs.getString(2);
                        if (uname.equals(d1) && pass.equals(d2)) {

                            j1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                            j1.setVisible(false);

                            System.out.println("success");
                            Page2 obj2 = new Page2();

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid details....");
                        }
                    }
                    stmt.close();
                    con.close();


                } catch (Exception ie) {
                    ie.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        firstFrame();
    }

    public void firstFrame() {

        j1.add(l2);
        j1.add(l3);
        j1.add(t1);
        j1.add(password);
        j1.add(b1);
        j1.add(b2);

        j1.setLocation(450, 200);

        j1.setResizable(false);

        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j1.pack();
        j1.setSize(400, 300);
        j1.setVisible(true);


    }

    public static void main(String[] args) {

        Page1 obj1 = new Page1();


    }

}