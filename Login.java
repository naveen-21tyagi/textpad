// package textpad;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;;
// import textpad.textpad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;


public class Login implements ActionListener{
    // textpad file=new textpad();

    JFrame f=new JFrame();
    // f.setTitle("Login");

    JLabel id=new JLabel("User ID");
    JLabel pswd=new JLabel("Password");
    JTextField idT=new JTextField();
    JTextField pswdT=new JTextField();
    JButton sub=new JButton("Submit");
    
    Login(){
        idT.addActionListener(this);
        pswdT.addActionListener(this);
        sub.addActionListener(this);

        f.setLayout(new GridLayout(3,2));
        f.add(id);
        f.add(idT);

        f.add(pswd);
        f.add(pswdT);
        f.add(sub);
        f.setVisible(true);
        f.setBounds(200, 200, 250, 250);
        f.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                System.exit(0);    
            }    
        });
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==sub){
            String name=idT.getText();
            String pass=pswdT.getText();
            if(name.equals("User") && pass.equals("123456")){
                f.setVisible(false);
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