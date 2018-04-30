package test;

import java.util.Scanner;

import models.EquationSolver;

public class EquationSolverTester {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an equation: ");
		String input = scanner.nextLine();
		System.out.println(EquationSolver.getAnAnswer(input));
	}

}
