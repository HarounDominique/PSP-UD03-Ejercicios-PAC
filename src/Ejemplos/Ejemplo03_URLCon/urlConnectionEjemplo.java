package Ejemplos.Ejemplo03_URLCon;

import java.net.*;
import java.io.*;

public class urlConnectionEjemplo {
	public static void main(String[] args) {
		URL url = null;
		URLConnection urlCon = null;
		try {
			url = new URL("http://www.google.es");
			urlCon = url.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}

			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}//
}//Ejemplo1urlCon
