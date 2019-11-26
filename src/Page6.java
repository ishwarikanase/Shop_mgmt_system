import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.text.*;
import java.util.Calendar;

import java.util.Date;
import java.util.Locale;

class Page6{
    JFrame j6=new JFrame("New Bill");
    int j=0,m,row;

    static int sum=0;


    JLabel billno,cname,mrp,qty,discount,date,total,cat,l;
    JTextField t1,t2,t4,t5,t6,t7,t8;
    JButton newB,back,add,remove,print,refresh;



    String value,name;



    JComboBox<String> category=new JComboBox<>(new String[]{"Electricals","PVC","UPVC","CPVC","Others"});
    JComboBox<String> pname=new JComboBox<>();
    int a;


    Object[] cols={"Sr.no","Product name","Quantity","MRP","Price"};
    Object[][] data;

    JTable table;
    JTabbedPane tabbed;
    JScrollPane scroll=new JScrollPane();
    JPanel panel;
    DefaultTableModel model=new DefaultTableModel(data,cols){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };





    Page6(){
        try {
            j6.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\src\\coffee.jpg")))));
        } catch (Exception ie) {
            ie.printStackTrace();
        }




        billno=new JLabel("Bill no. :");
        billno.setBounds(50,80,100,30);
        billno.setFont(new Font("Times new roman",Font.BOLD,16));
        billno.setForeground(Color.white);

        cname=new JLabel("Customer name :");
        cname.setBounds(50,140,100,30);
        cname.setFont(new Font("Times new roman",Font.BOLD,16));
        cname.setForeground(Color.white);



        cat=new JLabel("Category :");
        cat.setBounds(50,200,100,30);
        cat.setFont(new Font("Times new roman",Font.BOLD,16));
        cat.setForeground(Color.white);


        l=new JLabel("Product name :");
        l.setBounds(50,260,100,30);
        l.setFont(new Font("Times new roman",Font.BOLD,16));
        l.setForeground(Color.white);

        mrp=new JLabel("MRP :");
        mrp.setBounds(50,320,100,30);
        mrp.setFont(new Font("Times new roman",Font.BOLD,16));
        mrp.setForeground(Color.white);


        qty=new JLabel("Quantity :");
        qty.setBounds(50,380,100,30);
        qty.setFont(new Font("Times new roman",Font.BOLD,16));
        qty.setForeground(Color.white);


        discount=new JLabel("Discount :");
        discount.setBounds(50,440,100,30);
        discount.setFont(new Font("Times new roman",Font.BOLD,16));
        discount.setForeground(Color.white);


        date=new JLabel("Date :");
        date.setBounds(500,20,100,30);
        date.setFont(new Font("Times new roman",Font.BOLD,16));
        date.setForeground(Color.white);


        total=new JLabel("Total :");
        total.setBounds(500,500,100,30);
        total.setFont(new Font("Times new roman",Font.BOLD,16));
        total.setForeground(Color.white);




        t1=new JTextField();
        t1.setBounds(160,80,200,30);
        t2=new JTextField();
        t2.setBounds(160,140,200,30);
        category.setBounds(160,200,100,30);

        pname.setBounds(160,260,100,30);

        t4=new JTextField();
        t4.setBounds(160,320,200,30);
        t5=new JTextField();
        t5.setBounds(160,380,200,30);
        t6=new JTextField();
        t6.setBounds(160,440,200,30);
        t7=new JTextField();
        t7.setBounds(610,20,200,30);
        t8=new JTextField();
        t8.setBounds(610,500,200,30);

        j6.add(t7);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = df.format(new Date());
        System.out.println(date1);
        t7.setText(date1);




        back=new JButton("Back");
        back.setBounds(50,20,100,30);
        back.setFont(new Font("Times new roman",Font.BOLD,16));
        back.setBackground(Color.white);


        newB=new JButton("New");
        newB.setBounds(175,20,100,30);
        newB.setFont(new Font("Times new roman",Font.BOLD,16));
        newB.setBackground(Color.white);



        add=new JButton("Add");
        add.setBounds(100,490,100,30);
        add.setFont(new Font("Times new roman",Font.BOLD,16));
        add.setBackground(Color.white);

        remove=new JButton("Remove");
        remove.setBounds(210,490,100,30);
        remove.setFont(new Font("Times new roman",Font.BOLD,16));
        remove.setBackground(Color.white);



        print=new JButton("Print");
        print.setBounds(820,500,100,30);
        print.setFont(new Font("Times new roman",Font.BOLD,16));
        print.setBackground(Color.white);




        refresh=new JButton("Refresh");
        refresh.setBounds(980,500,100,30);
        refresh.setBackground(Color.white);
        refresh.setFont(new Font("Times new roman",Font.BOLD,16));

        newB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j6.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j6.setVisible(false);
                Page6 obj6=new Page6();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j6.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j6.setVisible(false);
                Page2 obj2=new Page2();
            }
        });




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
            PreparedStatement ps = con.prepareStatement("select * from bill");
            System.out.println("ish");

            int n=0;

            ResultSet rest = ps.executeQuery();
            while (rest.next()){

                n=Integer.valueOf(rest.getString(1));
                n++;

                t1.setText(String.valueOf(n));


            }
        }catch (Exception ie){
            ie.printStackTrace();
        }


        System.out.println("hiiii");

        System.out.println("beb");
        category.setSelectedIndex(-1);




        category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


        try{




            value=(String)category.getSelectedItem();

            System.out.println(value);
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
            PreparedStatement ps = con.prepareStatement("select pname from "+value+"");
            System.out.println("ish");

            ResultSet rest = ps.executeQuery();
            pname.removeAllItems();

            while (rest.next()){
                System.out.println(rest.getString(1));
                pname.addItem(rest.getString(1));
            }

            pname.setSelectedIndex(-1);

        }catch (Exception ie){
            ie.printStackTrace();
        }
            }
        });





        pname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {


                    System.out.println(name);
                    Class.forName("com.mysql.cj.jdbc.Driver");


                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
                    PreparedStatement ps = con.prepareStatement("select sale,quantity from "+value+" where pname=?");
                    name = (String) pname.getSelectedItem();


                    ps.setString(1,name);
                    ResultSet rs=ps.executeQuery();
                    while (rs.next()){

                        int sale=rs.getInt(1);
                        t4.setText(String.valueOf(sale));
                        int qty=rs.getInt(2);
                        t5.setText(String.valueOf(qty));


                    }

                }catch (Exception ie){
                    ie.printStackTrace();
                }
            }
        });

        System.out.println("hiii");




        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
                    PreparedStatement ps1=con.prepareStatement("select quantity from "+value+" where pname=?");
                    ps1.setString(1,name);
                    ResultSet rs=ps1.executeQuery();
                    while (rs.next()){
                        a=rs.getInt(1);
                    }
                    System.out.println(a);
                }catch (Exception ie){
                    ie.printStackTrace();
                }

                try {
                    System.out.println(a);

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
                    PreparedStatement ps = con.prepareStatement("update " + value + " set quantity=?  where pname=?");
                    name = (String) pname.getSelectedItem();
                    ps.setString(2, name);


                    ps.setInt(1,a-Integer.valueOf(t5.getText()));

                    int i=ps.executeUpdate();
                    System.out.println("i");
                }catch (Exception ie){
                    ie.printStackTrace();
                }

                j++;
                 int price=Integer.valueOf(t4.getText())*Integer.valueOf(t5.getText());
                Object[] temp=new Object[]{j,pname.getSelectedItem(),t5.getText(),t4.getText(),price};
                System.out.println("d");

                model.addRow(temp);

                System.out.println("hello");
                m=model.getRowCount();
                System.out.println(m);
                row = table.getSelectedRow();


                System.out.println("price"+price);

                for(int i=0;i<model.getRowCount();i++){
                    sum=sum+price;

                    break;
                }
                System.out.println("sum"+sum);

                t8.setText(String.valueOf(sum));

            }
        });




        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(model);
                System.out.println(row);
                model.removeRow(row);




            }
        });





        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
                    PreparedStatement ps=con.prepareStatement("insert into bill values(?,?,?,?)");
                    ps.setInt(1,Integer.valueOf(t1.getText()));
                    ps.setString(2,t2.getText());
                    ps.setInt(3,Integer.valueOf(t8.getText()));
                    System.out.println("done");
                    ps.setString(4, t7.getText());



                    int i=ps.executeUpdate();
                    System.out.println("success");

                }catch (Exception ie){
                    ie.printStackTrace();
                }
            }
        });





        System.out.println("hello");
        table=new JTable(model);


        table.setRowHeight(table.getRowHeight()+2);

        table.setFont(new Font("Seriff",Font.PLAIN,20));
        table.setAutoCreateRowSorter(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBounds(50,20,500,300);


        TableColumn c0=table.getColumnModel().getColumn(0);
        c0.setPreferredWidth(100);

        TableColumn c1=table.getColumnModel().getColumn(1);
        c1.setPreferredWidth(100);



        TableColumn c2=table.getColumnModel().getColumn(2);
        c2.setPreferredWidth(100);

        TableColumn c3=table.getColumnModel().getColumn(3);
        c3.setPreferredWidth(100);

        TableColumn c4=table.getColumnModel().getColumn(4);
        c4.setPreferredWidth(100);
        sixthFrame();


        System.out.println("hello");


    }
    void sixthFrame(){
        scroll=new JScrollPane(table);


        panel=new JPanel();

        panel.add(scroll);

        tabbed=new JTabbedPane();

        tabbed.add("Bill",panel);
        tabbed.setBounds(500,75,600,400);


        System.out.println("hiii");
        j6.add(tabbed);

        j6.add(billno);
        j6.add(cname);
        j6.add(l);
        j6.add(cat);
        j6.add(qty);
        j6.add(mrp);
        j6.add(discount);
        j6.add(date);
        j6.add(total);

        j6.add(category);


        System.out.println("labels");
        j6.add(t1);
        j6.add(t2);
        j6.add(pname);
        j6.add(t4);
        j6.add(t5);
        j6.add(t6);
        j6.add(t8);

        System.out.println("text");
        j6.add(back);
        j6.add(add);
        j6.add(remove);
        j6.add(print);
        j6.add(newB);
        j6.add(refresh);



        j6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        j6.setSize(1100,700);



        j6.setLayout(null);
        j6.setVisible(true);

    }
}