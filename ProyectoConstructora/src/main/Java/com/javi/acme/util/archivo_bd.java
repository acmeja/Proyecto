package com.javi.acme.util;
import java.io.*;

public class archivo_bd
{
	File archivo = null;
	String ruta="c:\\sistemabd.txt";
	private Integer sistema;
	public void c_archivo_bd(Integer sistema) throws IOException
	{
		archivo = new File (ruta);
		FileWriter fichero = null;
		PrintWriter pw = null;		
        fichero = new FileWriter(archivo);
        pw = new PrintWriter(fichero);
        pw.println(sistema);
        pw.close();
	}



	

}
