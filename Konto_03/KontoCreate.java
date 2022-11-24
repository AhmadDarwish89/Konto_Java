package Konto_03;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class KontoCreate extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textKontoNr;
	private JTextField textKontoInhaber;
	private JTextField textKontoSaldo;

	private JButton btnCreateKonto;
	private JButton btnShowKonten;
	private JTextField textBemerkung;
	
	private ArrayList<Konten> KontoListe = new ArrayList<>();
	private Konten aktKonto;
	private JTextField textKontoSaldo2;
	
	
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
		
		btnShowKonten = new JButton("Konten auflisten");
		btnShowKonten.setBounds(318, 253, 138, 52);
		btnShowKonten.addActionListener(this);
		contentPane.add(btnShowKonten);
		
		textKontoNr = new JTextField();
		textKontoNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoNr.setBounds(22, 44, 205, 27);
		contentPane.add(textKontoNr);
		textKontoNr.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Konto Nr:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(26, 17, 74, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblKontoInhaber = new JLabel("Konto Inhaber:");
		lblKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoInhaber.setBounds(30, 125, 134, 27);
		contentPane.add(lblKontoInhaber);
		
		textKontoInhaber = new JTextField();
		textKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoInhaber.setColumns(10);
		textKontoInhaber.setBounds(22, 151, 434, 27);
		contentPane.add(textKontoInhaber);
		
		JLabel lblKontoSaldo = new JLabel("Konto Saldo:");
		lblKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoSaldo.setBounds(255, 17, 74, 27);
		contentPane.add(lblKontoSaldo);
		
		textKontoSaldo = new JTextField();
		textKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoSaldo.setColumns(10);
		textKontoSaldo.setBounds(248, 46, 205, 27);
		contentPane.add(textKontoSaldo);
		
		JLabel lblBemerkung = new JLabel("Bemerkung");
		lblBemerkung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBemerkung.setBounds(30, 189, 134, 27);
		contentPane.add(lblBemerkung);
		
		textBemerkung = new JTextField();
		textBemerkung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textBemerkung.setColumns(10);
		textBemerkung.setBounds(22, 215, 434, 27);
		contentPane.add(textBemerkung);
		
		JLabel lblKontoDispo = new JLabel("Konto Dispo");
		lblKontoDispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoDispo.setBounds(251, 79, 74, 27);
		contentPane.add(lblKontoDispo);
		
		textKontoSaldo2 = new JTextField();
		textKontoSaldo2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoSaldo2.setColumns(10);
		textKontoSaldo2.setBounds(242, 108, 205, 27);
		contentPane.add(textKontoSaldo2);
	}
	
	public void actionPerformed(ActionEvent e) {
    	if(e.getSource()== btnCreateKonto){
    		createKonto();
    	} else if(e.getSource()== btnShowKonten){
    		ListKonten();
    	}
	} 
	
    private void createKonto() {
    	try {
    		aktKonto = new Konten();
    		aktKonto.setKontoSaldo(Double.parseDouble(textKontoSaldo.getText()));
    		aktKonto.setKontoDispo(Double.parseDouble(textKontoSaldo.getText()));
    		aktKonto.setKontoInhaber(textKontoInhaber.getText());
    		KontoListe.add(aktKonto);
    		textKontoSaldo.setText("");
    		textKontoInhaber.setText("");
    		JOptionPane.showMessageDialog(null, textKontoInhaber.getText() + " Konto erfolgreich angelegt !");
    	} catch (Exception e){
			JOptionPane.showMessageDialog(null, e.toString());
		}	
    }
    
    private void ListKonten() {
        for (int i = 0;i < KontoListe.size(); i++){
        	System.out.println(KontoListe.get(i).getKontoNr());
        	System.out.println(KontoListe.get(i).getKontoSaldo());
        	System.out.println(KontoListe.get(i).getKontoDispo());
        	System.out.println(KontoListe.get(i).getKontoInhaber());
        	System.out.println(KontoListe.get(i).getKontoInfo());
        }	
    }
}