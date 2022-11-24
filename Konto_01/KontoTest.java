package Konto_01;

public class KontoTest {
	public static void main(String[] args) {
		Konten Konto_1 = new Konten ( );
		Konto_1.setKontoSaldo(150.00);
		System.out.println(Konto_1.getKontoInfo());
		new WriteTrace("Konto_1 erzeugt");
		
		
		Konten Konto_2 = new Konten ( );
		Konto_2.setKontoSaldo(350.00);
		System.out.println(Konto_2.getKontoInfo());
		new WriteTrace("Konto_2 erzeugt");
		
		Konten Konto_3 = new Konten ( );
		Konto_3.setKontoSaldo(572.00);
		System.out.println(Konto_3.getKontoInfo());
		new WriteTrace("Konto_3 erzeugt");
		
		Konten Konto_4 = new Konten ( );
		Konto_4.setKontoSaldo(212.00);
		System.out.println(Konto_4.getKontoInfo());
		new WriteTrace("Konto_4 erzeugt");

	}
}
