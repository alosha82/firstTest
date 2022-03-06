import lombok.SneakyThrows;
import lombok.val;

import java.util.Scanner;

public class newMain
{
    public static void main(String[] args) {
        passportChanges();
        matrixInMatrix();
        calculationTreads();
        StrangeFunction(4,3);
    }
    public static void passportChanges()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.next();
        System.out.println("Enter current passport");
        Integer currentPassport = scanner.nextInt();
        int currentPassportParsed = currentPassport;
        int[] currentPassportArray=new int[9];
        int[] newPassportArray=new int[9+1];
        for (int i = currentPassportArray.length - 1; i >= 0; i--) {
            currentPassportArray[i]=currentPassportParsed%10;
            currentPassportParsed=currentPassportParsed/10;
        }
        int digitToAdd = currentPassportArray[currentPassportArray.length-1];
        int addingIndex = newPassportArray.length-currentPassportArray[currentPassportArray.length-2];
        for (int i = newPassportArray.length - 1; i >= addingIndex; i--)
        {
            newPassportArray[i]=currentPassportArray[i-1];
        }
        newPassportArray[addingIndex-1]=digitToAdd;
        for (int i = addingIndex-2; i >= 0; i--)
        {
            newPassportArray[i]=currentPassportArray[i];
        }
        System.out.println(name);
        for (int i = 0; i < newPassportArray.length; i++) {
            System.out.print(newPassportArray[i]);
        }
    }
    public static void matrixInMatrix()
    {
//        int[][] bigMatrix={{1,2,3},{4,5,6},{7,8,9}};
//        int[][] smallMatrix={{2,3},{5,6}};
        Scanner scanner = new Scanner(System.in);
        int[][] bigMatrix=new int[40][40];
        int[][] smallMatrix=new int[10][10];
        System.out.println("Enter big matrix 40x40");
        for (int i = 0; i < bigMatrix.length; i++) {
            for (int j = 0; j < bigMatrix.length; j++) {
                bigMatrix[i][j]= scanner.nextInt();
            }
        }
        System.out.println("Enter small matrix 10x10");
        for (int i = 0; i < smallMatrix.length; i++) {
            for (int j = 0; j < smallMatrix.length; j++) {
                smallMatrix[i][j]= scanner.nextInt();
            }
        }
        System.out.println("Enter big matrix 40x40");
        int currentPassport = scanner.nextInt();
        boolean found=false;
        for (int i = 0; i < bigMatrix.length-smallMatrix.length+1; i++)
        {
            for (int j = 0; j < bigMatrix[0].length-smallMatrix[0].length+1; j++) {
                if(isContains(smallMatrix, createSmallerMatrix(i,j,smallMatrix.length,bigMatrix)))
                {
                    found=true;
                }
            }
        }
        System.out.println(found);
    }
    private static boolean isContains(int[][]matrixA,int[][] matrixB)
    {
        for (int i = 0; i < matrixA.length; i++)
        {
            for (int j = 0; j < matrixA.length; j++)
            {
                if (matrixA[i][j]!=matrixB[i][j])
                    return false;
            }
        }
        return true;
    }
    private static int[][] createSmallerMatrix(int startI, int strartJ, int smallerMatrixSize, int[][] bigMatrix)
    {
        int[][] smallerMatrix=new int[smallerMatrixSize][smallerMatrixSize];
        for (int i = 0; i < smallerMatrix.length; i++)
        {
            for (int j = 0; j < smallerMatrix[0].length; j++)
            {
                smallerMatrix[i][j]=bigMatrix[startI+i][strartJ+j];
            }
        }
        return smallerMatrix;
    }
    @SneakyThrows
    public static void calculationTreads()
    {
        val plus = new Thread(() -> System.out.println(12+3));
        val minus = new Thread(() -> System.out.println(12-3));
        val multiply = new Thread(() -> System.out.println(12*3));
        val divide = new Thread(() -> System.out.println(12/3));
        plus.start();
        minus.start();
        multiply.start();
        divide.start();
        plus.join();
        minus.join();
        multiply.join();
        divide.join();
        System.out.println("done");
    }
    public static void StrangeFunction(int x, int n)
    {
        double oddElementsSum=0;
        double evenElementsSum=0;
        for (int i = 1; i <=n; i++)
        {
            if (i%2==0)
            {
                evenElementsSum=evenElementsSum+(Math.pow(x,2*i)/factorial(i));
            }
            else
            {
                oddElementsSum=oddElementsSum-(Math.pow(x,2*i)/factorial(i));
            }
        }
        System.out.println(oddElementsSum+evenElementsSum);
    }
    private static int factorial(int factor) {
        int result = 1;
        for (int i = 1; i <= factor; i++) {
            result = result * i;
        }
        return result;
    }
}
