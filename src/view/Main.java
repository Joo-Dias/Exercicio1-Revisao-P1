package view;

import java.util.concurrent.Semaphore;

import controller.ThreadsController;

public class Main {
	
	public static Semaphore semaforo;

	public static void main(String[] args) {
		
		// Variável que recebe o limite de threads
		int lim = 1;
		
		semaforo = new Semaphore(lim);
		
		// Laço FOR para começar as Threads
		for(int i = 1; i <= 21; i++) {
			ThreadsController thread = new ThreadsController(i, semaforo);
			thread.start();
		}

	}

}
