package com.javi.acme.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class leer_sistema
{
	File archivo = null;
	String ruta="c:\\sistemabd.txt";
	private Integer sistema;
	
	public Integer leer_sist() throws IOException
	{	
		BufferedReader br = new BufferedReader(new FileReader(ruta));
		sistema = Integer.parseInt(br.readLine());
		return  sistema;
		
	}
}
