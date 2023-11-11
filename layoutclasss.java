
package com.mycompany.javapasswordhenerat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Generatpassword extends JFrame {
    
    private final passwordGenerator PasswordGenerator;
    
    public Generatpassword(){
        super("Password Generator");
        
        setSize(540,570);
        
        setResizable(false);
        
        setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        
        PasswordGenerator = new passwordGenerator(); 
        
        addGuiComponents();
    }
    
    private void addGuiComponents(){
        JLabel titlelabel=new JLabel("Password Generator");
        
        titlelabel.setFont(new Font("Dialog",Font.BOLD,32));
        
        titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        titlelabel.setBounds(0, 10,540,39);
        
        add(titlelabel);
        
        JTextArea passwordoutput=new JTextArea();
        
        passwordoutput.setEditable(false);
        
        passwordoutput.setFont(new Font("Dialog",Font.BOLD,32));
        
        
        JScrollPane passwordoutputpane =new JScrollPane(passwordoutput);
        passwordoutputpane.setBounds(25,97,479,70);
        
        passwordoutputpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordoutputpane);
        
        JLabel passwordlengthlabel=new JLabel("Password Length:");
        passwordlengthlabel.setFont(new Font("Dialog",Font.BOLD,29));
        passwordlengthlabel.setBounds(25,215,272,39);
        add(passwordlengthlabel);
        
        JTextArea passwordlengthinputarea=new JTextArea();
        passwordlengthinputarea.setFont(new Font("Dialog",Font.PLAIN,32));
        passwordlengthinputarea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordlengthinputarea.setBounds(310,215,192,39);
        add(passwordlengthinputarea);
        
        
        JToggleButton uppercasetoggle=new JToggleButton("Uppercase");
        uppercasetoggle.setFont(new Font("Dialog",Font.PLAIN,26));
        uppercasetoggle.setBounds(25,302,225,56);
        add(uppercasetoggle);
        
        JToggleButton lowercasetoggle=new JToggleButton("Lowercase");
        lowercasetoggle.setFont(new Font("Dialog",Font.PLAIN,26));
        lowercasetoggle.setBounds(282,302,225,56);
        add(lowercasetoggle);
        
        JToggleButton numbertoggle=new JToggleButton("Numbers");
        numbertoggle.setFont(new Font("Dialog",Font.PLAIN,26));
        numbertoggle.setBounds(25,373,225,56);
        add(numbertoggle);
        
        JToggleButton symboltoggle=new JToggleButton("Symbols");
        symboltoggle.setFont(new Font("Dialog",Font.PLAIN,26));
        symboltoggle.setBounds(282,373,225,56);
        add(symboltoggle);
        
        JButton generatebutton=new JButton("Generate");
        generatebutton.setFont(new Font("Dialog",Font.PLAIN,41));
        generatebutton.setBounds(155,477,222,41);
        generatebutton.addActionListener((ActionEvent e) -> {
            if(passwordlengthinputarea.getText().length()<=0) return;
            boolean anyToggleSelected= lowercasetoggle.isSelected() ||
                    
                    uppercasetoggle.isSelected()||
                    numbertoggle.isSelected()||
                    symboltoggle.isSelected();
            
            
            int passwordlength = Integer.parseInt(passwordlengthinputarea.getText());
            if(anyToggleSelected)
            {
                String generatPassword = PasswordGenerator.generatpassword(passwordlength,uppercasetoggle.isSelected(),lowercasetoggle.isSelected(),numbertoggle.isSelected(),symboltoggle.isSelected());
                
                passwordoutput.setText(generatPassword);      
            }
        });
        
        add(generatebutton);
          
    }
    
}
