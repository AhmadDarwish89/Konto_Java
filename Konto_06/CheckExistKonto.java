package Konto_06;

import java.util.ArrayList;

public class CheckExistKonto {
	
	public int CheckIt(ArrayList<Konten> AlleKonten, String aktKontoNr) {
		int returnWert = 0;
        for (int i = 0;i < AlleKonten.size(); i++){
        	if (AlleKonten.get(i).getKontoNr().equals(aktKontoNr)) {
        		returnWert = 1;
        		break;
        	} else {
        		returnWert = 0;
        	}
        }
		return returnWert;
    }
}
