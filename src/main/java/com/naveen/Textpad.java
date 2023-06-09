package com.naveen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;

public class Textpad implements ActionListener {
    JFrame f=new JFrame();
    JMenuBar mb=new JMenuBar();

    JMenu mFile=new JMenu("File");
    JMenu mEdit=new JMenu("Edit");
    JMenu mFormat=new JMenu("Format");
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

    JMenuItem miFontColor=new JMenuItem("Font Color");
    JMenuItem miBackgroundColor=new JMenuItem("Background Color");

    // mi31=new JMenuItem("Documentation");
    JMenuItem miAbout=new JMenuItem("About");
    // JMenuItem mi33=new JMenuItem("Paste");

    String fnts[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String sizes[]={"10","16","21","41","51"};
    String themes[]={"Light","Dark"};
    JComboBox<String> fonts=new JComboBox<String>(fnts);
    JComboBox<String> fontSizes=new JComboBox<String>(sizes);
    JComboBox<String> theme=new JComboBox<String>(themes);

    JTextArea ta=new JTextArea();
    JScrollPane scrollPane=new JScrollPane(ta);
    JDialog d=new JDialog(f,"About",true);

    Crypt crypt;
    public Textpad() throws Exception{
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(new JLabel("This is textpad."));
        panel.add(new JLabel("Created by naveen_21tyagi"));
        panel.add(new JLabel(":)"));
        JButton ok=new JButton("OK");
        ok.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                d.setVisible(false);  
            }  
        });
        panel.add(ok);
        
        d.setLayout(new FlowLayout());
        d.add(panel);
        d.setVisible(false);
        d.pack();
        // d.setSize(200,150);
        fonts.addActionListener(this);
        fontSizes.addActionListener(this);
        theme.addActionListener(this);

        miNew.addActionListener(this);
        miOpen.addActionListener(this);
        miSave.addActionListener(this);
        miPrint.addActionListener(this);
        miExit.addActionListener(this);


        miCut.addActionListener(this);
        miCopy.addActionListener(this);
        miPaste.addActionListener(this);
        miSelectAll.addActionListener(this);

        miFontColor.addActionListener(this);
        miBackgroundColor.addActionListener(this);



        // mi31.addActionListener(this);
        miAbout.addActionListener(this);
        // mi33.addActionListener(this);

        // miNew.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        // miOpen.setHorizontalAlignment(SwingConstants.LEFT);
        // miSave.setHorizontalAlignment(SwingConstants.LEFT);
        // miPaste.setHorizontalAlignment(SwingConstants.LEFT);
        // miExit.setHorizontalAlignment(SwingConstants.LEFT);

        // miCut.setHorizontalAlignment(SwingConstants.LEFT);
        // miCopy.setHorizontalAlignment(SwingConstants.LEFT);
        // miPaste.setHorizontalAlignment(SwingConstants.LEFT);
        // miSelectAll.setHorizontalAlignment(SwingConstants.LEFT);

        // miFontColor.setHorizontalAlignment(SwingConstants.LEFT);
        // miBackgroundColor.setHorizontalAlignment(SwingConstants.LEFT);

        // miAbout.setHorizontalAlignment(SwingConstants.LEFT);



        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miSave);
        mFile.add(miPrint);
        mFile.add(miExit);

        mEdit.add(miCut);
        mEdit.add(miCopy);
        mEdit.add(miPaste);
        mEdit.add(miSelectAll);

        mFormat.add(miFontColor);
        mFormat.add(miBackgroundColor);

        // mHelp.add(mi31);
        mHelp.add(miAbout);
        // mHelp.add(mi33);


        fonts.setMaximumSize(new Dimension(200, 25));
        fontSizes.setMaximumSize(new Dimension(100, 25));
        theme.setMaximumSize(new Dimension(100, 25));
        mb.add(mFile);
        mb.add(mEdit);
        mb.add(mFormat);
        mb.add(mHelp);
        mb.add(fonts);
        mb.add(fontSizes);
        mb.add(theme);

        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setJMenuBar(mb);
        f.add(scrollPane);  
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        f.setTitle("Textpad");
        f.setSize(700,500);
        f.setVisible(true);
        ta.setMargin(new Insets(0,5 , 10, 10));
        // Border eb=new Border(10, 10, 10, 10);
        // ta.setBorder(eb);


        crypt=new Crypt();

        // f.setIconImage(ImageIO.read(new File("com/naveen/textpad.png")));
        f.setIconImage(ImageIO.read(getClass().getResourceAsStream("/com/naveen/textpad.png")));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==miNew){
            // if(ta.getText()!=null)
            try{
                new Textpad();
            }
            catch(Exception ee){
                ee.fillInStackTrace();
            }
            // ta.setText(null);
        }
        else if(e.getSource()==miOpen){    
            JFileChooser fc=new JFileChooser();    
            int action=fc.showOpenDialog(null);    
            if(action==JFileChooser.APPROVE_OPTION){    
                File f=fc.getSelectedFile();    
                String filepath=f.getPath();    
                try{  
                    // BufferedReader br=new BufferedReader(new FileReader(filepath));
                    FileInputStream file=new FileInputStream(filepath);
                    byte [] ans=file.readAllBytes();
                    // while()
                    // String s1="",s2="";                         
                    // while((s1=br.readLine())!=null){    
                    // s2+=s1+"\n";    
                    // } 
                    ta.setText(crypt.decrypt(ans));    
                    // br.close();    
                    file.close();
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
                    FileOutputStream file=new FileOutputStream(filepath);
                    file.write(crypt.encrypt(ta.getText()));
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
            // System.exit(0);
            f.dispose();
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
        else if(e.getSource()==miFontColor){
            Color selectedColor=null;
            Color color=JColorChooser.showDialog(f,"Select a color",selectedColor);
            if(color!=null){
                selectedColor=color;
            }
            ta.setForeground(selectedColor);
            ta.setCaretColor(selectedColor);
        }
        else if(e.getSource()==miBackgroundColor){
            Color selectedColor=null;
            Color color=JColorChooser.showDialog(f,"Select a color",selectedColor);
            if(color!=null){
                selectedColor=color;
            }
            ta.setBackground(selectedColor);
            // ta.setCaretColor(selectedColor);
        }
        else if(e.getSource()==miAbout){
            d.setVisible(true);

        }
        else if(e.getSource()==fonts || e.getSource()==fontSizes){
            String fnt=fonts.getSelectedItem().toString();
            int size=Integer.parseInt(fontSizes.getSelectedItem().toString());
            ta.setFont(new Font(fnt, Font.PLAIN, size));
        }
        else if(e.getSource()==theme){
            String thm=theme.getSelectedItem().toString();
            if(thm=="Light"){
                ta.setBackground(Color.WHITE);
            }
            else if(thm=="Dark"){
                ta.setBackground(Color.BLACK);
            }
        }
    }
    public static void main(String args[]) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 

        new Textpad();
    }
}
