import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Remove extends JFrame
{
Container c;
JLabel labhead, labrno, labname;
JTextField txtrno, txtname;
JButton btnSubmit, btnBack;

Remove(){
c=getContentPane();
c.setLayout(null);

labhead=new JLabel("STUDENT DETAILS...");
labhead.setBounds(90, 10, 700, 30);
labhead.setFont(new Font("Arial", Font.BOLD, 40));
labhead.setForeground(Color.RED);
c.add(labhead);

labrno=new JLabel("Enter Rno :");
labrno.setBounds(200, 100, 200, 30);
labrno.setFont(new Font("Arial", Font.BOLD, 25));
c.add(labrno);

txtrno=new JTextField(20);
txtrno.setBounds(180, 140, 200, 30);
txtrno.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtrno);

labname=new JLabel("Enter Name :");
labname.setBounds(200, 190, 200, 30);
labname.setFont(new Font("Arial", Font.BOLD, 25));
c.add(labname);

txtname=new JTextField(20);
txtname.setBounds(180, 230, 200, 30);
txtname.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtname);

btnSubmit=new JButton("Submit");
btnSubmit.setBounds(80, 350, 200, 30);
btnSubmit.setFont(new Font("Arial", Font.BOLD, 25));
c.add(btnSubmit);

btnBack=new JButton("<<< Back >>>");
btnBack.setBounds(300, 350, 200 ,30);
btnBack.setFont(new Font("Arial", Font.BOLD, 25));
c.add(btnBack);

ActionListener a1 = (ae) -> { 
Home h=new Home();
dispose();
 };
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> { 
int Rno=Integer.parseInt(txtrno.getText());
String Name=txtname.getText();

try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/school";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);

String sql="delete from student where Rno='"+Rno+"' and Name='"+Name+"' ";
Statement stmt=con.createStatement();
stmt.executeUpdate(sql);
JOptionPane.showMessageDialog(c,"Student Records Removed Successfully...");

con.close();
}catch(SQLException e){
System.out.println("issue"+e);
}

 };
btnSubmit.addActionListener(a2);

setSize(600, 500);
setLocationRelativeTo(null);
setTitle("remove..");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String args[])
{
Remove r=new Remove();
}
}