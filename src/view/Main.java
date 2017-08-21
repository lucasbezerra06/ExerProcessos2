package view;
import javax.swing.JOptionPane;

import controller.ProcesController;
public class Main {
	public static void main(String args[]){
		int pid;
		String nome;
		ProcesController procesController = new ProcesController();
		procesController.listProcess(procesController.getOS());
		pid = Integer.parseInt(JOptionPane.showInputDialog("Insira o PID do processo a ser encerrado"));
		procesController.killProcessPid(procesController.getOS(), pid);
		nome = JOptionPane.showInputDialog("Insira o nome do processo a ser encerrado");
		procesController.killProcessName(procesController.getOS(), nome);

	
	}

}
