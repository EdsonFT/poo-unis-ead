package edson;

import javax.swing.JOptionPane;

/**
 * Classe que converte e valida uma String para um n�mero float
 * @author Edson
 * @version 1.0.0
 */
public abstract class ValidaNumeroFloat {
	
	/**
	 * O m�todo converte a string para um valor n�merico float e ferifica se o mesmo � v�lido
	 * Caso o valor na String seja vazia, inexistente ou contenha uma valor que n�o possa ser convertido em valor n�merico, ent�o � retornado uma mensagem e encerrado o programa para o usu�rio
	 * @param temp String que cont�m um valor n�merico que caiba em um tipo float
	 * @return Retorna um n�mero do tipo float
	 */
	public static float validarFloat(String temp) {
		
		if(temp != null) {
			temp = temp.replaceAll(",","\\.");
			try {
			return Float.parseFloat(temp);
			}catch (NumberFormatException e) {
				if(e.getMessage() == "empty String") {
					JOptionPane.showMessageDialog(null, "Falha: Voc� n�o preencheu o campo com algum valor","!!!Aviso!!!",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Falha: Voc� preencheu o campo com um valor invalido","!!!Aviso!!!",JOptionPane.ERROR_MESSAGE);
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
