/**
 * @author six
 *
 */
public class Operateur {
	private String op;

	/**
	 * Constructeur
	 * @param op
	 */
	public Operateur(final String op) {
		this.op = op;
	}

	/**
	 * @param nb1
	 * @param nb2
	 * @return le resultar du calcul
	 */
	public int calc(final int nb1, final int nb2) {
		int res = 0;
		switch (this.op) {
		case "+":
			res = nb1 + nb2;
			break;
		case "*":
			res = nb1 * nb2;
			break;
		case "/":
			res = nb1 / nb2;
			break;
		case "-":
			res = nb1 - nb2;
			break;
		}
		return res;
	}
}
