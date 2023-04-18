package textpad;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;

public class textpad implements ActionListener {
    JFrame f=new JFrame();

    JMenuBar mb=new JMenuBar();

    JMenu mFile=new JMenu("File");
    JMenu mEdit=new JMenu("Edit");
    JMenu mHelp=new JMenu("Help");

    JMenuItem miNew=new JMenuItem("New");
    JMenuItem miOpen=new JMenuItem("Open");
    JMenuItem miSave=new JMenuItem("Save");
    JMenuItem miPrint = new JMenuItem("Print");
    JMenuItem miExit = new JMenuItem("Exit");

    JMenuItem miCut=new JMenuItem("Cut");
    JMenuItem miCopy=new JMenuItem("Copy");
    JMenuItem miPaste=new JMenuItem("Paste");
    JMenuItem miSelectAll = new JMenuItem("Select All");

    // mi31=new JMenuItem("Documentation");
    JMenuItem miAbout=new JMenuItem("About");
    // JMenuItem mi33=new JMenuItem("Paste");

    // String fnts[]={"Arial","Calibri","Times New Roman","Comic Sans"};
    // JList fonts=new JList<>(fnts);
    // fonts.addActionListener(this);

    JTextArea ta=new JTextArea();
    JScrollPane scrollPane=new JScrollPane(ta);
    JDialog d=new JDialog(f,"About",true);

    textpad(){

        //-----------------
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

//-------------------
        miNew.addActionListener(this);
        miOpen.addActionListener(this);
        miSave.addActionListener(this);
        miPrint.addActionListener(this);
        miExit.addActionListener(this);


        miCut.addActionListener(this);
        miCopy.addActionListener(this);
        miPaste.addActionListener(this);
        miSelectAll.addActionListener(this);


        // mi31.addActionListener(this);
        miAbout.addActionListener(this);
        // mi33.addActionListener(this);

        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miSave);
        mFile.add(miPrint);
        mFile.add(miExit);

        mEdit.add(miCut);
        mEdit.add(miCopy);
        mEdit.add(miPaste);
        mEdit.add(miSelectAll);

        // mHelp.add(mi31);
        mHelp.add(miAbout);
        // mHelp.add(mi33);

        mb.add(mFile);
        mb.add(mEdit);
        mb.add(mHelp);
        // mb.add(fonts);
        f.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                System.exit(0);    
            }    
        });
        f.setJMenuBar(mb);
        f.add(scrollPane);  
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        f.setTitle("Textpad");
        f.setSize(700,500);
        // f.pack();
        // f.setLayout(null);
        f.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==miNew){
            ta.setText(null);
        }
        else if(e.getSource()==miOpen){    
            JFileChooser fc=new JFileChooser();    
            int action=fc.showOpenDialog(null);    
            if(action==JFileChooser.APPROVE_OPTION){    
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
                }
                catch (Exception ex) {
                    ex.printStackTrace();  
                }                 
            }    
        }   
        
        else if(e.getSource()==miSave){
            JFileChooser fc=new JFileChooser();    
            int action=fc.showSaveDialog(null);    
            if(action==JFileChooser.APPROVE_OPTION){    
                File f=fc.getSelectedFile();    
                String filepath=f.getPath();    
                try{  
                    FileWriter file=new FileWriter(filepath);
                    file.write(ta.getText());
                    file.close();
                }       
                catch (Exception ex) {
                    ex.printStackTrace();  
                } 
            }             
        }
        else if(e.getSource()==miPrint){
            try{
                ta.print();
            }
            catch(PrinterException ex){
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==miExit){
            System.exit(0);
        }
        else if(e.getSource()==miCut){
            ta.cut();
        }
        else if(e.getSource()==miCopy){
            ta.copy();
        }
        else if(e.getSource()==miPaste){
            ta.paste();
        }
        else if(e.getSource()==miSelectAll){
            ta.selectAll();
        }
        else if(e.getSource()==miAbout){
            d.setVisible(true);

        }
    }
    public static void main(String args[]) throws Exception{
        // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 

        new textpad();
    }
}