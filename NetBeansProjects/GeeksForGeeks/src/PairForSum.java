/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.HashSet;

/**
 *
 * @author vijayshrenikraj
 */
public class PairForSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here\
        
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printPairWithSum(A, n);
    }

    private static void printPairWithSum(int[] A, int n) {
        
        HashSet<Integer> list = new HashSet();
        for(int i=0;i<A.length;i++){
            list.add(A[i]);
        }
        
        for(int i=0;i<A.length; i++){
            int secondNumber = Math.abs(A[i]-n);
            if(list.contains(secondNumber)){
                System.out.println(""+A[i]+" "+secondNumber);
                return;
            }
        }
        System.out.println("No pair exists");
    }
    
}
