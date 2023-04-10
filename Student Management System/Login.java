import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Login extends JFrame
{
Container c;
JLabel labName, labName1, labName2, labName3;
JTextField txtName1, txtName2;
JButton btnLogin, btnregister;

Login(){
c=getContentPane();
c.setLayout(null);

labName=new JLabel("Login Form...");
labName.setBounds(140, 10, 400, 40);
labName.setFont(new Font("Arial", Font.BOLD, 35));
labName.setForeground(Color.RED);
c.add(labName);

labName1=new JLabel("Username :");
labName1.setBounds(70,100, 200, 30);
labName1.setFont(new Font("Arial", Font.BOLD, 28));
labName1.setForeground(Color.RED);
c.add(labName1);

txtName1=new JTextField(40);
txtName1.setBounds(230, 100, 200, 30);
txtName1.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtName1);

labName2=new JLabel("Password :");
labName2.setBounds(70,180, 200,30);
labName2.setFont(new Font("Arial", Font.BOLD, 28));
labName2.setForeground(Color.RED);
c.add(labName2);

txtName2=new JTextField(40);
txtName2.setBounds(230,180,200,30);
txtName2.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtName2);

btnLogin=new JButton("Login..");
btnLogin.setBounds(140, 250, 200, 38);
btnLogin.setFont(new Font("Arial", Font.BOLD, 28));
btnLogin.setForeground(Color.RED);
c.add(btnLogin);

btnregister=new JButton("<<click here to register>>");
btnregister.setBounds(80, 300, 330, 30);
btnregister.setFont(new Font("Arial",Font.PLAIN, 20));
btnregister.setForeground(Color.BLUE);
c.add(btnregister);

ActionListener a = (ae) -> { 

try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/school";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);

String Username=txtName1.getText();
String Password=txtName2.getText();
String sql="select*from registration where Username='"+Username+"' and Password='"+Password+"' ";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);
if(rs.next()){
dispose();
Home h=new Home();
}else{
JOptionPane.showMessageDialog(c,"Invalid username or password...");
}

}catch(SQLException e){
System.out.println("issue"+e);
}

 };
btnLogin.addActionListener(a);

ActionListener a1 = (ae) -> { 
dispose();
Registration r=new Registration();
 };
btnregister.addActionListener(a1);


setSize(500,400);
setLocationRelativeTo(null);
setTitle("login page...");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String args[])
{
Login l=new Login();

}
}