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
		// La pile représente l'état, elle permet des opération sur le résultat
		// de l'opération précédente.
		int pile = 0;

		try {
			ps = new ServerSocket(4000);
			Socket as = ps.accept();
			System.out.println("Connection established");
			while (true) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						as.getInputStream()));
				DataOutputStream out = new DataOutputStream(
						as.getOutputStream());
				String msg = in.readLine();
				System.out.println("Message received : " + msg);

				if (!msg.equals("end")) {
					String[] tab = msg.split(" ");

					if (tab.length == 3) {
						Operateur operateur = new Operateur(tab[0]);
						pile = operateur.calc(Integer.parseInt(tab[1]),
								Integer.parseInt(tab[2]));
					} else if (tab.length == 2) {
						Operateur operateur = new Operateur(tab[0]);
						pile = operateur.calc(pile, Integer.parseInt(tab[1]));
					}
					String sentence = pile + "\n";
					out.writeBytes(sentence);
				} else {
					System.out.println("fin des operations");
					as.close();
					break;
				}
				System.out.println("Réponse has been sent");
			}
		} catch (IOException e) {
			System.out.println("IOException server" + e);
			System.exit(-1);
		} catch (ArithmeticException e) {
			System.out.println("Division par zéro interdite !");
			System.exit(-1);
		}
	}

}
