import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Add extends JFrame
{
Container c;
JLabel labname, labrno, labname1,labage, labmobile, labaddress ;
JTextField txtrno, txtname1, txtage, txtmobile, txtaddress;
JButton btnSubmit, btnBack;

Add()
{
c=getContentPane();
c.setLayout(null);

labname=new JLabel("STUDENT DETAILS...");
labname.setBounds(220, 10, 700, 30);
labname.setFont(new Font("Arial", Font.BOLD, 40));
labname.setForeground(Color.RED);
c.add(labname);

labrno=new JLabel("Enter Rno :");
labrno.setBounds(90, 80, 200, 30);
labrno.setFont(new Font("Arial", Font.BOLD, 25));
c.add(labrno);

txtrno=new JTextField(20);
txtrno.setBounds(230, 80, 200, 30);
txtrno.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtrno);

labname1=new JLabel("Enter Name :");
labname1.setBounds(440, 80, 200, 30);
labname1.setFont(new Font("Arial", Font.BOLD, 25));
c.add(labname1);

txtname1=new JTextField(20);
txtname1.setBounds(600, 80, 200, 30);
txtname1.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtname1);

labage=new JLabel("Enter Age :");
labage.setBounds(90, 150, 200, 30);
labage.setFont(new Font("Arial", Font.BOLD, 25));
c.add(labage);

txtage=new JTextField(20);
txtage.setBounds(230, 150, 200, 30);
txtage.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtage);

labmobile=new JLabel("Enter Mobile :");
labmobile.setBounds(440, 150, 200, 30);
labmobile.setFont(new Font("Arial", Font.BOLD, 25));
c.add(labmobile);

txtmobile=new JTextField(20);
txtmobile.setBounds(610, 150, 200, 30);
txtmobile.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtmobile);

labaddress=new JLabel("Enter Address :");
labaddress.setBounds(90, 220, 200 , 30);
labaddress.setFont(new Font("Arial", Font.BOLD, 25));
c.add(labaddress);

txtaddress=new JTextField(20);
txtaddress.setBounds(280, 220, 400, 30);
txtaddress.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtaddress);


btnSubmit=new JButton("Submit");
btnSubmit.setBounds(210, 350, 200, 30);
btnSubmit.setFont(new Font("Arial", Font.BOLD, 25));
c.add(btnSubmit);

btnBack=new JButton("<<< Back >>>");
btnBack.setBounds(470, 350, 200 ,30);
btnBack.setFont(new Font("Arial", Font.BOLD, 25));
c.add(btnBack);

ActionListener a1 = (ae) -> {  
Home h=new Home();
dispose();
};
btnBack.addActionListener(a1);


ActionListener a2 = (ae) -> { 
int Rno=Integer.parseInt(txtrno.getText());
String Name=txtname1.getText();
int Age=Integer.parseInt(txtage.getText());
String Mobile=txtmobile.getText();
String Address=txtaddress.getText();

try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/school";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);

String sql="insert into student values(?,?,?,?,?)";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1, Rno);
pst.setString(2, Name);
pst.setInt(3, Age);
pst.setString(4, Mobile);
pst.setString(5, Address);
pst.executeUpdate();
JOptionPane.showMessageDialog(c, "Student Record Inserted Successfully...");
con.close();

}catch(SQLException e){
JOptionPane.showMessageDialog(c, "issue"+e);
}

 };
btnSubmit.addActionListener(a2);

setSize(900, 500);
setLocationRelativeTo(null);
setTitle("ADD.");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


public static void main(String args[])
{
Add a=new Add();
}
}