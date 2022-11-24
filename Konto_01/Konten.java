package Konto_01;

import java.text.DecimalFormat;

public class Konten {
	private int kontoNr;
	private double kontoSaldo;

	public static int StartKontoNr = 10000; 
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Konten () { 
		 kontoNr = StartKontoNr ++;
	} 
	 
	public int getKontoNr() {
		return kontoNr;
	}
	
	public double getKontoSaldo() {
		return kontoSaldo;
	}

	public void setKontoSaldo(double kontoSaldo) {
		this.kontoSaldo = kontoSaldo;
	}

	public String getKontoInfo() {
		return "KontoNr: " + getKontoNr() + " KontoSaldo " + df.format(getKontoSaldo());  
	}
}
