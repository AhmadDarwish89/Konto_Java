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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

public class KontoEdit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtKontoNr;
	private Konten aktKonto;
	private JTextField txtKontoInhaber;
	private JTextField txtKontoSaldo;
	private JTextField txtKontoDispo;
	
	void StartMe( Konten theKonto) {
		aktKonto = theKonto;
		txtKontoNr.setText(aktKonto.getKontoNr());
		txtKontoSaldo.setText(aktKonto.getSKontoSaldo());
		txtKontoInhaber.setText(aktKonto.getKontoInhaber());
		txtKontoDispo.setText(aktKonto.getSKontoDispo());
	}
	
	
	KontoEdit() {
		setTitle("Konto bearbeiten");
		setBounds(500, 600, 450, 300);  // PosX, PosY, h,b
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtKontoNr = new JTextField();
		txtKontoNr.setEditable(false);
		txtKontoNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKontoNr.setBounds(23, 36, 106, 21);
		contentPanel.add(txtKontoNr);
		txtKontoNr.setColumns(10);
		{
			txtKontoInhaber = new JTextField();
			txtKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtKontoInhaber.setColumns(10);
			txtKontoInhaber.setBounds(150, 36, 248, 21);
			contentPanel.add(txtKontoInhaber);
		}
		
		JLabel lblNewLabel = new JLabel("KontoNr");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(23, 11, 65, 21);
		contentPanel.add(lblNewLabel);
		
		JLabel lblKontoinhaber = new JLabel("KontoInhaber");
		lblKontoinhaber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoinhaber.setBounds(150, 15, 129, 21);
		contentPanel.add(lblKontoinhaber);
		{
			JLabel lblKontosaldo = new JLabel("KontoSaldo");
			lblKontosaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKontosaldo.setBounds(150, 69, 129, 21);
			contentPanel.add(lblKontosaldo);
		}
		{
			txtKontoSaldo = new JTextField();
			txtKontoSaldo.setEditable(false);
			txtKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtKontoSaldo.setColumns(10);
			txtKontoSaldo.setBounds(150, 90, 117, 21);
			contentPanel.add(txtKontoSaldo);
		}
		{
			JLabel lblKontodispo = new JLabel("KontoDispo");
			lblKontodispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKontodispo.setBounds(150, 122, 129, 21);
			contentPanel.add(lblKontodispo);
		}
		{
			txtKontoDispo = new JTextField();
			txtKontoDispo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtKontoDispo.setColumns(10);
			txtKontoDispo.setBounds(150, 143, 117, 21);
			
			
			
			txtKontoDispo.addKeyListener(new KeyAdapter() {
		         public void keyPressed(KeyEvent ke) {
		            String value = txtKontoDispo.getText();
		            int l = value.length();
		            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		            	txtKontoDispo.setEditable(true);
		            } else {
		            	txtKontoDispo.setEditable(false);
		            }
		         }
		      });
	
			contentPanel.add(txtKontoDispo);
			
		}
		{
			JLabel lblKontoWarn2 = new JLabel("");
			lblKontoWarn2.setBounds(132, 184, 174, 21);
			contentPanel.add(lblKontoWarn2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save and return");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aktKonto.setKontoDispo(Double.parseDouble(txtKontoDispo.getText()));
						aktKonto.setKontoInhaber(txtKontoInhaber.getText());
						KontoEdit.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
