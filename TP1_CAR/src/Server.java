import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author six
 *
 */
public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket ps = null;
		try{
			ps = new ServerSocket(4000);
			while(true){
				Socket as = ps.accept();
				System.out.println("Connection established");
				BufferedReader in = new BufferedReader(new InputStreamReader(as.getInputStream()));
				DataOutputStream out = new DataOutputStream(as.getOutputStream());
				String msg = in.readLine();
				System.out.println("Message received : "+msg);
				String[] tab = msg.split(" ");
				Operateur operateur = new Operateur(tab[0]);
				int resultat = operateur.calc(Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
				String sentence = resultat+"\n";
				out.writeBytes(sentence);
				System.out.println("Réponse has been sent");
			}
		} catch (IOException e){
			System.out.println("IOException server");
			System.exit(-1);
		}
	}

}
