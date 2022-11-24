package Konto_02;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class KontoWinTest extends JFrame implements ActionListener {
    private JButton btnKonto1;
    private JButton btnKonto2;
    private JButton btnKonto3;
    
    private Konten Konto_1;
    private Konten Konto_2;
    private Konten Konto_3;
    
    KontoWinTest() {
        setSize(500,600);       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);         
        setLayout(new FlowLayout());
           
        btnKonto1=new JButton("Konto 1");
        btnKonto1.addActionListener(this);
        add(btnKonto1);

        btnKonto2=new JButton("Konto 2");
        btnKonto2.addActionListener(this);
        add(btnKonto2);
        
        btnKonto3=new JButton("Konto 3");
        btnKonto3.addActionListener(this);
        add(btnKonto3);
 
        pack(); 
 
    }
    public void actionPerformed(ActionEvent e){ 
             
    	if(e.getSource()==btnKonto1){
    		createKonto(1);
    	}
        if(e.getSource()==btnKonto2){
        	createKonto(2);
        }
        if(e.getSource()==btnKonto3){
        	createKonto(3);
        }
             
    }
    
    private void createKonto( int Nummer) {
    	try {
    		if(Nummer == 1 ) {
    			Konto_1 = new Konten ( );
    			Konto_1.setKontoSaldo(150.00);
    			System.out.println(Konto_1.getKontoInfo());
    		}
    		else if(Nummer == 2 ) {
    			Konto_2 = new Konten ( );
    			Konto_2.setKontoSaldo(350.00);
    			System.out.println(Konto_2.getKontoInfo());
    		}
    		else if(Nummer == 3 ) {
    			Konto_3 = new Konten ( );
    			Konto_3.setKontoSaldo(775.00);
    			System.out.println(Konto_3.getKontoInfo());
    		}
    	} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Du Schlingel das hat nicht funktioniert.");
		} 	
    }
}

