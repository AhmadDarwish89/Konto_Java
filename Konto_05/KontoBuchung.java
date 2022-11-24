package Konto_05;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class KontoBuchung extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtKontoInfo;
	private Konten aktKonto;
	private JTextField txtKontoSaldo;
	private JTextField txtBuchungsbetrag;
	private JTextField txtBuchungsText;
	
	void StartMe( Konten theKonto) {
		aktKonto = theKonto;
		txtKontoInfo.setText(aktKonto.getKontoData());
		txtKontoSaldo.setText(aktKonto.getSKontoSaldo());
	}
	
	
	KontoBuchung() {
		setTitle("Konto buchen");
		setBounds(500, 600, 450, 300);  // PosX, PosY, h,b
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtKontoInfo = new JTextField();
		txtKontoInfo.setEditable(false);
		txtKontoInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKontoInfo.setBounds(23, 36, 384, 21);
		contentPanel.add(txtKontoInfo);
		txtKontoInfo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Konto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(23, 11, 65, 21);
		contentPanel.add(lblNewLabel);
		{
			JLabel lblKontosaldo = new JLabel("KontoSaldo");
			lblKontosaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKontosaldo.setBounds(23, 78, 129, 21);
			contentPanel.add(lblKontosaldo);
		}
		{
			txtKontoSaldo = new JTextField();
			txtKontoSaldo.setEditable(false);
			txtKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtKontoSaldo.setColumns(10);
			txtKontoSaldo.setBounds(23, 99, 117, 21);
			contentPanel.add(txtKontoSaldo);
		}
		{
			JLabel lblKontodispo = new JLabel("Buchungsbetrag");
			lblKontodispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKontodispo.setBounds(290, 78, 117, 21);
			contentPanel.add(lblKontodispo);
		}
		{
			txtBuchungsbetrag = new JTextField();
			txtBuchungsbetrag.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtBuchungsbetrag.setColumns(10);
			txtBuchungsbetrag.setBounds(290, 99, 117, 21);
			txtBuchungsbetrag.addKeyListener(new KeyAdapter() {
		         public void keyPressed(KeyEvent ke) {
		            String value = txtBuchungsbetrag.getText();
		            int l = value.length();
		            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		            	txtBuchungsbetrag.setEditable(true);
		            } else {
		            	txtBuchungsbetrag.setEditable(false);
		            }
		         }
		      });
			contentPanel.add(txtBuchungsbetrag);
		}
		
		JLabel lblBuchungstext = new JLabel("Buchungstext");
		lblBuchungstext.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBuchungstext.setBounds(23, 140, 117, 21);
		contentPanel.add(lblBuchungstext);
		
		txtBuchungsText = new JTextField();
		txtBuchungsText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuchungsText.setColumns(10);
		txtBuchungsText.setBounds(23, 161, 384, 21);
		contentPanel.add(txtBuchungsText);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnZu = new JButton("Einzahlung");
				btnZu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BucheEin();
					}
				});
				
				JButton BtnAb = new JButton("Auszahlung");
				BtnAb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BucheAb();
					}
				});
				buttonPane.add(BtnAb);
				buttonPane.add(btnZu);
				getRootPane().setDefaultButton(btnZu);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						KontoBuchung.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public boolean Checkstring(String text) {
	boolean check=true;
	
		if (Pattern.matches("[a-zA-Z]+", text)) {
		    
		    return check=true;
		} else {return check=false;}
	    }
	
	
	private void BucheAb() {
		String text=txtBuchungsText.getText();
		
		try {
			if (Checkstring(text)) {
		double AktSaldo = aktKonto.getKontoSaldo();
		double Betrag =  Double.parseDouble(txtBuchungsbetrag.getText());
		double NewSaldo = AktSaldo - Betrag;
		aktKonto.setKontoSaldo(NewSaldo);
		txtBuchungsbetrag.setText("0,00");
		txtKontoSaldo.setText(aktKonto.getSKontoSaldo());
  		} else {
			JOptionPane.showMessageDialog(null, "Sie Sollen Buchtaben Schreiben, Keine Zahlen !");
		}
	} catch (Exception e){
		JOptionPane.showMessageDialog(null, e.toString());
	}
		}
	

	
	
	private void BucheEin() {
		String text=txtBuchungsText.getText();
	
		try {
			if (Checkstring(text)) {
		double AktSaldo = aktKonto.getKontoSaldo();
		double Betrag =  Double.parseDouble(txtBuchungsbetrag.getText());
		double NewSaldo = AktSaldo + Betrag;
		aktKonto.setKontoSaldo(NewSaldo);
		txtBuchungsbetrag.setText("0,00");
		txtKontoSaldo.setText(aktKonto.getSKontoSaldo());
			} else {
				JOptionPane.showMessageDialog(null, "Sie Sollen Buchtaben Schreiben, Keine Zahlen !");
			}
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, e.toString());
		}
			}
}