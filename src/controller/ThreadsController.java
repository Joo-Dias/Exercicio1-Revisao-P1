package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadsController extends Thread {

	int threadId;

	Random rd = new Random();
	Semaphore semaforo;

	public ThreadsController(int threadId, Semaphore semaforo) {
		this.threadId = threadId;
		this.semaforo = semaforo;
	}

	public void run() {
		if (threadId % 3 == 1) {
			calculoThreadIgualUm();
			transacaoBD();
			calculoThreadIgualUm();
			transacaoBD();
		} else if (threadId % 3 == 2) {
			calculoThreadIgualUm();
			transacaoBD();
			calculoThreadIgualUm();
			transacaoBD();
		} else {
			calculoThreadIgualUm();
			transacaoBD();
			calculoThreadIgualUm();
			transacaoBD();
		}
	}

	public void calculoThreadIgualUm() {
		// Valor aleatório entre 0.2 a 1.0 segundo
		double valor = 0.2 + rd.nextDouble() * 0.8; // valor aleatório entre 0.2 e 1 segundo
		long tempo = (long) (valor * 1000);

		try {
			Thread.sleep(tempo);
			System.out.println("A thread " + threadId + " está fazendo o cálculo!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void calculoThreadIgualDois() {
		// Valor aleatório entre 0.2 a 1.0 segundo
		double valor = 0.5 + rd.nextDouble(); // valor aleatório entre 0.5 e 1.5 segundo
		long tempo = (long) (valor * 1000);
		
		try {
			Thread.sleep(tempo);
			System.out.println("A thread " + threadId + " está fazendo o cálculo!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void calculoThreadIgualZero() {
		// Valor aleatório entre 0.2 a 1.0 segundo
		double valor = 1 + rd.nextDouble(); // valor aleatório entre 1 e 2 segundo
		long tempo = (long) (valor * 1000);
		
		try {
			Thread.sleep(tempo);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void transacaoBD() {
		try {
			semaforo.acquire();
			if(threadId % 3 == 1) {
				Thread.sleep(1000);
				System.out.println("A thread "+threadId+" está fazendo transações de BD!");
			} else if(threadId % 3 == 2) {
				Thread.sleep(1500);
				System.out.println("A thread "+threadId+" está fazendo transações de BD!");
			} else {
				Thread.sleep(1500);
				System.out.println("A thread "+threadId+" está fazendo transações de BD!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}

}
