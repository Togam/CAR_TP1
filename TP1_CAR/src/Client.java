import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author six
 * 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket as = null;
		try {
			as = new Socket(InetAddress.getLocalHost(), 4000);
			System.out.println("Client : Connection established");
			while (true) {
				DataOutputStream out = new DataOutputStream(
						as.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(
						as.getInputStream()));
				BufferedReader line = new BufferedReader(new InputStreamReader(
						System.in));

				String sentence = line.readLine() + "\n";
				
				if (sentence.equals("end\n")) {
					System.out.println("fin des operations");
					out.writeBytes("end");
					as.close();
					break;
				} else {
					out.writeBytes(sentence);
					System.out.println("Message Sent");
					String response = in.readLine();
					if (response != null){
					
					System.out.println("Message received : " + response);
					} else {
						System.out.println("division par 0 interdite");
						as.close();
						break;
					}
				}
			}
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException client" + e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("IOException client" + e);
			System.exit(-1);
		} 
	}

}
