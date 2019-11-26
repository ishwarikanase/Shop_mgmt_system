import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Page2{
    JFrame j2;
    private JMenuBar mb;
    private JMenu m1,m2,m3,m4;
    private JMenuItem i1,i2,i3,i4,i5,f1,f2,b1,b2;
    Page2(){

        j2=new JFrame("Home");

        try {
            j2.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\src\\coffee.jpg")))));
        } catch (Exception ie) {
            ie.printStackTrace();
        }

        mb=new JMenuBar();
        m1=new JMenu("File");
        m2=new JMenu("Products");
        m4=new JMenu("Bill");
        m3=new JMenu("About Us");
        i1=new JMenuItem("Electricals");
        i2=new JMenuItem("PVC");
        i3=new JMenuItem("UPVC");
        i4=new JMenuItem("CPVC");
        i5=new JMenuItem("Others");


        b1=new JMenuItem("Create bill");
        b2=new JMenuItem("Search bill");

        f2=new JMenuItem("Logout");
        f1=new JMenuItem("Close");



        f2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=JOptionPane.showConfirmDialog(null,"Are you sure?");
                if(a==JOptionPane.YES_OPTION){
                    j2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    j2.setVisible(false);
                    System.out.println("ish");
                    Page1 obj1=new Page1();

                }
                else{
                    j2.setVisible(true);
                }

            }
        });
        f1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        secondFrame();
        m1.add(f2);
        m1.add(f1);
        m2.add(i1);
        m2.add(i2);
        m2.add(i3);
        m2.add(i4);
        m2.add(i5);

        m4.add(b1);
        m4.add(b2);
        mb.add(m1);
        mb.add(m2);
        mb.add(m4);
        mb.add(m3);
        j2.setJMenuBar(mb);



        i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                j2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j2.setVisible(false);
                EPage3 obj3=new EPage3();
            }
        });



        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j2.setVisible(false);
                PPage3 obj3=new PPage3();
            }
        });

        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j2.setVisible(false);
                UPage3 obj3=new UPage3();
            }
        });

        i4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j2.setVisible(false);
                CPage3 obj3=new CPage3();
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j2.setVisible(false);
                Page6 obj6=new Page6();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j2.setVisible(false);
                Page7 pbj7=new Page7();
            }
        });


    }

    public void secondFrame(){
        j2.pack();
        j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        j2.setSize(screenSize.width, screenSize.height);
        j2.setVisible(true);
    }

}