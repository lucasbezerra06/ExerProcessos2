package view;

import controller.ProcesController;

public class Main {
	public static void main(String args[]){
		ProcesController procesController = new ProcesController();
		procesController.listProcess(procesController.getOS());
	}

}
