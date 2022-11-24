package Konto_06;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;


public class KontoBuchen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtKontoInfo;
	private Konten aktKonto;
	private JTextField txtKontoSaldo;
	private JTextField txtBuchungsbetrag;
	private JTextField txtBuchungsText;
	private BuchungsListe aktBuchung;
	private ArrayList<BuchungsListe> ListeDerBuchungen;
	
	public void StartMe( Konten theKonto, ArrayList<BuchungsListe> AlleBuchungen) {
		ListeDerBuchungen = AlleBuchungen;
		aktKonto = theKonto;
		txtKontoInfo.setText(aktKonto.getKontoData());
		txtKontoSaldo.setText(aktKonto.getSKontoSaldo());
	}
	
	
	KontoBuchen() {
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
		
		JLabel lblKontoWarn = new JLabel("");
		lblKontoWarn.setBounds(139, 131, 174, 21);
		contentPanel.add(lblKontoWarn);
		
		/*	txtBuchungsText.addKeyListener(new KeyAdapter() {
			
		}
		    public void keyPressed(KeyEvent ke) {
		       String value = txtBuchungsText.getText();
		       int l = value.length();
		   	if (Pattern.matches("[a-zA-Z]+", value)) {
		       //if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		    	   txtBuchungsText.setEditable(true);
		    	   lblKontoWarn.setText("");
		       } else {
		    	   txtBuchungsText.setEditable(false);
		    	   lblKontoWarn.setText("Bitte Nur Buchstaben eingeben");
		       }
		    }
		 });*/
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
						KontoBuchen.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void BucheAb() {
		double AktSaldo = aktKonto.getKontoSaldo();
		double Betrag =  Double.parseDouble(txtBuchungsbetrag.getText());
		double NewSaldo = AktSaldo - Betrag;
		aktKonto.setKontoSaldo(NewSaldo);
		txtBuchungsbetrag.setText("0,00");
		txtKontoSaldo.setText(aktKonto.getSKontoSaldo());
		MakeBuchung("Ab", Betrag);
	}
	
	private void BucheEin() {
		double AktSaldo = aktKonto.getKontoSaldo();
		double Betrag =  Double.parseDouble(txtBuchungsbetrag.getText());
		double NewSaldo = AktSaldo + Betrag;
		aktKonto.setKontoSaldo(NewSaldo);
		txtBuchungsbetrag.setText("0.00");
		txtKontoSaldo.setText(aktKonto.getSKontoSaldo());
		MakeBuchung("Ein", Betrag);
	}
	
	private void MakeBuchung(String ZuAb, double Buchungsbetrag) {
		aktBuchung = new BuchungsListe();
		aktBuchung.setBuchungsBetrag(Buchungsbetrag);
		aktBuchung.setKontoNr(txtKontoInfo.getText());
		aktBuchung.setKontoSaldo(aktKonto.getKontoSaldo());
		aktBuchung.setKontoNr(txtKontoInfo.getText());
		if (ZuAb.equals("Zu")) {
			aktBuchung.setBuchungsVorgang("Zu");
		} else {
			aktBuchung.setBuchungsVorgang("Ab");
		}
		ListeDerBuchungen.add(aktBuchung);

	}

}
