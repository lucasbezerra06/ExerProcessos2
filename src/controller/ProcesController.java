package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcesController {
	
	public ProcesController() {
		super();
	}
	
	public String getOS(){
		return System.getProperty("os.name"); 
	}
	
	public void listProcess(String so){
		try {
			Process p = Runtime.getRuntime().exec("tasklist");
			InputStream fluxo = p.getInputStream();
			InputStreamReader lerFluxo= new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(lerFluxo);
			
			String linha = buffer.readLine();
			while(linha != null){
				System.out.println(linha);
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
