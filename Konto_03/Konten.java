package Konto_03;

import java.text.DecimalFormat;

public class Konten {
	private int kontoNr;
	private double KontoSaldo;
	private String Bemerkung;
	private String MyKontoNr;
	private String KontoInhaber;
	private double KontoDispo;


	public double getKontoDispo() {
		return KontoDispo;
	}

	public void setKontoDispo(double kontoDispo) {
		KontoDispo = kontoDispo;
	}

	public static int StartKontoNr = 10000; 
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Konten () { 
		 kontoNr = StartKontoNr ++;
	} 
	 
	public int getKontoNr() {
		return kontoNr;
	}
	
	public String getBemerkung() {
		return Bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		Bemerkung = bemerkung;
	}

	public String getMyKontoNr() {
		return MyKontoNr;
	}

	public void setMyKontoNr(String myKontoNr) {
		MyKontoNr = myKontoNr;
	}

	public static int getStartKontoNr() {
		return StartKontoNr;
	}

	public static void setStartKontoNr(int startKontoNr) {
		StartKontoNr = startKontoNr;
	}

	public static DecimalFormat getDf() {
		return df;
	}

	public void setKontoNr(int kontoNr) {
		this.kontoNr = kontoNr;
	}

	public double getKontoSaldo() {
		return KontoSaldo;
	}

	public void setKontoSaldo(double kontoSaldo) {
		this.KontoSaldo = kontoSaldo;
	}

	public String getKontoInfo() {
		return "KontoNr: " + getKontoNr()+"," + "KontoInhaber: " + getKontoInhaber()+ "," + " KontoSaldo " + df.format(getKontoSaldo())+ " KontoDispo " + df.format(getKontoDispo());  
	}

	public String getKontoInhaber() {
		return KontoInhaber;
	}

	public void setKontoInhaber(String kontoInhaber) {
		KontoInhaber = kontoInhaber;
	}
	
	 
}

