package com.naveen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;

public class Login implements ActionListener{
    JFrame f=new JFrame();
    JLabel id=new JLabel("User ID");
    JLabel pswd=new JLabel("Password");
    JTextField idT=new JTextField();
    JTextField pswdT=new JTextField();
    JButton sub=new JButton("Submit");
    
    Login()throws Exception{
        idT.addActionListener(this);
        pswdT.addActionListener(this);
        sub.addActionListener(this);

        f.setLayout(new GridLayout(3,2));
        f.add(id);
        f.add(idT);
        f.setTitle("Login");
        f.add(pswd);
        f.add(pswdT);
        f.add(sub);
        f.setVisible(true);
        f.setBounds(200, 200, 250, 250);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // f.setIconImage(ImageIO.read(new File("/com/naveen/textpad.png")));
        f.setIconImage(ImageIO.read(getClass().getResourceAsStream("/com/naveen/textpad.png")));

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==sub){
            String name=idT.getText();
            String pass=pswdT.getText();
            if(name.equals("User") && pass.equals("123456")){
                f.dispose();;
                try{
                new Textpad();
                }
                catch(Exception ee){
                    ee.fillInStackTrace();
                }
            }
        }
    }
    public static void main(String args[]) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 

        new Login();
    }
}