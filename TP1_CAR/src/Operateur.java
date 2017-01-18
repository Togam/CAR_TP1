/**
 * @author six
 *
 */
public class Operateur {
	private String op;

	public Operateur(final String op) {
		this.op = op;
	}

	public int calc(final int nb1, final int nb2) {
		int res = 0;
		switch (this.op) {
		case "+":
			res = nb1 + nb2;
		case "*":
			res = nb1 * nb2;
		case "/":
			res = nb1 / nb2;
		case "-":
			res = nb1 - nb2;
		}
		return res;
	}
}
