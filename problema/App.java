package pacote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;


public class App {

	public static void main(String[] args) {
		
		exercicio4();
		
	}
	
	
	public static void exercicio4() {
		
		ListaFibonacci lf = new ListaFibonacci(30);
		
		ForkJoinPool fork = new ForkJoinPool();
		fork.invoke(lf);
		fork.shutdown();
	}
	
}
