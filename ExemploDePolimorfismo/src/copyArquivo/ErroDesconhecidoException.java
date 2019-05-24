package copyArquivo;

import java.io.IOException;

/**
 * Exe��o usada para um erro na permiss�o de leitura e/ou grava��o de determinado arquivo
 * @author Edson
 *
 */
@SuppressWarnings("serial")
public class ErroDesconhecidoException extends IOException {
	
	@Override
	public String toString() {
	
		return "Erro interno desconhecido ou falta de permi��o para leitura e/ou grava��o em disco";
	}
}
