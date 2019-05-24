package copyArquivo;

import java.io.File;
import java.io.FileNotFoundException;
/**
 * Exe��o usada para quando um arquivo de entrada n�o existe ou n�o foi encontrado
 * @author Edson
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class ArquivoNaoExistenteException extends FileNotFoundException {
	
	/**
	 * Caminho do arquivo de leitura
	 */
	private  String info;
	
	/**
	 * Exe��o que recebe um File com o caminho do arquivo de leitura
	 * @param e Objeto File com o caminho do arquivo de leitura
	 */
	public ArquivoNaoExistenteException(File e) {
		info = e.getName();
	}
	
	@Override
	public String toString() {
		return "\n O arquivo: " + info +"\n N�o foi encontrado ou � inexistente!! ";
	}
}
