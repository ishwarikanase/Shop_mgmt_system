import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CPage4 {

    private JLabel add=new JLabel("Add Product Details.......");
    private JLabel l1=new JLabel("Product Code:");
    private JLabel l2=new JLabel("Product name:");
    private JLabel l3=new JLabel("Quantity:");
    private JLabel l4=new JLabel("Purchase price:");
    private JLabel l5=new JLabel("Sale price:");

    private JTextField t4=new JTextField();
    private JTextField t3=new JTextField();
    private JTextField t5=new JTextField();


    private JTextField t2=new JTextField();
    private JTextField t1=new JTextField();
    private JButton b1=new JButton("Submit");
    private JButton b2=new JButton("Cancel");
    private JPanel p4=new JPanel();


    JFrame j4;

    public CPage4() {
        j4 = new JFrame("Add Product");

        try {
            j4.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\src\\coffee.jpg")))));
        } catch (Exception ie) {
            ie.printStackTrace();
        }

        add.setBounds(100, 20, 250, 50);
        add.setForeground(Color.white);
        add.setFont(new Font("Times new roman",Font.BOLD,24));


        l1.setBounds(50, 100, 200, 30);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Times new roman",Font.BOLD,16));
        t1.setBounds(260, 100, 200, 30);

        l2.setBounds(50, 150, 200, 30);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Times new roman",Font.BOLD,16));
        t2.setBounds(260, 150, 200, 30);

        l3.setBounds(50, 200, 200, 30);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Times new roman",Font.BOLD,16));
        t3.setBounds(260, 200, 200, 30);

        l4.setBounds(50, 250, 200, 30);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Times new roman",Font.BOLD,16));
        t4.setBounds(260, 250, 200, 30);

        l5.setBounds(50, 300, 200, 30);
        l5.setForeground(Color.white);
        l5.setFont(new Font("Times new roman",Font.BOLD,16));
        t5.setBounds(260, 300, 200, 30);



        b1.setBounds(150, 375, 100, 30);
        b1.setBackground(Color.white);
        b1.setFont(new Font("Times new roman",Font.BOLD,16));
        b2.setBounds(260, 375, 100, 30);
        b2.setBackground(Color.white);
        b2.setFont(new Font("Times new roman",Font.BOLD,16));

        forthFrame();
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
                    PreparedStatement stmt = con.prepareStatement("insert into cpvc values(?,?,?,?,?)");

                    stmt.setString(1, t1.getText());

                    stmt.setString(2, t2.getText());
                    stmt.setString(3, t3.getText());
                    stmt.setString(4, t4.getText());
                    stmt.setString(5, t5.getText());



                    int i = stmt.executeUpdate();
                    System.out.println(i + "  record upfated successfully.......");


                    j4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    j4.setVisible(false);
                    CPage3 obj3 = new CPage3();
                    con.close();
                } catch (Exception ie) {
                    ie.printStackTrace();
                }


            }


        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j4.setVisible(false);
                CPage3 obj3=new CPage3();

            }
        });
    }


    public void forthFrame() {
        j4.add(add);
        j4.add(l1);
        j4.add(l2);
        j4.add(l3);
        j4.add(l4);
        j4.add(l5);

        j4.add(t1);
        j4.add(t2);
        j4.add(t3);
        j4.add(t4);
        j4.add(t5);

        j4.add(b1);
        j4.add(b2);

        j4.setLayout(null);

        j4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        j4.pack();

        j4.setSize(500, 500);
        j4.setResizable(false);
        j4.setLocation(450, 100);

        j4.setVisible(true);


    }


}
