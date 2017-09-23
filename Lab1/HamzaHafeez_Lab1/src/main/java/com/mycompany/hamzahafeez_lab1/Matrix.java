/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hamzahafeez_lab1;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author hhafeez.bscs15seecs
 */
public class Matrix {
    
    private String matrixName;
    private int numRows;
    private int numCols;
    private int[][] matrix;
   
  public Matrix(int rows, int cols, String name)
  {
     numRows = rows;
     numCols = cols;
     matrixName = name;
     matrix = new int[numRows][numCols];    //Instantiating the Matrix 
  }
  
  public Matrix() {
	// TODO Auto-generated constructor stub
}

  public void setVariables(int rows, int cols, String name)
  {
     numRows = rows;
     numCols = cols;
     matrixName = name;
     matrix = new int[numRows][numCols];    //Instantiating the Matrix 
	  
  }

public String getMatrixName() 
  {
	return matrixName;
  }

 public int getNumRows() 
  {
    return numRows;
  }

  public int getNumCols() 
  {
        return numCols;
  }
  
  public int[][] getMatrixArray()
  {
      return matrix;
  }
  public int getPositionValue(int m, int n)
  {
      return matrix[m][n];
  }
  public void setMatrixName(String matrixName) 
  {
	this.matrixName = matrixName;
  }
  
  public void displayMatrix()	//Displaying the matrix
  {
      for (int i = 0; i < this.numRows;i++)
      {
          for (int j=0; j < this.numCols; j++)
            System.out.print(matrix[i][j] + " "); 
            System.out.println("");
      }

  }
  
  public void randMatrix()	//Set the values of Matrix as Random Values
  {
      for (int i = 0; i < this.numRows; i ++)
      {
          for(int j = 0; j< this.numCols; j++)
              this.matrix[i][j] = ThreadLocalRandom.current().nextInt(0,101);	//Assigning Values to Matrix Coordinates
      }
  }

  public Matrix MatrixSum(Matrix M2)	//Matrix Sum
  {
	 Matrix M1 = this;	//Callee Matrix to avoid use of this multiple times
	 
	// Matrix resultant = null;	//Initially Null
	 
	 if(M1.numRows != M2.numRows || M1.numCols != M2.numCols)
	 {
             System.out.println("Matrix Dimension must be same for Addition");
             return null;	//Return Null Matrix
	 }
	 else
	 {
             Matrix Resultant = new Matrix(M1.numRows, M1.numCols, "Resultant Matrix");

             for (int i = 0; i < numRows; i++)
                for (int j = 0; j < numCols; j++)
                    Resultant.matrix[i][j] = M1.matrix[i][j] + M2.matrix[i][j];


             return Resultant;	//Returning the Resultant Matrix
	 }
	 
	 
  }
  
  public Matrix MatrixSub(Matrix M2) 	//Matrix Subtraction
  {
      Matrix M1 = this;	//Calling Matrix to avoid use of this multiple times

    // Matrix resultant = null;	//Initially Null

     if(M1.numRows != M2.numRows || M1.numCols != M2.numCols)
     {
         System.out.println("Matrix Dimension must be same for Subtraction");
         return null;	//Return Null Matrix
     }
     else
     {
         Matrix Resultant = new Matrix(M1.numRows, M1.numCols, "Resultant Matrix");

         for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++)
                Resultant.matrix[i][j] = M1.matrix[i][j] - M2.matrix[i][j];


         return Resultant;	//Returning the Resultant Matrix
     }


  }
   
  public Matrix MatrixProduct(Matrix M2)	//Matrix Multiplication
  {
      Matrix M1 = this;	//Calling Matrix to avoid use of this multiple times
		 
    // Matrix resultant = null;	//Initially Null

     if(M1.numRows != M2.numRows || M1.numCols != M2.numCols)
     {
         System.out.println("Matrix Dimension must be same for Matrix Product");
         return null;	//Return Null Matrix
     }
     else
     {
         Matrix Resultant = new Matrix(M1.numRows, M1.numCols, "Resultant Matrix");

         for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++)
                Resultant.matrix[i][j] = M1.matrix[i][j] * M2.matrix[i][j];

         return Resultant;	//Returning the Resultant Matrix
     }


  }
  
  public Matrix MatrixMulitplication(Matrix M2) 	//Scalar Multiplicaiton
  {
	  Matrix M1 = this;	//Calling Matrix to avoid use of this multiple times
		 
        // Matrix resultant = null;	//Initially Null

         if(M1.numCols != M2.numRows )
         {
             System.out.println("Columns of 1st Matrix should be equal to Rows of 2nd Matrix");
             return null;	//Return Null Matrix
         }
         else
         {
             Matrix Resultant = new Matrix(M1.numRows, M2.numCols, "Resultant Matrix"); //Special Case for Matrix Mulitplication
             //The New Matrix takes ROWS of 1st & COLUMNS of 2nd
             for (int i = 0; i < Resultant.numRows; i++)
                for (int j = 0; j < Resultant.numCols; j++)
                    for(int  k = 0; k < M1.numCols; k++)
                            Resultant.matrix[i][j] += (M1.matrix[i][k] * M2.matrix[k][j]);;


             return Resultant;	//Returning the Resultant Matrix
         }


  }
  
  public Matrix MatrixTranspose() 	//Matrix Transpose
  {
	  Matrix transpose = new Matrix(numRows, numCols, this.getMatrixName() + "^");	//Transpose Sign added 
	 
	  for (int i = 0; i < numRows; i++)
          for (int j = 0; j < numCols; j++)
              transpose.matrix[j][i] = this.matrix[i][j];		//Changing the order of Matrix
      
	  return transpose;
  }
  
  
}
