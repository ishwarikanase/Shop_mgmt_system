import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

class Page7{
    JFrame j7;


    static Object[][] data;
    static Object[] cols={"Sr.no","Customer name","Amount","Date"};
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
    JButton search,back;

    public Page7(){
        j7=new JFrame("Search bill");
        try {
            j7.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\Project\\src\\coffee.jpg")))));
        } catch (Exception ie) {
            ie.printStackTrace();
        }

        t1=new JTextField();

        t1.setBounds(50,75,200,30);

        search=new JButton("Search");
        search.setBounds(260,75,100,30);
        search.setBackground(Color.white);
        search.setFont(new Font("Times new roman",Font.BOLD,16));


        back=new JButton("Back");
        back.setBounds(50,20,100,30);
        back.setBackground(Color.white);
        back.setFont(new Font("Times new roman",Font.BOLD,16));


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j7.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                j7.setVisible(false);
                Page2 obj2=new Page2();

            }
        });



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bill");
            Object[] temp;

            int i=0;
            while (rs.next()) {

                i++;
                temp = new Object[]{i, rs.getString(2), rs.getInt(3),  rs.getString(4)};


                model.addRow(temp);




            }
            System.out.println("table1");

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
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBounds(50,20,700,400);
        table.setLayout(null);




        TableColumn c0=table.getColumnModel().getColumn(0);
        c0.setPreferredWidth(100);

        TableColumn c1=table.getColumnModel().getColumn(1);
        c1.setPreferredWidth(100);



        TableColumn c2=table.getColumnModel().getColumn(2);
        c2.setPreferredWidth(100);

        TableColumn c3=table.getColumnModel().getColumn(3);
        c3.setPreferredWidth(100);


        thirdFrame();

    }
    public void thirdFrame(){



        scroll=new JScrollPane(table);


        panel=new JPanel();

        panel.add(scroll);

        tabbed=new JTabbedPane();

        tabbed.add("Product",panel);
        tabbed.setBounds(50,130,600,500);


        j7.add(tabbed);



        j7.add(t1);
        j7.add(search);
        j7.add(back);

        j7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       j7.setSize(700,700);

       j7.setLocation(250,20);


        j7.setLayout(null);
        j7.setVisible(true);


    }
    void searchB(){

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = t1.getText();

                try {


                    Class.forName("com.mysql.cj.jdbc.Driver");


                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ishwari");
                    PreparedStatement ps = con.prepareStatement("select * from bill where cname like ?");
                    ps.setString(1,"%"+s+"%");
                    ResultSet rest = ps.executeQuery();


                    model.setRowCount(0);

                    int i=0;
                    while(rest.next()){

                        i++;
                        Object[] temp = new Object[]{i, rest.getString(2), rest.getString(3), rest.getString(4)};
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