package ch.java2.io;

import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;

public class Uebungen2_RandomAccessFile
{
	static final int MAX = 10;

	static File verzeichnis = new File("temp");
	static File datei = new File(verzeichnis, "raf.txt");

	static RandomAccessFile raf;


	public static void main(String[] args) throws Exception
	{
		fuellenMesswerte();
		lesenMaxMesswerte();
		lesenAlleMesswerte();
		lesenDesViertenMesswerts();
	}


	private static void fuellenMesswerte() throws Exception
	{
		System.out.println("\nfuellen MAX Messwerte (id, wert)");

		raf = new RandomAccessFile(datei, "rw");

		for (int i = 1; i <= MAX; i++)
		{
			raf.writeInt(i);
			raf.writeDouble(i * 100);
		}

		raf.close();
	}


	private static void lesenMaxMesswerte() throws Exception
	{
		System.out.println("\nlesen MAX Messwerte");

		raf = new RandomAccessFile(datei, "r");

		for (int i = 1; i <= MAX; i++)
		{
			int id = raf.readInt();
			double wert = raf.readDouble();
			System.out.println(id + "/" + wert);
		}

		raf.close();
	}


	private static void lesenAlleMesswerte() throws Exception
	{
		System.out.println("\nlesen aller Messwerte");

		raf = new RandomAccessFile(datei, "r");

		Integer id = 0;

		while (true)
		{
			try
			{
				id = raf.readInt();
			}
			catch (EOFException e)
			{
				break;
			}

			double wert = raf.readDouble();

			System.out.println(id + "/" + wert);
		}


		raf.close();

	}


	private static void lesenDesViertenMesswerts() throws Exception
	{
		System.out.println("\nlesen des vierten Messwerts");

		raf = new RandomAccessFile(datei, "r");

		int n = 4;
		int laenge = 4 + 8; // int = 4 bytes, double = 8 bytes
		raf.seek((n - 1) * laenge);
		int id2 = raf.readInt();
		double wert = raf.readDouble();
		System.out.println(id2 + "/" + wert);

		raf.close();
	}


}
