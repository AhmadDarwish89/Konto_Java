package Konto_05;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class KontoCreate extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textKontoNr;
	private JTextField textKontoInhaber;

	private JButton btnCreateKonto;
	private JButton btnZahlungButton;
	
	private ArrayList<Konten> KontoListe = new ArrayList<>();
	private Konten aktKonto;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KontoCreate frame = new KontoCreate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public KontoCreate() {
		setTitle("Konto_03 (Create Konto)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreateKonto = new JButton("KontoAnlegen");
		btnCreateKonto.setBounds(22, 253, 138, 52);
		btnCreateKonto.addActionListener(this);
		contentPane.add(btnCreateKonto);
		
		btnZahlungButton = new JButton("Ein-Auszahlung");
		btnZahlungButton.setBounds(318, 253, 138, 52);
		btnZahlungButton.addActionListener(this);
		contentPane.add(btnZahlungButton);
		
		textKontoNr = new JTextField();
		textKontoNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoNr.setBounds(22, 69, 205, 27);
		contentPane.add(textKontoNr);
		textKontoNr.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Konto Nr:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 30, 74, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblKontoInhaber = new JLabel("Konto Inhaber:");
		lblKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoInhaber.setBounds(22, 147, 134, 27);
		contentPane.add(lblKontoInhaber);
		
		textKontoInhaber = new JTextField();
		textKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoInhaber.setColumns(10);
		textKontoInhaber.setBounds(22, 185, 434, 27);
		contentPane.add(textKontoInhaber);
		
		JButton btnBearbeitenButton = new JButton("Konto bearbeiten");
		btnBearbeitenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnBearbeitenButton){
		    		OpenKontoEdit();
				
				
			}
			}});
		
		btnBearbeitenButton.setBounds(170, 253, 138, 52);
		contentPane.add(btnBearbeitenButton);
	}
	public void actionPerformed(ActionEvent e) {
    	if(e.getSource()== btnCreateKonto){
    		createKonto();
    	//}else if(e.getSource()== btnBearbeitenButton){
    		//OpenKontoEdit();
    	}else if(e.getSource()== btnZahlungButton){
    		OpenKontoBuchen();
    	}
    	
	} 
	
	 private void createKonto() {
	    	try {
	    		if (CheckExistKonto() == 0) {
	    			aktKonto = new Konten();
	    			aktKonto.setKontoInhaber(textKontoInhaber.getText());
	    			aktKonto.setKontoNr(textKontoNr.getText());
	    			aktKonto.setKontoSaldo(0);
	    			aktKonto.setKontoDispo(0);
	    			KontoListe.add(aktKonto);
	    			textKontoInhaber.setText("");
	    			textKontoNr.setText("");
	    			JOptionPane.showMessageDialog(null, "Konto erfolgreich angelegt !");
	    		} else {
	    			JOptionPane.showMessageDialog(null, "Konto bereits vorhanden !");
	    		}
	    	} catch (Exception e){
				JOptionPane.showMessageDialog(null, e.toString());
			}
	    	
	    }
	    
	    private int CheckExistKonto() {
	    	CheckExistKonto KontoExist = new CheckExistKonto();
	    	int Ok = 0;
	    	return Ok = KontoExist.CheckIt(KontoListe, textKontoNr.getText());
	    	
	    }
	    
	    private void OpenKontoEdit() {
	    	boolean OpenIt = false;
	        for (int i = 0;i < KontoListe.size(); i++){
	        	if(KontoListe.get(i).getKontoNr().equals(textKontoNr.getText())) {
	        		aktKonto = KontoListe.get(i);
	        		OpenIt = true;
	        		break;
	        	}
	        }
	        if (OpenIt == true) {
	    		KontoBearbeiten dialog = new KontoBearbeiten();
	    		dialog.StartMe(aktKonto);
	    		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    		dialog.setVisible(true);
	        }
	    }
	    
	    private void OpenKontoBuchen() {
	    	boolean OpenIt = false;
	        for (int i = 0;i < KontoListe.size(); i++){
	        	if(KontoListe.get(i).getKontoNr().equals(textKontoNr.getText())) {
	        		aktKonto = KontoListe.get(i);
	        		OpenIt = true;
	        		break;
	        	}
	        }
	        if (OpenIt == true) {
	    		KontoBuchung dialog = new KontoBuchung();
	    		dialog.StartMe(aktKonto);
	    		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    		dialog.setVisible(true);
	        }
	    }
	}