package edson;

import java.util.ArrayList;
import java.util.List;



/**
 * Esta classe possui um método estático capaz de calcular o Índice de Massa Corporal de uma pessoa tendo como parâmetros seu peso e sua massa corporal. 
 * @author Edson
 * @version 1.0.0
 */
public abstract class Imc {
	
	/**
	 * Índice de Massa Corporal (IMC)
	 */
	private static float imc;
	
	/**
	 * Mensagem sobre a classificação da saúde da pessoa
	 */
	private static String mensage= null;
	
	/**
	 * Realiza o cálculo do IMC retornando um List com dois elementos.
	 * O primeiro é o próprio IMC
	 * O segundo é a condição de saúde da pessoa.
	 * @param peso Massa corporal da pessoa
	 * @param altura Altura da pessoa
	 * @return Retorna uma lista com dois elementos, o primeiro é o IMC do tipo float e o segundo é uma String com o estado de saúde da pessoa
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
			mensage = "Obesidade III(móbida)";
		}
		else {
			mensage = "ERRO";
		}
		
		lista.add(mensage);
		
		return lista;
		
	}
}
