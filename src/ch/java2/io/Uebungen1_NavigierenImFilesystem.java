package ch.java2.io;

import java.io.File;
import java.util.Arrays;

public class Uebungen1_NavigierenImFilesystem
{
	public static void main(String[] args) throws Exception
	{
		File verzeichnis = new File("temp1");
		boolean b = verzeichnis.mkdir();
		System.out.println(b);

		File datei1 = new File(verzeichnis, "daten1.txt");
		File datei2 = new File(verzeichnis, "daten2.txt");
		File datei3 = new File(verzeichnis, "daten3.txt");
		File datei4 = new File(verzeichnis, "daten4.txt");

		datei1.createNewFile();
		datei2.createNewFile();
		datei3.createNewFile();
		datei4.createNewFile();

		String[] v = verzeichnis.list();
		System.out.println(Arrays.toString(v));

		delete(datei1, "datei1");
		delete(datei2, "datei2");
		delete(verzeichnis, "verzeichnis");
		delete(datei3, "datei3");
		delete(datei4, "datei4");
		delete(verzeichnis, "verzeichnis");
	}


	static void delete(File f, String msg)
	{
		boolean b = f.delete();
		System.out.println("delete " + msg + ": " + b);
	}
}
