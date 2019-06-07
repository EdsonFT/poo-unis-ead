package edson;

import java.util.ArrayList;
import java.util.List;



/**
 * Esta classe possui um m�todo est�tico capaz de calcular o �ndice de Massa Corporal de uma pessoa tendo como par�metros seu peso e sua massa corporal. 
 * @author Edson
 * @version 1.0.0
 */
public abstract class Imc {
	
	/**
	 * �ndice de Massa Corporal (IMC)
	 */
	private static float imc;
	
	/**
	 * Mensagem sobre a classifica��o da sa�de da pessoa
	 */
	private static String mensage= null;
	
	/**
	 * Realiza o c�lculo do IMC retornando um List com dois elementos.
	 * O primeiro � o pr�prio IMC
	 * O segundo � a condi��o de sa�de da pessoa.
	 * @param peso Massa corporal da pessoa
	 * @param altura Altura da pessoa
	 * @return Retorna uma lista com dois elementos, o primeiro � o IMC do tipo float e o segundo � uma String com o estado de sa�de da pessoa
	 */
	public static List<Object> calcularImc(float peso, float altura) {
		
		List<Object> lista = new ArrayList<>();
		
		imc = ((peso)/(altura*altura));
		
		lista.add(imc);
		
		if(imc < 17F) {
			mensage = "Muito abaixo do Peso";
		}
		else if(imc <= 18.49F && imc >= 17F) {
			mensage = "Abaixo do peso";
		}
		else if(imc <= 24.99F && imc >= 18.5F) {
			mensage = "Peso normal";
		}
		else if(imc <= 29.99F && imc >= 25F) {
			mensage = "Acima do peso";
		}
		else if(imc <= 34.99F && imc >= 30F) {
			mensage = "Obesidade I";
		}
		else if(imc <= 39.99F && imc >= 35F) {
			mensage = "Obesidade II(severa)";
		}
		else if(imc >= 40F) {
			mensage = "Obesidade III(m�bida)";
		}
		else {
			mensage = "ERRO";
		}
		
		lista.add(mensage);
		
		return lista;
		
	}
}
