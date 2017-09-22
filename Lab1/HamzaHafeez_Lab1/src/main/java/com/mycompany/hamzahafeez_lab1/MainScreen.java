/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hamzahafeez_lab1;

import java.io.*;
import java.util.*;

/**
 *
 * @author hhafeez.bscs15seecs
 */
public class MainScreen {

	public static Scanner myScan = new Scanner(System.in);

	static Matrix matrix1 = new Matrix();
	static Matrix matrix2 = new Matrix();

	public static void main(String args[]) {

		welcome();
	}

	public static void welcome() {
		System.out.println("Welcome to Matrix Computer");
		System.out.println("");

		while (true) {
			System.out.println("Please make your selection");

			System.out.println("1- Form Matrices");

			System.out.println("2- Exit");

			int userSelect = myScan.nextInt();

			switch (userSelect) {
			case 1:
				newMatrix();
			case 2:
				System.out.println("Thank You!");
				System.exit(0);
			default:
				System.out.println("Please Enter a Valid Number");
			}
		}

	}

	public static void newMatrix() {
		// 1st Matrix
		Scanner stringScan = new Scanner(System.in);

		System.out.println("No. of Rows: ");
		int r = myScan.nextInt();

		System.out.println("No. of Columns");
		int c = myScan.nextInt();

		System.out.println("Enter the name of Matrix");
		String mName = stringScan.nextLine();

		matrix1.setVariables(r, c, mName);
		matrix1.randMatrix();// Set Random Values for Elements of matrix

		System.out.println("New Matrix of Name: " + matrix1.getMatrixName() + " Created.");
		System.out.println("");
		System.out.println("Matrix " + matrix1.getMatrixName() + ": ");

		matrix1.displayMatrix();
		// 2nd Matrix

		System.out.println("No. of Rows: ");
		int r2 = myScan.nextInt();

		System.out.println("No. of Columns");
		int c2 = myScan.nextInt();

		System.out.println("Enter the name of Matrix");
		String m2Name = stringScan.nextLine();

		matrix2.setVariables(r2, c2, m2Name);
		matrix2.randMatrix();// Set Random Values for Elements of matrix

		System.out.println("New Matrix of Name: " + matrix2.getMatrixName() + " Created.");
		System.out.println("");
		System.out.println("Matrix " + matrix2.getMatrixName() + ": ");

		matrix2.displayMatrix(); // Display the Second Matrix

		matOperation(); // To perform Matrix Operations
	}

	public static void matOperation() {
		// Matrix resultMat = null; // Matrix Used to display results. Will be
		// initiallized via Operation Methods
		Matrix resultMatrix = new Matrix(); // In case Operation Methods does
											// not returns

		System.out.println("Please use one of the following operations in the format(matrix1 operation matrix2)");
		System.out.println("Symbols in brackets are the opertaion keys");

		while (true) {// Give OPERATION Options to the user
			System.out.println("Availaible Operations:");
			System.out.println("");
			System.out.println("Matrix Addition (+)");
			System.out.println("Matrix Subtraction (-)");
			System.out.println("Matrix Multiplication (*)");
			System.out.println("Matrix Product (#) i.e Scaler Multiplication of 2 Matrices");
			System.out.println("Matrix Transpose (^)");
			System.out.println("Enter X to exit");
			
			Scanner stringScan = new Scanner(System.in);

			String inputEquation = stringScan.nextLine(); // Input from the user

			String[] Tokens = inputEquation.split(" "); // Split based on spaces

			// First Check if any of the operands need to be taken transpose of
			
			//Meaning 1st and 2nd Operand both need to be transposed
			if (Tokens[0].indexOf("^") >= 0 && Tokens[2].indexOf("^") >= 0) 
			{
				matrix1 = matrix1.MatrixTranspose();
				matrix2 = matrix2.MatrixTranspose();
				
				System.out.println("Matrix " + matrix1.getMatrixName() + "^ : ");
				matrix1.displayMatrix();
				
				System.out.println("");
				
				System.out.println("Matrix " + matrix2.getMatrixName() + "^ : ");
				matrix2.displayMatrix();
				
			} else if (Tokens[0].indexOf("^") >= 0)
			{
				matrix1 = matrix1.MatrixTranspose();
				System.out.println("Matrix " + matrix1.getMatrixName() + "^ : ");
				matrix1.displayMatrix();
			
			} else if (Tokens[2].indexOf("^") >= 0) // Only the Second Matrix needs to be transposed
													
			{
				matrix2 = matrix2.MatrixTranspose();
				System.out.println("Matrix " + matrix2.getMatrixName() + "^ : ");
				matrix2.displayMatrix();
				
			}

			//Conditionals to check the Operation Required by the User
			if (Tokens[1].equals("+")) 
			{
				resultMatrix = matrix1.MatrixSum(matrix2);
				resultMatrix.displayMatrix();
				
			} else if (Tokens[1].equals("-"))
			{
				resultMatrix = matrix1.MatrixSub(matrix2);
				resultMatrix.displayMatrix();
				
			} else if (Tokens[1].equals("*"))
			{
				resultMatrix = matrix1.MatrixMulitplication(matrix2);
				resultMatrix.displayMatrix();
				
			} else if (Tokens[1].equals("#")) 
			{	
				resultMatrix = matrix1.MatrixProduct(matrix2);
				resultMatrix.displayMatrix();
				
			} else if(Tokens[0].equals("x") || Tokens[0].equals("X"))
			{
				System.out.println("Thank You!");
				System.exit(0);	//End the program
			}
			else
			{
				System.out.println("Invalid Operation Key Entered");
			}
		}
	}
}
