package chatbot;

import java.io.*;

/**
 *
 * @author kandrade
 */
public class GravarConversa {

	public static void salvar(String conteudo)
	throws IOException {
		FileWriter fw = new FileWriter("BackupConversas.txt", true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(conteudo);
		pw.flush();
		pw.close();
	}
}