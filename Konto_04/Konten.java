package Konto_04;

import java.text.DecimalFormat;

public class Konten {
	public  static int StartKontoNr = 10000; 
	private int MyKontoIdNr;
	private int nextkontoIdNr;
	private int kontoNr;
	private double KontoSaldo;
	private double KontoDespo;
	private String KontoInhaber;
	private String Bemerkung;
	
	
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Konten () { 
		nextkontoIdNr = StartKontoNr ++;
	} 


	
	public int getnextkontoIdNr() {
		return nextkontoIdNr;
	}

	public void setnextkontoIdNr(int nextkontoIdNr) {
		this.nextkontoIdNr = nextkontoIdNr;
	}

	public int getKontoNr() {
		return kontoNr;
	}

	public void setKontoNr(int kontoNr) {
		this.kontoNr = kontoNr;
	}


	public double getKontoDespo() {
		return KontoDespo;
	}

	public void setKontoDespo(double kontoDespo) {
		KontoDespo = kontoDespo;
	}
	public static int getStartKontoNr() {
		return StartKontoNr;
	}

	public static void setStartKontoNr(int startKontoNr) {
		StartKontoNr = startKontoNr;
	}

	public double getKontoSaldo() {
		return KontoSaldo;
	}

	public void setKontoSaldo(double kontoSaldo) {
		this.KontoSaldo = kontoSaldo;
	}


	public String getKontoInhaber() {
		return KontoInhaber;
	}

	public void setKontoInhaber(String kontoInhaber) {
		KontoInhaber = kontoInhaber;
	}

	
	public String getBemerkung() {
		return Bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		Bemerkung = bemerkung;
	}





	public int getMyKontoIdNr() {
		return MyKontoIdNr;
	}



	public void setMyKontoIdNr(int myKontoIdNr) {
		MyKontoIdNr = myKontoIdNr;
	}



	public static DecimalFormat getDf() {
		return df;
	}


	public String getKontoInfo() {
		return  "KontoIdN: " 
				+ getMyKontoIdNr()
				+","+" KontoNr: " 
				+ getKontoNr()+"," +
				"KontoInhaber: " 
				+ getKontoInhaber()+
				"," + " KontoSaldo " 
				+ df.format(getKontoSaldo())+ 
				" KontoDispo " + df.format(getKontoDespo());  
	}

	
}

