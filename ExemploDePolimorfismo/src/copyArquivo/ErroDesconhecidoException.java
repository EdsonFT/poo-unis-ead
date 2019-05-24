package copyArquivo;

import java.io.IOException;

/**
 * Exeção usada para um erro na permissão de leitura e/ou gravação de determinado arquivo
 * @author Edson
 *
 */
@SuppressWarnings("serial")
public class ErroDesconhecidoException extends IOException {
	
	@Override
	public String toString() {
	
		return "Erro interno desconhecido ou falta de permição para leitura e/ou gravação em disco";
	}
}
