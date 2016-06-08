package ch.java2.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class Uebungen4_WriterAndReader
{
	public static void main(String[] args) throws Exception
	{
		schreibenUndLesen_EinzelneChars();
		schreibenUndLesen_CharArrays();
		schreibenUndLesen_BufferedData();
		schreiben_PrintWriter();
	}


	static void schreibenUndLesen_EinzelneChars() throws Exception
	{
		System.out.println("\n\nschreiben chars");
		Writer fw = new FileWriter("temp/fname41.txt");

		fw.write(97); // 97=a

		for (int i = 0; i <= 255; i++)
		{
			fw.write(i);
		}

		fw.close();

		// /////////////////////////////////////////

		System.out.println("\n\nlesen chars");
		Reader fr = new FileReader("temp/fname41.txt");

		int i = fr.read();

		while (i != -1)
		{
			if (i % 16 == 0)
				System.out.println();

			System.out.print(i + "=" + (char) i + ", ");

			i = fr.read();
		}

		fr.close();
	}


	private static void schreibenUndLesen_CharArrays() throws Exception
	{
		char[] ca1 = { 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h',
				'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o',
				'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g',
				'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o' };

		System.out.println("\n\nschreiben charArray");

		Writer fw = new FileWriter("temp/fname42.txt");

		fw.write(ca1, 16, 13);

		fw.close();

		// /////////////////////////////////////////////////////


		char[] ca2 = new char[1000];
		for (int i = 0; i < ca2.length; i++)
		{
			ca2[i] = 0;
		}

		System.out.println("\n\nlesen charArray");

		Reader fr = new FileReader("temp/fname42.txt");
		int l1 = fr.read(ca2);
		fr.close();
		fr = new FileReader("temp/fname42.txt");
		int l2 = fr.read(ca2, 150, 50);
		fr.close();

		System.out.println("laenge1=" + l1);
		System.out.println("laenge2=" + l2);

		for (int i = 0; i < 1000; i++)
		{
			System.out.print((char) ca2[i]);
		}
	}


	private static void schreibenUndLesen_BufferedData()
			throws Exception
	{
		final int MAX = 10;

		{
			System.out.println("\n\nschreiben BufferedCharStreams");

			Writer fw = new FileWriter("temp/fname43.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 1; i <= MAX; i++)
			{
				bw.write("i=" + i + "\n");
			}

			bw.close();
		}

		// /////////////////////////////////////////////////////

		{
			System.out.println("\n\nlesen BufferedCharStreams");

			Reader fr = new FileReader("temp/fname43.txt");
			BufferedReader br = new BufferedReader(fr);

			for (int i = 1; i <= MAX; i++)
			{
				String s = br.readLine();

				System.out.println(s);
			}

			br.close();
		}
	}


	private static void schreiben_PrintWriter() throws Exception
	{
		final int MAX = 10;

		System.out.println("\n\nschreiben PrintWriter");

		Writer fw = new FileWriter("temp/fname44.txt");
		PrintWriter pw1 = new PrintWriter(fw);
		PrintWriter pw2 = new PrintWriter(System.out);

		for (int i = 1; i <= MAX; i++)
		{
			pw1.println("i=" + i);
			pw2.println("i=" + i);
		}

		pw1.close();
		pw2.close();
	}
}
