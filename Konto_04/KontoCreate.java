package Konto_04;

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
	
	private ArrayList<Konten> KontoListe = new ArrayList<>();
	private Konten aktKonto;
	private JTextField textKontoDespo;
	private JTextField textKontoIdN;
	private JTextField textKontoIdNr;
	private JLabel lblKontoDispoWarn;

	
	
	
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
		Konten k = new Konten();
	
		
		textKontoNr = new JTextField();
		textKontoNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoNr.setBounds(251, 55, 205, 27);
		contentPane.add(textKontoNr);
		textKontoNr.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Konto Nr:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(252, 17, 74, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblKontoInhaber = new JLabel("Konto Inhaber:");
		lblKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoInhaber.setBounds(22, 160, 134, 27);
		contentPane.add(lblKontoInhaber);
		
		textKontoInhaber = new JTextField();
		textKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoInhaber.setColumns(10);
		textKontoInhaber.setBounds(22, 198, 434, 27);
		contentPane.add(textKontoInhaber);
		
		JLabel lblKontoSaldo = new JLabel("Konto Saldo:");
		lblKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoSaldo.setBounds(22, 84, 74, 27);
		contentPane.add(lblKontoSaldo);
		
		textKontoSaldo = new JTextField();
		textKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoSaldo.setColumns(10);
		textKontoSaldo.setBounds(22, 122, 205, 27);
		contentPane.add(textKontoSaldo);
		
		JLabel lblKontoDispo = new JLabel("Konto Dispo");
		lblKontoDispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoDispo.setBounds(252, 84, 74, 27);
		contentPane.add(lblKontoDispo);
		
		textKontoDespo = new JTextField();
		textKontoDespo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoDespo.setColumns(10);
		textKontoDespo.setBounds(251, 122, 205, 27);
		contentPane.add(textKontoDespo);
		
		textKontoIdNr = new JTextField();
		textKontoIdNr.setText("10000");
		textKontoIdNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoIdNr.setColumns(10);
		textKontoIdNr.setBounds(22, 55, 205, 27);
		contentPane.add(textKontoIdNr);
		
		JLabel lblKontoIdn = new JLabel("Konto IdN:");
		lblKontoIdn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoIdn.setBounds(32, 17, 74, 27);
		contentPane.add(lblKontoIdn);
		
		JButton btnKontoAnzeigen = new JButton("Konto anzeigen");
		textKontoDespo.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent ke) {
		       String value = textKontoDespo.getText();
		       int l = value.length();
		       if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		    	   textKontoDespo.setEditable(true);
		    	   lblKontoDispoWarn.setText("");
		       } else {
		    	   textKontoDespo.setEditable(false);
		    	   lblKontoDispoWarn.setText("Bitte eine Zahl eingeben");
		       }
		    }
		 });
		
		
		btnKontoAnzeigen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				if(e.getSource()== btnKontoAnzeigen){
					KontoById();
					
		
			}}}
		
		
		);
		

		btnKontoAnzeigen.setBounds(170, 253, 138, 52);
		contentPane.add(btnKontoAnzeigen);
		
		lblKontoDispoWarn = new JLabel("");
		lblKontoDispoWarn.setBounds(251, 160, 205, 21);
		contentPane.add(lblKontoDispoWarn);
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
    		aktKonto.setMyKontoIdNr(Integer.parseInt(textKontoIdNr.getText()));
    		aktKonto.setKontoNr(Integer.parseInt(textKontoNr.getText()));
    		aktKonto.setKontoSaldo(Double.parseDouble(textKontoSaldo.getText()));
    		aktKonto.setKontoDespo(Double.parseDouble(textKontoDespo.getText()));
    		aktKonto.setKontoInhaber(textKontoInhaber.getText());
    		
    		KontoListe.add(aktKonto);
    		textKontoNr.setText("");
    		textKontoSaldo.setText("");
    		textKontoDespo.setText("");
    		textKontoInhaber.setText("");
    		
    		textKontoIdNr.setText(Integer.toString(aktKonto.getnextkontoIdNr()));
    		
    		JOptionPane.showMessageDialog(null, textKontoInhaber.getText() + " Konto erfolgreich angelegt !");
    	} catch (Exception e){
			JOptionPane.showMessageDialog(null, e.toString());
		}	
    }
    
    private void ListKonten() {
        for (int i = 0;i < KontoListe.size(); i++){
        /*	System.out.println(KontoListe.get(i).getKontoNr());
        	System.out.println(KontoListe.get(i).getKontoSaldo());
        	System.out.println(KontoListe.get(i).getKontoDispo());
        	System.out.println(KontoListe.get(i).getKontoInhaber());*/
        	System.out.println(KontoListe.get(i).getKontoInfo());}
        }	
        private void KontoById() {
       
            for (int i = 0;i < KontoListe.size(); i++){
            	if(KontoListe.get(i).getMyKontoIdNr()== (Double.parseDouble(textKontoIdNr.getText()))){
            
            		textKontoNr.setText(String.valueOf(KontoListe.get(i).getKontoNr()));
            		textKontoDespo.setText(String.valueOf(KontoListe.get(i).getKontoDespo()));
            		textKontoSaldo.setText(String.valueOf(KontoListe.get(i).getKontoSaldo()));
            		textKontoInhaber.setText(String.valueOf(KontoListe.get(i).getKontoInhaber()));
            		System.out.println(KontoListe.get(i).getKontoInfo());
            		break;
         
            	} 
          
        
            }	
        
    }
}
