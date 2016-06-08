package ch.java2.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;


public class Uebungen5_Konvertierungen
{
	public static void main(String[] args) throws Exception
	{
		schreibenUndLesen_Konvertierung();
	}



	private static void schreibenUndLesen_Konvertierung()
			throws Exception
	{
		final int MAX = 10;

		{
			System.out.println("\n\nschreiben");

			OutputStream fos = new FileOutputStream("temp/fname51.txt");
			Writer fw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 1; i <= MAX; i++)
			{
				bw.write("i=" + i + "\n");
			}

			bw.close();
		}

		// /////////////////////////////////////////////////////

		{
			System.out.println("\n\nlesen");

			InputStream fis = new FileInputStream("temp/fname51.txt");
			Reader fr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(fr);

			for (int i = 1; i <= MAX; i++)
			{
				String s = br.readLine();

				System.out.println(s);
			}

			br.close();
		}
	}
}
