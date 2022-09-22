package view;

import java.util.concurrent.Semaphore;
import controller.ThreadsPessoa;

public class Corredor {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 4; i++) { 

			ThreadsPessoa  pessoa = new ThreadsPessoa(i, semaforo);
			pessoa.start();

		}

	}

}