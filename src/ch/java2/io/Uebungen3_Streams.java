package ch.java2.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Uebungen3_Streams
{
	public static void main(String[] args) throws Exception
	{
		schreibenUndLesen_EinzelneBytes();
		schreibenUndLesen_ByteArrays();
		schreibenUndLesen_DataStreams();
		schreibenUndLesen_BufferedStreams();
	}


	static void schreibenUndLesen_EinzelneBytes() throws Exception
	{
		System.out.println("\n\nschreiben bytes");
		FileOutputStream fos = new FileOutputStream("temp/fname31.txt");

		fos.write(97); // 97=a

		for (int i = 0; i <= 255; i++)
		{
			fos.write(i);
		}

		fos.close();

		// /////////////////////////////////////////

		System.out.println("\n\nlesen bytes");
		FileInputStream fis = new FileInputStream("temp/fname31.txt");

		int i = fis.read();

		while (i != -1)
		{
			if (i % 16 == 0)
				System.out.println();

			System.out.print(i + "=" + (char) i + ", ");

			i = fis.read();
		}

		fis.close();
	}


	private static void schreibenUndLesen_ByteArrays() throws Exception
	{
		byte[] ba1 = { 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h',
				'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o',
				'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g',
				'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o' };

		System.out.println("\n\nschreiben byteArray");

		FileOutputStream fos = new FileOutputStream("temp/fname32.txt");

		fos.write(ba1, 16, 13);

		fos.close();

		// /////////////////////////////////////////////////////

		byte[] ba2 = new byte[1000];
		for (int i = 0; i < ba2.length; i++)
		{
			ba2[i] = 0;
		}

		System.out.println("\n\nlesen byteArray");

		FileInputStream fis = new FileInputStream("temp/fname32.txt");
		int l = fis.read(ba2);
		fis.close();
		fis = new FileInputStream("temp/fname32.txt");
		// int l2 = is.read(ba2, 150, 50);
		fis.close();

		System.out.println("laenge=" + l);

		for (int i = 0; i < 1000; i++)
		{
			System.out.print((char) ba2[i]);
		}
	}


	private static void schreibenUndLesen_DataStreams()
			throws Exception
	{
		final int MAX = 100;

		System.out.println("\n\nschreiben DataStreams");

		FileOutputStream fos = new FileOutputStream("temp/fname33.txt");
		DataOutputStream dos = new DataOutputStream(fos);

		for (int i = 1; i <= MAX; i++)
		{
			dos.writeInt(i);
			dos.writeDouble(i);
			dos.writeUTF("" + i);
		}

		dos.close();

		// /////////////////////////////////////////////////////

		System.out.println("\n\nlesen DataStreams");

		FileInputStream fis = new FileInputStream("temp/fname33.txt");
		DataInputStream dis = new DataInputStream(fis);

		for (int i = 1; i <= MAX; i++)
		{
			int iwert = dis.readInt();
			double dwert = dis.readDouble();
			String swert = dis.readUTF();

			System.out.printf("i=%3d, d=%5.1f, s=%-10s \n", iwert,
					dwert, swert);
		}

		dis.close();
	}


	private static void schreibenUndLesen_BufferedStreams()
			throws Exception
	{
		final int MAX = 100;

		System.out.println("\n\nschreiben BufferedStreams");

		FileOutputStream fos = new FileOutputStream("temp/fname34.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);

		for (int i = 1; i <= MAX; i++)
		{
			dos.writeInt(i);
			dos.writeDouble(i);
			dos.writeUTF("" + i);
		}

		dos.close();

		// /////////////////////////////////////////////////////

		System.out.println("\n\nlesen DataStreams");

		FileInputStream fis = new FileInputStream("temp/fname34.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);

		for (int i = 1; i <= MAX; i++)
		{
			int iwert = dis.readInt();
			double dwert = dis.readDouble();
			String swert = dis.readUTF();

			System.out.printf("i=%3d, d=%5.1f, s=%-10s \n", iwert,
					dwert, swert);
		}

		dis.close();
	}
}
