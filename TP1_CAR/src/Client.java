import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket as = null;
		try{
			as = new Socket(InetAddress.getLocalHost(),4000);
			System.out.println("Client : Connection established");
			DataOutputStream out = new DataOutputStream(as.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(as.getInputStream()));
			String sentence = "Vive la France !\n";
			out.writeBytes(sentence);
			System.out.println("Message Sent");
			String response = in.readLine();
			System.out.println("Message received : "+response);
			as.close();
		} catch (UnknownHostException e) {
			System.exit(-1);
		} catch (IOException e){
			System.exit(-1);
		}
	}

}