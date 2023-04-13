package textpad;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import java.io.*;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
public class app implements ActionListener {
    JFrame f;
    JMenuBar mb;
    JMenu m1,m2,m3;

    JMenuItem mi11,mi12,mi13,mi21,mi22,mi23,mi31,mi32,mi33;
    JTextArea ta;
    JDialog d=new JDialog(f,"About",true);

    app(){
        d.setLayout(new FlowLayout());
        d.add(new JLabel("This is textpad."));
        d.add(new JLabel("Created by naveen_21tyagi"));
        d.add(new JLabel(":)"));
    d.setVisible(false);
    JButton ok=new JButton("OK");
    ok.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                d.setVisible(false);  
            }  
        });
    d.add(ok);
    d.setSize(200,150);
        f=new JFrame();

        mb=new JMenuBar();

        m1=new JMenu("File");
        m2=new JMenu("Edit");
        m3=new JMenu("Help");

        mi11=new JMenuItem("New");
        mi12=new JMenuItem("Open");
        mi13=new JMenuItem("Save");
        mi11.addActionListener(this);
        mi12.addActionListener(this);
        mi13.addActionListener(this);

        mi21=new JMenuItem("Cut");
        mi22=new JMenuItem("Copy");
        mi23=new JMenuItem("Paste");
        mi21.addActionListener(this);
        mi22.addActionListener(this);
        mi23.addActionListener(this);

        mi31=new JMenuItem("Documentation");
        mi32=new JMenuItem("About");
        // JMenuItem mi33=new JMenuItem("Paste");
        mi31.addActionListener(this);
        mi32.addActionListener(this);
        // mi33.addActionListener(this);

        ta=new JTextArea(25,50);
        // ta.setBounds(10,20,30,40);
        m1.add(mi11);
        m1.add(mi12);
        m1.add(mi13);

        m2.add(mi21);
        m2.add(mi22);
        m2.add(mi23);

        m3.add(mi31);
        m3.add(mi32);
        // m3.add(mi33);

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        f.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                System.exit(0);    
            }    
        });
        f.setJMenuBar(mb);
        f.add(new JScrollPane(ta));  
        f.setTitle("Textpad");
        // f.setSize(400,500);
        f.pack();
        f.setLayout(null);
        f.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mi11){
            // try{
            // BuffeReader file=new BufferedReader("untitled.txt");
            ta.setText("");
            // }
            // catch(FileNotFoundException ee){
                
            // }
        }
        if(e.getSource()==mi12){
            // try{
            // FileReader fr=new FileReader("new.txt");    
            // BufferedReader br=new BufferedReader(fr);    
    
            // int i;  
            // String text="";  
            // while((i=br.read())!=-1){  
            // text+=((char)i);  
            // }
            // ta.setText(text);  
            // br.close();    
            // fr.close();
            // }
            // catch(FileNotFoundException ee){

            // }
            // catch(IOException ee){

            // }
            if(e.getSource()==mi12){    
    JFileChooser fc=new JFileChooser();    
    int i=fc.showOpenDialog(null);    
    if(i==JFileChooser.APPROVE_OPTION){    
        File f=fc.getSelectedFile();    
        String filepath=f.getPath();    
        try{  
        BufferedReader br=new BufferedReader(new FileReader(filepath));    
        String s1="",s2="";                         
        while((s1=br.readLine())!=null){    
        s2+=s1+"\n";    
        }    
        ta.setText(s2);    
        br.close();    
        }catch (Exception ex) {ex.printStackTrace();  }                 
    }    
}   
        }
        if(e.getSource()==mi13){
            // try{
            // FileWriter file=new FileWriter("new.txt");
            // file.write(ta.getText());
            // file.close();
            // }
            // catch(IOException ee){
                
            // }
            JFileChooser fc=new JFileChooser();    
    int i=fc.showSaveDialog(null);    
    if(i==JFileChooser.APPROVE_OPTION){    
        File f=fc.getSelectedFile();    
        String filepath=f.getPath();    
        try{  
                FileWriter file=new FileWriter(filepath);
            file.write(ta.getText());
            file.close();
        }       
        catch (Exception ex) {ex.printStackTrace();  
        } 
    }             
        }

        if(e.getSource()==mi32){
            d.setVisible(true);

        }
    }
    public static void main(String args[]){
        new app();
    }
}