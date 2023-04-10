import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Registration extends JFrame
{
Container c;
JLabel labName, labName1,labName2, labName3, labName4, labName5, labName6, labName7,labName8, labName9,labName10;
JTextField txtName1, txtName2, txtName3, txtName4, txtName5, txtName6, txtName7,txtName8, txtName9;
JButton btnSubmit, btnBack;

Registration(){
c=getContentPane();
c.setLayout(null);

labName=new JLabel("Registration Form...");
labName.setBounds(220,10,500,40);
labName.setFont(new Font("Arial",Font.BOLD,35));
labName.setForeground(Color.RED);
c.add(labName);

labName1=new JLabel("Enter Name :");
labName1.setBounds(50, 80,200,30);
labName1.setFont(new Font("Arial",Font.BOLD,25));
labName1.setForeground(Color.BLUE);
c.add(labName1);

txtName1=new JTextField(40);
txtName1.setBounds(210,80,200,30);
txtName1.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtName1);

labName2=new JLabel("Enter Age :");
labName2.setBounds(420,80,200,30);
labName2.setFont(new Font("Arial", Font.BOLD, 25));
labName2.setForeground(Color.BLUE);
c.add(labName2);

txtName2=new JTextField(40);
txtName2.setBounds(560,80,200,30);
txtName2.setFont(new Font("Arial",Font.PLAIN,20));
c.add(txtName2);

labName3=new JLabel("Enter Father Name :");
labName3.setBounds(50,140,500, 30);
labName3.setFont(new Font("Arial",Font.BOLD, 25));
labName3.setForeground(Color.BLUE);
c.add(labName3);

txtName3=new JTextField(40);
txtName3.setBounds(290,140,300,30);
txtName3.setFont(new Font("Arial",Font.PLAIN,20));
c.add(txtName3);

labName4=new JLabel("Enter Mother Name :");
labName4.setBounds(50,200,500,30);
labName4.setFont(new Font("Arial",Font.BOLD,25));
labName4.setForeground(Color.BLUE);
c.add(labName4);

txtName4=new JTextField(40);
txtName4.setBounds(295,200,300,30);
txtName4.setFont(new Font("Arial",Font.PLAIN,20));
c.add(txtName4);

labName5=new JLabel("Enter Address :");
labName5.setBounds(50,255,400,30);
labName5.setFont(new Font("Arila", Font.BOLD,25));
labName5.setForeground(Color.BLUE);
c.add(labName5);

txtName5=new JTextField(40);
txtName5.setBounds(240,260,400,30);
txtName5.setFont(new Font("Arial",Font.PLAIN,20));
c.add(txtName5);

labName6=new JLabel("Enter Mobile :");
labName6.setBounds(50,315,200,30);
labName6.setFont(new Font("Arial", Font.BOLD,25));
labName6.setForeground(Color.BLUE);
c.add(labName6);

txtName6=new JTextField(12);
txtName6.setBounds(220,315,150,30);
txtName6.setFont(new Font("Arial", Font.PLAIN,20));
c.add(txtName6);

labName7=new JLabel("Enter Email :");
labName7.setBounds(380,315,200,30);
labName7.setFont(new Font("Arial",Font.BOLD, 25));
labName7.setForeground(Color.BLUE);
c.add(labName7);

txtName7=new JTextField(40);
txtName7.setBounds(535,315,240,30);
txtName7.setFont(new Font("Arial", Font.PLAIN,20));
c.add(txtName7);

labName8=new JLabel("Enter Username :");
labName8.setBounds(50,370,400,30);
labName8.setFont(new Font("Arial", Font.BOLD,25));
labName8.setForeground(Color.BLUE);
c.add(labName8);

txtName8=new JTextField(40);
txtName8.setBounds(260,370,140,30);
txtName8.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtName8);

labName9=new JLabel("Enter Password :");
labName9.setBounds(415,370,400,30);
labName9.setFont(new Font("Arial", Font.BOLD, 25));
labName9.setForeground(Color.BLUE);
c.add(labName9);

txtName9=new JTextField(40);
txtName9.setBounds(620,370,140,30);
txtName9.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtName9);

btnSubmit=new JButton("Submit..");
btnSubmit.setBounds(256,450,230,37);
btnSubmit.setFont(new Font("Arial",Font.BOLD, 28));
btnSubmit.setForeground(Color.RED);
c.add(btnSubmit);

btnBack=new JButton("<<click here to login>>");
btnBack.setBounds(220,500,300,28);
btnBack.setFont(new Font("Arial",Font.PLAIN,20));
btnBack.setForeground(Color.BLUE);
c.add(btnBack);

ActionListener a2 = (ae) -> {
dispose();
Login l=new Login();
};
btnBack.addActionListener(a2);

ActionListener a = (ae) -> { 
String Name=txtName1.getText();
int Age=Integer.parseInt(txtName2.getText());
String FatherName=txtName3.getText();
String MotherName=txtName4.getText();
String Address=txtName5.getText();
String Mobile=txtName6.getText();
String Email=txtName7.getText();
String Username=txtName8.getText();
String Password=txtName9.getText();

try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/school";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);

String sql="insert into registration values(?,?,?,?,?,?,?,?,?)";
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,Name);
pst.setInt(2,Age);
pst.setString(3, FatherName);
pst.setString(4, MotherName);
pst.setString(5, Address);
pst.setString(6, Mobile);
pst.setString(7, Email);
pst.setString(8, Username);
pst.setString(9, Password);
pst.executeUpdate();
JOptionPane.showMessageDialog(c, "Registration done Successfully...");
con.close();

dispose();
Login l=new Login();

}catch(SQLException e){
System.out.println("issue"+e);
}
 };
btnSubmit.addActionListener(a);

setSize(810, 600);
setLocationRelativeTo(null);
setTitle("registration form...");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String args[])
{
Registration r=new Registration();
}
}