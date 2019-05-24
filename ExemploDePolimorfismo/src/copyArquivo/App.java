package copyArquivo;

import static java.lang.System.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;


public class App {

	public static void main(String[] args) {
		
		File fInTxt = new File("leiaMe.txt");
		File finPng = new File("java-duke-guitar.png");
		File foutPng = new File("MascoteCopia.jpg");
		
		
		try (FileInputStream inTxt = new FileInputStream(fInTxt);
				PrintStream outConsole = out;){
			
			transferencia(inTxt, outConsole);
			
		} catch (FileNotFoundException e) {
			ArquivoNaoExistenteException relancando = new ArquivoNaoExistenteException(fInTxt);
			out.println(relancando.toString());
		} catch (IOException e) {
			out.println(e.toString());
		}
		
		
		try (FileInputStream inPng = new FileInputStream(finPng);
				FileOutputStream outPng = new FileOutputStream(foutPng)){
			
			transferencia(inPng,outPng);
			
		} catch (FileNotFoundException e) {
			ArquivoNaoExistenteException relancando = new ArquivoNaoExistenteException(finPng);
			out.println(relancando.toString());
		} catch (IOException e) {
			out.println(e.toString());
		}
		
	}
	
	private static void transferencia(InputStream in, OutputStream out) throws IOException {
		
		byte[] buffer = new byte[1024];
		
		int bytesLidos;
		while((bytesLidos = in.read(buffer)) > -1) {
			out.write(buffer,0,bytesLidos);
		}
	}
}
