public class Variable extends Expression {

	private string name;
	private double value;

	/**
	 * 
	 * @param n
	 */
	public Variable(string n) {
		// TODO - implement Variable.Variable
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param v
	 */
	public void setValue(double v) {
		this.value = v;
	}

	public double getValue() {
		return this.value;
	}

	public string toString() {
		// TODO - implement Variable.toString
		throw new UnsupportedOperationException();
	}

}