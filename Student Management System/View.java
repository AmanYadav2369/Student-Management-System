import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class View extends JFrame
{
Container c;
JLabel labName;
JButton btnUpdate, btnRemove;
TextArea toData;
JButton btnBack;

View()
{
c=getContentPane();
c.setLayout(null);

labName=new JLabel("STUDENT DETAILS...");
labName.setBounds(220, 10, 700, 30);
labName.setFont(new Font("Arial", Font.BOLD, 40));
labName.setForeground(Color.RED);
c.add(labName);

btnUpdate=new JButton("Update Students.");
btnUpdate.setBounds(100,54,175,25);
btnUpdate.setFont(new Font("Arial", Font.PLAIN, 17));
c.add(btnUpdate);

btnRemove=new JButton("Remove Students.");
btnRemove.setBounds(290,54,175,25);
btnRemove.setFont(new Font("Arial", Font.PLAIN, 17));
c.add(btnRemove);

toData=new TextArea(8,5);
toData.setBounds(50, 80 , 780, 300);
toData.setFont(new Font("Arial", Font.PLAIN, 16));
c.add(toData);

btnBack=new JButton("<<< Back >>>");
btnBack.setBounds(280, 390, 250, 40);
btnBack.setFont(new Font("Arial", Font.PLAIN, 28));
c.add(btnBack);


ActionListener a = (ae) ->{ 
Home h=new Home();
dispose();
};
btnBack.addActionListener(a);

ActionListener a1 = (ae) -> { 
Update u=new Update();
dispose();
 };
btnUpdate.addActionListener(a1);

ActionListener a2 = (ae) -> { 
Remove r=new Remove();
dispose();
 };
btnRemove.addActionListener(a2);

String data="";
try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/school";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);
String sql="select*from student";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next())
data=data+"Rno="+rs.getInt(1)+"   "+"Name="+rs.getString(2)+"          "+"Age="+rs.getInt(3)+"   "+ "Mobile="+rs.getString(4)+"     "+"Address="+rs.getString(5)+ "\n" ;
toData.setText(data);
rs.close();
con.close();
}catch(SQLException e){
JOptionPane.showMessageDialog(c, "issue"+e);
}


setSize(900, 500);
setLocationRelativeTo(null);
setTitle("VIEW.");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

public static void main(String args[])
{
View v=new View();
}
}