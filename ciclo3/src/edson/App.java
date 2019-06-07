package edson;


import static edson.Imc.calcularImc;
import static edson.ValidaNumeroFloat.validarFloat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class App {
	
	private static boolean condicao = false;
	
	enum Dados {
		ALTURA,
		MASSA
	}

	public static void main(String[] args) {
		
		DecimalFormat formataNumero = new DecimalFormat("00.00");
		
		List<Object> lista = new ArrayList<>();
		
		String temp = null;
		
		String result = null;
		
		float altura = 0;
		
		float massa = 0;
		
		float imc = 0;
		
		while(!condicao) {
			temp = JOptionPane.showInputDialog(null,"Informe sua massa (Kg): ","Calculo do Índice de Massa Corporal (IMC)",JOptionPane.QUESTION_MESSAGE);
			
			massa = validarFloat(temp);
			
			condicao = validarValores(massa, Dados.MASSA);
		}
		
		condicao = false;
		
		while(!condicao) {
			temp = JOptionPane.showInputDialog(null,"Informe sua altura (m): ","Calculo do Índice de Massa Corporal (IMC)",JOptionPane.QUESTION_MESSAGE);
			
			altura = validarFloat(temp);
			
			
			condicao = validarValores(altura, Dados.ALTURA);
		}
		
		lista = calcularImc(massa, altura);	
		
		
		
		imc = (float) lista.get(0);
		result = (String) lista.get(1);
		
		JOptionPane.showMessageDialog(null, "IMC: " + formataNumero.format(imc) + "\nClassificação: " + result, "Resultado do IMC",JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	
	public static boolean validarValores(float valor, Dados mensage) {
		if(mensage == Dados.ALTURA) {
			if(valor <= 0L) {
				JOptionPane.showMessageDialog(null,"Altura menor ou igual 0\nInforme novamente.","Aviso!!!",JOptionPane.WARNING_MESSAGE);
			}
			else if (valor > 2.50) {
				JOptionPane.showMessageDialog(null,"Altura está acima do permitido para este programa\nInforme novamente.","Aviso!!!",JOptionPane.WARNING_MESSAGE);
			}
			else {
				return true;
			}
			return false;
		}
		else if(mensage == Dados.MASSA) {
			if(valor <= 0L) {
				JOptionPane.showMessageDialog(null,"Massa menor ou igual 0\nInforme novamente.","Aviso!!!",JOptionPane.WARNING_MESSAGE);
			}
			else if (valor > 1000L) {
				JOptionPane.showMessageDialog(null,"Massa está acima do permitido para este programa\nInforme novamente.","Aviso!!!",JOptionPane.WARNING_MESSAGE);
			}
			else {
				return true;
			}
			return false;
		}
		return false;
	}

}