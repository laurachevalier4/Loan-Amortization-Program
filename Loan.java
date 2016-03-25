/*
 * Laura Chevalier
 * Intro to Computer Science
 * Professor Versoza
 */
import java.util.Scanner;
public class Loan {
	//Give amortization schedule for user loan
	public static void main(String[] args) {
		//Ask for loan amount, number of years, and annual interest rate
		Scanner input = new Scanner(System.in);
		System.out.println("Loan amount: ");
		double loanAmount = input.nextDouble();
		System.out.println("Number of years: ");
		int numberOfYears = input.nextInt();
		System.out.println("Annual interest rate: ");
		double annualInterestRate = input.nextDouble() / 100;
		double monthlyInterestRate = annualInterestRate / 12;
		//Calculate monthly payment
		double monthlyPayment = ((loanAmount * monthlyInterestRate) / (1.0 - 1.0 / 
				(Math.pow(1 + monthlyInterestRate, numberOfYears * 12))));
		System.out.printf("Monthly payment: $%,.2f\n", monthlyPayment);
		System.out.printf("Total Payment: $%,.2f\n\n", monthlyPayment * 12 * numberOfYears);
		System.out.println("Payment#\tInterest\tPrincipal\tBalance");
		//Calculate and print interest, principal, and balance
		for (int i = 0; i < numberOfYears * 12; i++) {
			double interest = monthlyInterestRate * loanAmount;
			double principal = monthlyPayment - interest;
			loanAmount -= principal;
			if (i == numberOfYears * 12 - 1 && loanAmount != 0) {
				principal = monthlyPayment + loanAmount;
			}
			System.out.printf((i + 1) + "\t\t" + "%,.2f\t\t%,.2f\t\t%,.2f\t\t\n", interest, principal, loanAmount);
		}
	}

}
