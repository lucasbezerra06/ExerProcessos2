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
		String comando = "";
		
		if(so.contains("Windows")){
			comando = "tasklist";
		}
		else if(so.contains("Linux")){
			comando="ps aux";
		}
		try {
			Process p = Runtime.getRuntime().exec(comando);
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
	
	public void killProcessPid(String OS,int PID){
		String cmdPid = "";
		if(OS.contains("Windows")){
			cmdPid = "TASKKILL /PID ";
		}
		else if(OS.contains("Linux")){
			cmdPid = "kill -9 ";
		}
		
		StringBuffer buffer = new StringBuffer();
			buffer.append(cmdPid);
			buffer.append(PID);
		
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void killProcessName(String OS,String Nome){
		String cmdNome;
		if(OS.contains("Windows")){
			cmdNome = "TASKKILL /IM ";
			StringBuffer buffer = new StringBuffer();
				buffer.append(cmdNome);
				buffer.append(Nome);
		
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(OS.contains("Linux")){
			
			try {
				int pid;
				
				Process p = Runtime.getRuntime().exec("pidof "+Nome);
				InputStream fluxo = p.getInputStream();
				InputStreamReader lerFluxo= new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(lerFluxo);
				String linha = buffer.readLine();
				Nome = linha.substring(0, linha.length());
				cmdNome = "kill -9 ";
				StringBuffer stringbuffer = new StringBuffer();
				stringbuffer.append(cmdNome);
				stringbuffer.append(Nome);
				Runtime.getRuntime().exec(stringbuffer.toString());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	

}
