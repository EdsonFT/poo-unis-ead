package pacote;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("serial")
public class ListaFibonacci extends RecursiveAction {

	private int posicaoMax;
	private static AtomicInteger cont = new AtomicInteger(0);
	private static Long[] result;
	private static String resposta = "";
	
	public ListaFibonacci(int nElementos) {
		if(result == null) {
			this.posicaoMax = nElementos-1;
			result = new Long[nElementos];
		}
	}

	@Override
	protected void compute() {
		
		ListaFibonacci task = null;
		
		if(cont.get() < (posicaoMax +1)) {
			result[cont.get()] = fibonacci(cont.get());
			cont.incrementAndGet();
			task = new ListaFibonacci(posicaoMax+1);
			task.fork();	
		} else {
			
			//for(long i : result) {
			//	resposta = i + ", ";
			//}
			
			//System.out.println(resposta);
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cont.get());
	}
	
	
	public static long fibonacci(int n ) {
		if(n <= 1) {
			return n;
		}
		return fibonacci(n-2) + fibonacci(n-1);
	}

}
