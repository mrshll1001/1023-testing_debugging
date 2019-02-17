//Author - Student 8

//Name - Project1

public class TaxCalculator {

	public static double getTax(double income){ // This method calculates and returns the tax

		double actualtax = 0;

		if(income <= 100){

			actualtax = 0;

		}

		else if(income <= 150){

			actualtax = 0.1 *(income - 100); // 10 precent tax applied to the income that is over 101

		}

		else if(income <= 200){

			actualtax = 0.1 * 50 + 0.2 *(income - 150); // same as before, as the incomes increase more tax gets applied to the remaining income

		}

		else if(income <= 300){

			actualtax = 0.1 * 50 + 0.2 * 50 + 0.4 *(income - 200); // i apply the different tax for each additional 50

		}

		else if(income <= 400){

			actualtax = 0.1 * 50 + 0.2 * 50 + 0.4 * 100 + 0.6 *(income - 300); // the 100's i use here are just 2 50's, because of how the tax applies.

		}

		else if(income >= 401){

			actualtax = 0.1 * 50 + 0.2 * 50 + 0.4 * 100 + 0.6 * 100 + 1.2 *(income - 400);

		}

		return actualtax;

	}

}
