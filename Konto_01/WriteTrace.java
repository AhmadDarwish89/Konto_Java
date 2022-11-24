package Konto_01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


public class WriteTrace {
	private File file = new File("D:\\Transfer\\LogFile.txt"); //Logfile, in das geschrieben wird
	private String Zeitstempel;
	
	public WriteTrace(String mytext) {
		LocalDateTime now = LocalDateTime.now();
		Zeitstempel = (now.toString());
		String EntryText = Zeitstempel + ": " + mytext;
		WriteEntry(EntryText);
	}
	
	private void WriteEntry(String TextLine) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.newLine();
			writer.write(TextLine);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
