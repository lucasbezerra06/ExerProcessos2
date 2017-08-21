package view;
import javax.swing.JOptionPane;

import controller.ProcesController;
public class Main {
	public static void main(String args[]){
		int pid,op;
		String nome,osName;
		ProcesController procesController = new ProcesController();
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog("Menu\n1 - Lista de precessos ativos\n2 - Matar processo pelo pid\n3 - Matar processo pelo nome\n9 - Sair"));
			switch(op){
				case 1: procesController.listProcess(procesController.getOS());
					break;
				case 2: pid = Integer.parseInt(JOptionPane.showInputDialog("Insira o PID do processo a ser encerrado"));
						procesController.killProcessPid(procesController.getOS(), pid);
						break;
				case 3:	nome = JOptionPane.showInputDialog("Insira o nome do processo a ser encerrado");
						procesController.killProcessName(procesController.getOS(), nome);
						break;
				default: JOptionPane.showMessageDialog(null, "Opção Invalida");
				break;
			}
		}while(op != 0);
		
		
		

		
	
	}

}
