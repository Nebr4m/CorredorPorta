package controller;

import java.util.concurrent.Semaphore;

public class ThreadsPessoa extends Thread {

	private int idPessoa;
	static private int corredorTamanho = 200;
	private Semaphore semaforo;

	public ThreadsPessoa(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	public void run() {
		CorredorPassar();
		try {
			semaforo.acquire();
			CruzarPorta();
		} catch (InterruptedException e) {
		} finally {
			semaforo.release();
		}
		
	}

	private void CorredorPassar() {
		int velocidadePessoa = (int) (Math.random() * 2) + 4;
		int metrosPessoa = 0;

		while (metrosPessoa < corredorTamanho) {

			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
			metrosPessoa += velocidadePessoa;
			if (metrosPessoa > 200)
				metrosPessoa = 200;
			System.out.println("#" + idPessoa + " andou " + metrosPessoa + " metros" + "(" + metrosPessoa + "|"
					+ corredorTamanho + ")");
		}
		System.err.println("Pessoa " + idPessoa + " chegou na porta.\n");
	}

	private void CruzarPorta() {
		System.out.println("#" + idPessoa + "Cruzando a Porta");
		int Passar = (int) (Math.random() * 1001) + 1000;
		try {
			sleep(Passar);
		} catch (InterruptedException e) {
		}
		System.out.println("Pessoa" + idPessoa + " Passou pela porta \n " + "demorou " + Passar + " ms");
	}
}
