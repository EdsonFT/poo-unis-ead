package edson;

import javax.swing.JOptionPane;

/**
 * Classe que converte e valida uma String para um número float
 * @author Edson
 * @version 1.0.0
 */
public abstract class ValidaNumeroFloat {
	
	/**
	 * O método converte a string para um valor númerico float e ferifica se o mesmo é válido
	 * Caso o valor na String seja vazia, inexistente ou contenha uma valor que não possa ser convertido em valor númerico, então é retornado uma mensagem e encerrado o programa para o usuário
	 * @param temp String que contêm um valor númerico que caiba em um tipo float
	 * @return Retorna um número do tipo float
	 */
	public static float validarFloat(String temp) {
		
		if(temp != null) {
			temp = temp.replaceAll(",","\\.");
			try {
			return Float.parseFloat(temp);
			}catch (NumberFormatException e) {
				if(e.getMessage() == "empty String") {
					JOptionPane.showMessageDialog(null, "Falha: Você não preencheu o campo com algum valor","!!!Aviso!!!",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Falha: Você preencheu o campo com um valor invalido","!!!Aviso!!!",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
		return -1;
	}
}
