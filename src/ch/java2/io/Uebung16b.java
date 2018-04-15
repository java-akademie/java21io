package ch.java2.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Uebung zu Streams. <br>
 * ByteStreams - InputStream/OutputStream<br>
 * 
 * @author johann mildner
 * 
 */
public class Uebung16b
{
	static final String fileName1 = "testb1.txt";
	static final String fileName2 = "testb2.txt";
	static final String fileName3 = "testb3.txt";

	static FileInputStream fis;
	static FileOutputStream fos;


	public static void main(String[] args) throws IOException
	{
		writeBytes();
		writeByteArray();

		readBytes();
		readByteArray();
	}


	static void readByteArray() throws IOException
	{
		fis = new FileInputStream(fileName1);

		int l;
		byte[] buff = new byte[40];

		l = fis.read(buff);
		System.out.println("laenge=" + l);

		while (l != -1)
		{
			for (int j = 0; j < l; j++)
			{
				System.out.print((char) buff[j]);
			}
			System.out.println();

			l = fis.read(buff);
			System.out.println("laenge=" + l);

		}

		fis.close();
	}


	static void readBytes() throws IOException
	{
		fis = new FileInputStream(fileName1);

		int i;

		while ((i = fis.read()) != -1)
		{
			byte b = (byte) i;
			System.out.print((char) b);
		}

		fis.close();

		System.out.println("\n----------");
	}


	static void writeByteArray() throws IOException
	{
		fos = new FileOutputStream(fileName2);

		byte[] b = { 32, 33, 34, 35 };

		fos.write(b);

		fos.close();
	}


	static void writeBytes() throws IOException
	{
		fos = new FileOutputStream(fileName1);

		for (int i = 32; i < 127; i++)
		{
			fos.write((byte) i);
		}

		fos.close();
	}
}
