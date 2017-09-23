/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hamzahafeez_lab1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hamza
 */
public class MatrixTest {
    
    public MatrixTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

     //Functional Requirements start here

    /**
     * Test of MatrixSum method, of class Matrix.
     */
   
   
    
    @org.junit.Test
    public void testMatrixSum() {   
        System.out.println("MatrixSum");
        
        //Two Randomized Matrices
        Matrix M2 = new Matrix(3,3,"A");
        M2.randMatrix();
        int[][] m2Matrix = M2.getMatrixArray();
        
        
        Matrix instance = new Matrix(3,3,"A");
        instance.randMatrix();
        int[][] instMatrix = instance.getMatrixArray();
        
        
        int expResult = instMatrix[1][1] + m2Matrix[1][1];  //Tesitng for the center row nad column 
        
        Matrix result = instance.MatrixSum(M2);     //Running the Method
        
        assertTrue(expResult == result.getPositionValue(1,1));  //Test if matrices returned are equal
        //assertEquals(1, 1);
    }

    /**
     * Test of MatrixSub method, of class Matrix.
     */
    @org.junit.Test
    public void testMatrixSub() {
        System.out.println("MatrixSub");
        
        Matrix M2 = new Matrix(3,3,"A");
        M2.randMatrix();
        int[][] m2Matrix = M2.getMatrixArray();
        
        
        Matrix instance = new Matrix(3,3,"A");
        instance.randMatrix();
        int[][] instMatrix = instance.getMatrixArray();
        
        
        int expResult = instMatrix[1][1] - m2Matrix[1][1];  //Tesitng for the center row nad column 
        
        Matrix result = instance.MatrixSub(M2);     //Running the Method
        
        assertTrue(expResult == result.getPositionValue(1,1));  //Test if matrices returned are equal
        
    }

    /**
     * Test of MatrixProduct method, of class Matrix.
     */
    @org.junit.Test
    public void testMatrixProduct() {
        System.out.println("MatrixProduct");
        
        Matrix M2 = new Matrix(3,3,"B");
        M2.randMatrix();
        int[][] m2Matrix = M2.getMatrixArray();
        
        Matrix instance = new Matrix(3,3,"A");
        instance.randMatrix();
        int[][] instMatrix = instance.getMatrixArray();
        
        int expResult = instMatrix[1][1] * m2Matrix[1][1];
        Matrix result = instance.MatrixProduct(M2);
        
        assertEquals(expResult, result.getPositionValue(1, 1));
    }

    /**
     * Test of MatrixMulitplication method, of class Matrix.
     */
    @org.junit.Test
    public void testMatrixMulitplication() {
        System.out.println("MatrixMulitplication");
        Matrix M2 = new Matrix(2,2,"B");   //Using a 2x2 Matrix 
        M2.randMatrix();
        int[][] m2Matrix = M2.getMatrixArray();
                
                
        Matrix instance = new Matrix(2,2,"A");
        instance.randMatrix();
        int[][] instMatrix = instance.getMatrixArray();
        
        //Equating the value of 1st Row, 1st Column element of the resultant matrix
        int expResult = (instMatrix[0][0]*m2Matrix[0][0]) + (instMatrix[0][1]*m2Matrix[1][0]);
        
        Matrix result = instance.MatrixMulitplication(M2);
   
        assertEquals(expResult, result.getPositionValue(0, 0));
        
    }

    /**
     * Test of MatrixTranspose method, of class Matrix.
     */
    @org.junit.Test
    public void testMatrixTranspose() {
        
        //We shall check this by
        //Checking values after interchaning the rows and columns
        
        System.out.println("MatrixTranspose");
        Matrix instance = new Matrix(3,3,"A");
        instance.randMatrix();
        int[][] instMatrix = instance.getMatrixArray();
        
        int expResult =  instMatrix[0][1];  //First Row, Second Column 
        Matrix result = instance.MatrixTranspose();
        
        assertEquals(expResult, result.getPositionValue(1,0));  //2nd Row, 1st Column  
        //If transposed correctly: Order shoud be interchanged     
    }
    
}//End of Functional Requiremnts
