import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Welcome extends JFrame 
{
Container c;

Welcome()
{
c=getContentPane();
c.setLayout(null);

JLabel heading=new JLabel("STUDENT MANAGEMENT SYSTEM");
heading.setBounds(60, 20, 1200, 50);
heading.setFont(new Font("Arial", Font.PLAIN, 60));
heading.setForeground(Color.RED);
c.add(heading);

ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(50, 100, 1050,500);
c.add(image);

JButton clickhere =new JButton("CLICK HERE TO CONTINUE");
clickhere.setBounds(400, 400, 300, 70);
clickhere.setFont(new Font("Arial", Font.PLAIN, 20));
clickhere.setBackground(Color.BLACK);
clickhere.setForeground(Color.WHITE);
image.add(clickhere);

ActionListener a = (ae) -> {  
dispose();
Login l=new Login();
};
clickhere.addActionListener(a);

setSize(1170, 650);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setTitle("My first App..");
}

public static void main(String args[])
{
Welcome w=new Welcome();

}
}