package Konto_06;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BuchungsListe {
	private int kontoIdNr;
	private double kontoSaldo;
	private double BuchungsBetrag;
	private String kontoNr;
	private String sBuchungsDatum;
	private String BuchungsVorgang;
	


	static DecimalFormatSymbols maske = new DecimalFormatSymbols(Locale.US);
	private static final DecimalFormat df = new DecimalFormat("0.00", maske);
	public static String AktDateTime = null; 
	
	public BuchungsListe() {
		LocalDateTime now = LocalDateTime.now();
		setsBuchungsDatum(now.toString());
	}
	
	public int getKontoIdNr() {
		return kontoIdNr;
	}
	
	public double getKontoSaldo() {
		return kontoSaldo;
	}
	
	public String getSKontoSaldo() {
		return df.format(getKontoSaldo());
	}

	public void setKontoSaldo(double kontoSaldo) {
		this.kontoSaldo = kontoSaldo;
	}

	public String getKontoNr() {
		return kontoNr;
	}

	public void setKontoNr(String kontoNr) {
		this.kontoNr = kontoNr;
	}
	
	public double getBuchungsBetrag() {
		return BuchungsBetrag;
	}

	public void setBuchungsBetrag(double buchungsBetrag) {
		BuchungsBetrag = buchungsBetrag;
	}
	
	public String getsBuchungsDatum() {
		return sBuchungsDatum;
	}
	
	public String getBuchungsVorgang() {
		return BuchungsVorgang;
	}

	public void setBuchungsVorgang(String buchungsVorgang) {
		BuchungsVorgang = buchungsVorgang;
	}

	public void setsBuchungsDatum(String sBuchungsDatum) {
		this.sBuchungsDatum = sBuchungsDatum;
	}
}
