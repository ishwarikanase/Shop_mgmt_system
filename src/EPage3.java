import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;








class EPage3 {

    static Object[][] data;
    static Object[] cols={"Sr.no","product code","product name","quantity","Purchase price","sale price"};
    static DefaultTableModel model=new DefaultTableModel(data,cols){
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };
    JTable table;
    JScrollPane scroll;
    JTabbedPane tabbed;
    JPanel panel;


    JTextField t1;
    JButton search;






    private JButton add,edit,delete,refresh;

    JFrame j3;

    private JMenuBar mb;
    private JMenu m1,m2,m3,m4;
    private JMenuItem i1,i2,i3,i4,i5,f1,f2,b1,b2;



    public EPage3(){

        j3=new JFrame("Electricals");

        try {
            j3.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\src\\coffee.jpg")))));
        } catch (Exception ie) {
            ie.printStackTrace();
        }


        mb=new JMenuBar();
        m1=new JMenu("File");
        m2=new JMenu("Product");
        m3=new JMenu("About Us");
        m4=new JMenu("Bill");
        f1=new JMenuItem("Close");
        f2=new JMenuItem("Logout");
        i1=new JMenuItem("Electricals");
        i2=new JMenuItem("PVC");
        i3=new JMenuItem("UPVC");
        i4=new JMenuItem("CPVC");
        i5=new JMenuItem("others");

        b1=new JMenuItem("Create bill");
        b2=new JMenuItem("Search bill");


        f2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=JOptionPane.showConfirmDialog(null,"Are you sure?");
                if(a==JOptionPane.YES_OPTION){
                    j3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    j3.setVisible(false);
                    System.out.println("ish");
                    Page1 obj1=new Page1();

                }
                else{

                    j3.setVisible(true);
                }

            }
        });

        f1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



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

        j3.setJMenuBar(mb);





        i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                j3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j3.setVisible(false);
                EPage3 obj3=new EPage3();
            }
        });




        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j3.setVisible(false);
                PPage3 obj3=new PPage3();
            }
        });





        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j3.setVisible(false);
                UPage3 obj3=new UPage3();
            }
        });






        i4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j3.setVisible(false);
                CPage3 obj3=new CPage3();
            }
        });


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("b1");
                j3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j3.setVisible(false);
                Page6 obj6=new Page6();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j3.setVisible(false);
                Page7 pbj7=new Page7();
            }
        });





        t1=new JTextField();

        t1.setBounds(50,50,200,30);

        search=new JButton("Search");
        search.setBounds(260,50,100,30);
        search.setBackground(Color.white);
        search.setFont(new Font("Times new roman",Font.BOLD,16));


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from electricals");
            Object[] temp;

            int i=0;
            while (rs.next()) {

                i++;
                temp = new Object[]{i, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};


                model.addRow(temp);




            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception is) {
            is.printStackTrace();
        }



        searchB();







            table=new JTable(model);


            table.setRowHeight(table.getRowHeight()+2);

            table.setFont(new Font("Seriff",Font.PLAIN,20));
            table.setAutoCreateRowSorter(true);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setBounds(50,20,700,400);
            table.setLayout(null);




            TableColumn c0=table.getColumnModel().getColumn(0);
            c0.setPreferredWidth(100);

            TableColumn c1=table.getColumnModel().getColumn(1);
            c1.setPreferredWidth(100);



            TableColumn c2=table.getColumnModel().getColumn(2);
            c2.setPreferredWidth(350);

            TableColumn c3=table.getColumnModel().getColumn(3);
            c3.setPreferredWidth(100);

            TableColumn c4=table.getColumnModel().getColumn(4);
            c4.setPreferredWidth(100);

            TableColumn c5=table.getColumnModel().getColumn(5);
            c5.setPreferredWidth(100);











        add=new JButton("New");
        add.setBounds(1000,200,150,50);
        add.setBackground(Color.white);
        add.setFont(new Font("Times new roman",Font.BOLD,16));


        edit=new JButton("Edit");
        edit.setBounds(1000,300,150,50);
        edit.setBackground(Color.white);
        edit.setEnabled(false);
        edit.setFont(new Font("Times new roman",Font.BOLD,16));


        delete=new JButton("Delete");
        delete.setBounds(1000,400,150,50);
        delete.setBackground(Color.white);
        delete.setEnabled(false);
        delete.setFont(new Font("Times new roman",Font.BOLD,16));


        refresh=new JButton("Refresh");
        refresh.setBounds(1000,500,150,50);
        refresh.setBackground(Color.white);
        refresh.setFont(new Font("Times new roman",Font.BOLD,16));





        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hii");
                j3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j3.setVisible(false);
                model.setRowCount(0);
                EPage4 obj4=new EPage4();



            }
        });









        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                int row = table.getSelectedRow();


                String value=model.getValueAt(row,1).toString();

                System.out.println(value);

                System.out.println("a");
                String name=model.getValueAt(row,2).toString();

                String qty=model.getValueAt(row,3).toString();
                String purchase=model.getValueAt(row,4).toString();
                String sale=model.getValueAt(row,5).toString();


                System.out.println("ji");

                EPage5 obj5=new EPage5();

                model.setRowCount(0);


                System.out.println("hello");


                j3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j3.setVisible(false);


                System.out.println("yup");
                obj5.t1.setText(name);
                obj5.t2.setText(qty);
                obj5.t3.setText(sale);
                obj5.t4.setText(purchase);


                obj5.value=value;




            }
        });




        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int a=JOptionPane.showConfirmDialog(null,"Are you sure?");
                if(a==JOptionPane.YES_OPTION){
                    int column = 1;
                    int row = table.getSelectedRow();
                    String value = table.getModel().getValueAt(row, column).toString();
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
                        PreparedStatement ps=con.prepareStatement("delete from electricals where pcode=?");
                        ps.setString(1,value);

                        ps.executeUpdate();
                        System.out.println("record updated");


                        ps.close();
                        con.close();


                    }catch(Exception ie) {
                        ie.printStackTrace();
                    }

                    model.removeRow(row);

                }
                else{

                    j3.setVisible(true);
                }






                j3.setVisible(false);
                j3.setVisible(true);



//                delete.setEnabled(false);
            }
        });


        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                model.setRowCount(0);
                EPage3 obj3=new EPage3();
            }
        });




        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {


                edit.setEnabled(true);
                delete.setEnabled(true);


            }
        });






        thirdFrame();




    }







    public void thirdFrame(){



        scroll=new JScrollPane(table);


        panel=new JPanel();

        panel.add(scroll);

        tabbed=new JTabbedPane();

        tabbed.add("Product",panel);
        tabbed.setBounds(50,120,600,500);


        j3.add(tabbed);

        j3.add(add);
        j3.add(edit);
        j3.add(delete);
        j3.add(refresh);

        j3.add(t1);
        j3.add(search);

        j3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        j3.setSize(screenSize.width, screenSize.height);



        j3.setLayout(null);
        j3.setVisible(true);


    }



    void searchB(){

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = t1.getText();

                    try {


                        Class.forName("com.mysql.cj.jdbc.Driver");


                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
                        PreparedStatement ps = con.prepareStatement("select pcode,pname,quantity,purchase,sale from electricals where pname like ?");
                        ps.setString(1,"%"+s+"%");
                        ResultSet rest = ps.executeQuery();


                        model.setRowCount(0);

                        int i=0;
                        while(rest.next()){

                            i++;
                            Object[] temp = new Object[]{i,rest.getString(1), rest.getString(2), rest.getString(3), rest.getString(4), rest.getString(5)};
                            model.addRow(temp);
                            System.out.println(model);

                        }


                        rest.close();
                        ps.close();
                        con.close();


                    } catch (Exception ia) {
                        ia.printStackTrace();
                    }


            }
        });


    }

}


