package rodrigolopez_sec003_ex01;

import java.math.BigInteger;

public class Factorial implements Runnable {
    private BigInteger num;
    private BigInteger result;

    public Factorial(int num) {
        this.num = BigInteger.valueOf(num);
    }

     

	private static BigInteger factorial(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return BigInteger.ONE;
        } else {
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));
        }
    }
	public BigInteger getResult() {
        return result;
    }
    @Override
    public void run() {
        result = factorial(num);
        return;
    }
}


