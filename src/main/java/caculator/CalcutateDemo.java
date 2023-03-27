/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package caculator;

/**
 *
 * @author Văn Thén
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
 
public class CalcutateDemo extends JFrame implements ActionListener{
        /*Dùng để biểu diễn 4 nút của 4 phép toán công trừ nhân chia */
       private JButton btn1, btn2, btn3, btn4;
       /*Dùng để chứa 2 số và 1 kết quả*/
       private JTextField tf1, tf2, tf3;
       /*Biến result dùng để lưu trữ kết quả tính toán*/
       private double result;
       /*Dùng để nhận tầng ContentPane của JFrame*/
       private Container container;
       /*Dùng Panel để nhóm các thành phần trên giao diện*/
       private JPanel panel1, panel2;
 
       /*Hàm khởi tạo với một tham số là String s*/
       public CalcutateDemo(String s) { 
            super(s);
            /*Lấy lớp ContentPane để đặt các đối tượng hiển thị*/
            container = this.getContentPane(); 
      
            /*Tạo các thành phần trên giao diện*/
            JLabel num1 = new JLabel("Số thứ nhất: ");
            tf1 = new JTextField();
            JLabel num2 = new JLabel("Số thứ hai: ");
            tf2 = new JTextField();
            JLabel resultl = new JLabel("Kết quả: ");
            tf3 = new JTextField();
           
            tf3.setEditable(false);
 
            /*Panel1 chứa 3 Textfield*/
            panel1 = new JPanel(); 
            /*thiết lập Layout gồm 3 hàng 2 cột*/
            panel1.setLayout(new GridLayout(3,2));
            /*Đặt các thành phần vào panel 1*/
            panel1.add(num1); 
            panel1.add(tf1); 
            panel1.add(num2); 
            panel1.add(tf2);
            panel1.add(resultl);
            panel1.add(tf3);
            /*Tạo 4 nút biểu diễn 4 phép toán*/
            btn1 = new JButton("+");
            btn2= new JButton("-");
            btn3 = new JButton("*");
            btn4 = new JButton(":");
            /*Panel2 chứa 4 nút*/
            panel2 = new JPanel();
            panel2.add(btn1);
            panel2.add(btn2);
            panel2.add(btn3);
            panel2.add(btn4);
 
            /*Đặt 2 panel vào ContentPane*/
            container.add(panel1); 
            container.add(panel2,"South"); 
 
            btn1.addActionListener(this);
            btn2.addActionListener(this); 
            btn3.addActionListener(this); 
            btn4.addActionListener(this);
           
            /*Thiết lập kích thước hiển thị*/
            this.setSize(350, 200);
            this.setVisible(true);
       }
 
       /*Định nghĩa hàm cộng*/
       public void Add() 
       { 
            result = Double.parseDouble(tf1.getText()) + Double.parseDouble(tf2.getText()); 
            tf3.setText(String.valueOf(result)); 
       }
       /*Định nghĩa hàm trừ*/
       public void Minus() 
       { 
            result = Double.parseDouble(tf1.getText()) - Double.parseDouble(tf2.getText());
            tf3.setText(String.valueOf(result));
       }
       /*Định nghĩa hàm nhân*/
       public void Multi() 
       {
            result = Double.parseDouble(tf1.getText()) * Double.parseDouble(tf2.getText());
            tf3.setText(String.valueOf(result)); 
       }
       /*Định nghĩa hàm chia*/
       public void Div()
       {
           result = Double.parseDouble(tf1.getText()) / Double.parseDouble(tf2.getText());
           tf3.setText(String.valueOf(result));
       } 
      
       /*Bắt đầu tính toán khi người dùng ấn các nút phép toán*/
       public void actionPerformed(ActionEvent e) 
       { 
            if (e.getActionCommand()=="+") {
                //Xử lý trường hợp chưa nhập số nhưng đã bấm tính toán
                if(tf1.getText().equals("") || tf2.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ");
                }else {
                    Add();
                }
            }
               
            if (e.getActionCommand()=="-") {
                if(tf1.getText().equals("")|| tf2.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ");
                }else {
                    Minus();
                }
            }
            if (e.getActionCommand()=="*"){
                if(tf1.getText().equals("")|| tf2.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ");
                }else {
                    Multi();
                }
            }               
            if (e.getActionCommand()==":") {
                if(tf1.getText().equals("")|| tf2.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ");
                }else {
                    Div();
                }
            }               
       }
       
    public static void main(String[] args) {
        CalcutateDemo cal = new CalcutateDemo("SimpleCalculator");
       cal.setLocationRelativeTo(null);
    }  
}
