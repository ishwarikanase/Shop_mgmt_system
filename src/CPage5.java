import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

class CPage5 {
    JFrame j5;
    JLabel l1=new JLabel("Edit Detalis....");

    JLabel l2=new JLabel("Product Name :");
    JLabel l3=new JLabel("Quantity :");

    JLabel l4=new JLabel("Purchase Price :");

    JLabel l5=new JLabel("Sale Price :");





    String value;


    JTextField t1=new JTextField();

    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();


    JButton b1=new JButton("Update");

    JButton b2=new JButton("Cancel");









    public CPage5(){





        j5=new JFrame("Edit");
        try {
            j5.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\src\\coffee.jpg")))));
        } catch (Exception ie) {
            ie.printStackTrace();
        }
        fifthFrame();


        l1.setBounds(100,30,300,50);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Times new roman",Font.BOLD,30));

        l2.setBounds(20,100,200,30);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Times new roman",Font.BOLD,16));


        t1.setBounds(220,100,200,30);

        l3.setBounds(20,150,200,30);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Times new roman",Font.BOLD,16));


        t2.setBounds(220,150,200,30);
        l4.setBounds(20,200,200,30);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Times new roman",Font.BOLD,16));


        t3.setBounds(220,200,200,30);
        l5.setBounds(20,250,200,30);
        l5.setForeground(Color.white);
        l1.setFont(new Font("Times new roman",Font.BOLD,30));



        t4.setBounds(220,250,200,30);




        b1.setBounds(100,300,100,30);
        b1.setBackground(Color.white);
        b1.setFont(new Font("Times new roman",Font.BOLD,16));

        b2.setBounds(220,300,100,30);
        b2.setBackground(Color.white);
        b2.setFont(new Font("Times new roman",Font.BOLD,16));



        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {



                    System.out.println(t1.getText());
                    System.out.println(value);
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");

                    PreparedStatement ps=con.prepareStatement("update cpvc set pname=?,quantity=?,purchase=?,sale=? where pcode=?");

                    ps.setString(1,t1.getText());


                    ps.setString(2,t2.getText());
                    ps.setString(3,t3.getText());
                    ps.setString(4,t4.getText());



                    ps.setString(5,value);


                    int i=ps.executeUpdate();
                    System.out.println("record updated");

                    con.close();
                }catch (Exception ie){
                    ie.printStackTrace();
                }

                j5.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j5.setVisible(false);
                CPage3 obj3=new CPage3();
            }


        });



        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j5.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j5.setVisible(false);
                CPage3 obj3=new CPage3();
            }
        });
    }





    public void fifthFrame(){

        j5.add(l1);

        j5.add(l2);

        j5.add(l3);

        j5.add(l4);
        j5.add(l5);



        j5.add(t1);
        j5.add(t2);
        j5.add(t3);
        j5.add(t4);


        j5.add(b1);
        j5.add(b2);


        j5.setResizable(false);

        j5.setLocation(450,150);
        j5.setLayout(null);

        j5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j5.pack();

        j5.setSize(450,400);

        j5.setVisible(true);

    }
}