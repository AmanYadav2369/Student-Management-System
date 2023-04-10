import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Home extends JFrame
{
Container c;
JLabel labName;
JButton btnAdd, btnView,btnUpdate, btnDelete, btnBack;

Home()
{
c=getContentPane();
c.setLayout(null);

labName=new JLabel("STUDENT MANAGEMENT SYSTEM...");
labName.setBounds(90, 10, 700, 30);
labName.setFont(new Font("Arial", Font.BOLD, 40));
labName.setForeground(Color.RED);
labName.setBackground(Color.GREEN);
c.add(labName);

ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(50, 90, 780,300);
c.add(image);

btnAdd=new JButton("Add Students..");
btnAdd.setBounds(115, 60, 260, 40);
btnAdd.setFont(new Font("Arial", Font.BOLD, 26));
image.add(btnAdd);

btnView=new JButton("View Students..");
btnView.setBounds(400, 60, 260, 40);
btnView.setFont(new Font("Arial", Font.BOLD, 26));
image.add(btnView);

btnUpdate=new JButton("Update Students..");
btnUpdate.setBounds(245, 130, 300, 40);
btnUpdate.setFont(new Font("Arial", Font.BOLD, 26));
image.add(btnUpdate);

btnDelete=new JButton("Remove Students..");
btnDelete.setBounds(245, 195, 300, 40);
btnDelete.setFont(new Font("Arial", Font.BOLD, 26));
image.add(btnDelete);

btnBack=new JButton("<<< Back >>>");
btnBack.setBounds(295, 400, 300, 40);
btnBack.setFont(new Font("Arial", Font.PLAIN, 26));
c.add(btnBack);

ActionListener a1 = (ae) -> {
Add a=new Add();
dispose();
 };
btnAdd.addActionListener(a1);


ActionListener a2 = (ae) -> {  
View v=new View();
dispose();
 };
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> { 
View v=new View();
dispose();
 };
btnUpdate.addActionListener(a3);

ActionListener a4 = (ae) -> {  
Welcome w=new Welcome();
dispose();
};
btnBack.addActionListener(a4);

ActionListener a5 = (ae) -> { 
View v=new View();
dispose();
 };
btnDelete.addActionListener(a5);


setSize(900, 500);
setLocationRelativeTo(null);
setTitle("HOME.");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public static void main(String args[])
{
Home h=new Home();
}
}