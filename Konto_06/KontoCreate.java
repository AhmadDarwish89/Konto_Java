package Konto_06;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class KontoCreate extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCreateKonto;
	private JButton btnKontoEdit;
	private JButton btnEinAuszahlung; 
	private JButton btnShowBuchungsliste;
	
	private ArrayList<Konten> KontoListe = new ArrayList<>();
	private ArrayList<BuchungsListe> Buchungen = new ArrayList<>();
	private Konten aktKonto;
	private JTextField textKontoInhaber;
	private JLabel lblKontoInhaber;
	private JTextField textKontoSaldo;
	private JTextField textKontoDespo;
	private JLabel lblKontoDispo;
	private JLabel lblKontoSaldo;
	private JTextField textKontoIdNr;
	private JTextField textKontoNr;
	private JLabel lblNewLabel;
	private JLabel lblKontoIdn;
	private JLabel lblKontoWarn;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KontoCreate frame = new KontoCreate();
					centreWindow(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public KontoCreate() {
		setTitle("Konto_05 (Konto anlegen)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreateKonto = new JButton("KontoAnlegen");
		btnCreateKonto.setBounds(22, 223, 138, 52);
		btnCreateKonto.addActionListener(this);
		contentPane.add(btnCreateKonto);
		
		btnKontoEdit = new JButton("Konto bearbeiten");
		btnKontoEdit.setBounds(170, 223, 138, 52);
		btnKontoEdit.addActionListener(this);
		contentPane.add(btnKontoEdit);
		
		btnEinAuszahlung = new JButton("Ein-, Auszahlung");
		btnEinAuszahlung.setBounds(318, 223, 138, 52);
		btnEinAuszahlung.addActionListener(this);
		contentPane.add(btnEinAuszahlung);
		
		btnShowBuchungsliste = new JButton("Show BuchungsListe");
		btnShowBuchungsliste.addActionListener(this);
		btnShowBuchungsliste.setBounds(22, 286, 434, 52);
		contentPane.add(btnShowBuchungsliste);
		
		textKontoInhaber = new JTextField();
		textKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoInhaber.setColumns(10);
		textKontoInhaber.setBounds(22, 185, 434, 27);
		contentPane.add(textKontoInhaber);
		
		lblKontoInhaber = new JLabel("Konto Inhaber:");
		lblKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoInhaber.setBounds(22, 147, 134, 27);
		contentPane.add(lblKontoInhaber);
		
		textKontoSaldo = new JTextField();
		textKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoSaldo.setColumns(10);
		textKontoSaldo.setBounds(22, 109, 205, 27);
		contentPane.add(textKontoSaldo);
		
		textKontoSaldo.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent ke) {
		       String value = textKontoSaldo.getText();
		       int l = value.length();
		       if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		    	   textKontoSaldo.setEditable(true);
		    	   lblKontoWarn.setText("");
		       } else {
		    	   textKontoSaldo.setEditable(false);
		    	   lblKontoWarn.setText("Bitte eine Zahl eingeben");
		       }
		    }
		 });
		
		textKontoDespo = new JTextField();
		textKontoDespo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoDespo.setColumns(10);
		textKontoDespo.setBounds(251, 109, 205, 27);
		contentPane.add(textKontoDespo);
		
		textKontoDespo.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent ke) {
		       String value = textKontoDespo.getText();
		       int l = value.length();
		       if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		    	   textKontoDespo.setEditable(true);
		    	   lblKontoWarn.setText("");
		       } else {
		    	   textKontoDespo.setEditable(false);
		    	   lblKontoWarn.setText("Bitte eine Zahl eingeben");
		       }
		    }
		 });
		
		lblKontoDispo = new JLabel("Konto Dispo");
		lblKontoDispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoDispo.setBounds(252, 71, 74, 27);
		contentPane.add(lblKontoDispo);
		
		
		
		lblKontoSaldo = new JLabel("Konto Saldo:");
		lblKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoSaldo.setBounds(22, 71, 74, 27);
		contentPane.add(lblKontoSaldo);
		
		textKontoIdNr = new JTextField();
		textKontoIdNr.setText("10000");
		textKontoIdNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoIdNr.setColumns(10);
		textKontoIdNr.setBounds(22, 42, 205, 27);
		contentPane.add(textKontoIdNr);
		
		textKontoIdNr.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent ke) {
		       String value = textKontoIdNr.getText();
		       int l = value.length();
		       if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		    	   textKontoIdNr.setEditable(true);
		    	   lblKontoWarn.setText("");
		       } else {
		    	   textKontoIdNr.setEditable(false);
		    	   lblKontoWarn.setText("Bitte eine Zahl eingeben");
		       }
		    }
		 });
		
		textKontoNr = new JTextField();
		textKontoNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoNr.setColumns(10);
		textKontoNr.setBounds(251, 42, 205, 27);
		contentPane.add(textKontoNr);
		

		textKontoNr.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent ke) {
		       String value = textKontoNr.getText();
		       int l = value.length();
		       if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		    	   textKontoNr.setEditable(true);
		    	   lblKontoWarn.setText("");
		       } else {
		    	   textKontoNr.setEditable(false);
		    	   lblKontoWarn.setText("Bitte eine Zahl eingeben");
		       }
		    }
		 });
		
		lblNewLabel = new JLabel("Konto Nr:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(252, 4, 74, 27);
		contentPane.add(lblNewLabel);
		
		lblKontoIdn = new JLabel("Konto IdN:");
		lblKontoIdn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoIdn.setBounds(32, 4, 74, 27);
		contentPane.add(lblKontoIdn);
		
		lblKontoWarn = new JLabel("");
		lblKontoWarn.setBounds(152, 153, 174, 21);
		contentPane.add(lblKontoWarn);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
    	if(e.getSource()== btnCreateKonto){
    		createKonto();
    	} else if(e.getSource()== btnKontoEdit){
    		OpenKontoEdit();
    	} else if(e.getSource()== btnEinAuszahlung){
    		OpenKontoBuchen();
    	} else if(e.getSource()== btnShowBuchungsliste){
    		ShowBuchungsListe();
    	}
    	
	} 

	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	public boolean Checkstring(String text) {
	boolean check=true;
	
		if (Pattern.matches("[a-zA-Z]+", text)) {
		    
		    return check=true;
		} else {return check=false;}
	    }
	
	
    private void createKonto() {
    
    	try {
    
    		if (CheckExistKonto() == 0) {
    			aktKonto = new Konten();
        		aktKonto.setKontoIdNr(Integer.valueOf(textKontoIdNr.getText()));
        		aktKonto.setKontoSaldo(Double.parseDouble(textKontoSaldo.getText()));
        		aktKonto.setKontoDispo(Double.parseDouble(textKontoDespo.getText()));
        		aktKonto.setKontoInhaber(textKontoInhaber.getText());
    			aktKonto.setKontoNr(textKontoNr.getText());
    		
    			
    			KontoListe.add(aktKonto);
    			textKontoInhaber.setText("");
    			textKontoNr.setText("");
        		textKontoSaldo.setText("");
        		textKontoDespo.setText("");
        		textKontoIdNr.setText(Integer.toString(aktKonto.getKontoIdNr()));
        	
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
    		KontoEdit dialog = new KontoEdit();
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
    		KontoBuchen dialog = new KontoBuchen();
    		dialog.StartMe(aktKonto, Buchungen);
    		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    		dialog.setVisible(true);
        }
    }
    
    private void ShowBuchungsListe() {
        for (int i = 0;i < Buchungen.size(); i++){
        	System.out.println(Buchungen.get(i).getsBuchungsDatum() + ": Konto: " +  Buchungen.get(i).getKontoIdNr() + ": " + Buchungen.get(i).getBuchungsVorgang() + " Betrag: " + Buchungen.get(i).getBuchungsBetrag() + " Saldo: " + Buchungen.get(i).getSKontoSaldo());
        }
    }
}