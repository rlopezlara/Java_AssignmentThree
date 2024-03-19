package rodrigolopez_sec003_ex01;
public class CarLoanCalculator implements Runnable {

    private double loanAmount;
    private double interestRate;
    private int duration;

    public CarLoanCalculator(double loanAmount, double interestRate, int duration) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.duration = duration;
    }

    public String calculateFinalAmount() {

        double monthlyInterestRate = interestRate / 100 / 12;


        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -duration));


        double finalAmount = monthlyPayment * duration;

        return String.format("$%.2f", finalAmount);
    }


    @Override
    public void run() {

        System.out.println(calculateFinalAmount());

    }
    }
