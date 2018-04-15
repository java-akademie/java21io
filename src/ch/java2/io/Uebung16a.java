package ch.java2.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Uebung zu Streams. <br>
 * CharacterStreams - Reader/Writer<br>
 * 
 * @author johann mildner
 * 
 */
public class Uebung16a
{
	static final String fileName1 = "temp/testa1.txt";
	static final String fileName2 = "temp/testa2.txt";
	static final String fileName3 = "temp/testa3.txt";

	static FileWriter fw;
	static FileReader fr;


	public static void main(String[] args) throws IOException
	{
		writeCharacters();
		writeCharacterArray();
		writeString();
		readCharacters();
		readCharacterArray();
	}


	static void readCharacterArray() throws IOException
	{
		fr = new FileReader(fileName2);

		int l;

		char[] buff = new char[40];

		l = fr.read(buff);
		System.out.println("laenge=" + l);

		while (l != -1)
		{
			for (int j = 0; j < l; j++)
			{
				System.out.print("." + buff[j]);
			}
			System.out.println();

			l = fr.read(buff);
			System.out.println("laenge=" + l);

		}

		fr.close();
	}


	static void readCharacters() throws IOException
	{
		fr = new FileReader(fileName3);

		int i;

		while ((i = fr.read()) != -1)
		{
			System.out.print("." + (char) i);
		}

		fr.close();

		System.out.println("\n----------");
	}


	static void writeCharacterArray() throws IOException
	{
		fw = new FileWriter(fileName2);

		char[] arr = { 32, 35, 44, 55, 77, 100 };

		fw.write(arr);

		fw.close();
	}


	static void writeCharacters() throws IOException
	{
		fw = new FileWriter(fileName1);

		for (int i = 32; i < 127; i++)
		{
			fw.write((char) i);
		}

		fw.close();
	}


	static void writeString() throws IOException
	{
		fw = new FileWriter(fileName3);

		fw.write("abcdefghijk");
		fw.write("lmnopqrstuv");

		fw.close();
	}

}
