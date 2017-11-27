/*
 Given an array A[] and a number x, check for pair in A[] with sum as x
i/p int A[] = {1, 4, 45, 6, 10, 8};
o/p Pair with given sum 16 is (10, 6)
 */

import java.util.Arrays;
import java.util.HashSet;
/**
 *
 * @author vijayshrenikraj
 */
public class PairForSum {
    public static void main(String[] args) {
        // TODO code application logic here\
        
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        System.out.println("Using Hashset, O(N) :");
        usingHashset(A, n);
        System.out.println("Using Two Loops, O(N^2)");
        usingTwoLoops(A, n);
        System.out.println("Using Sorting, O(N Log N)");
        usingSorting(A, n);
    }

    private static void usingHashset(int[] A, int n) { 
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
    
    private static void usingTwoLoops(int [] A, int n){
        for(int i=0;i<A.length;i++){
            for(int j=i+1; j<A.length;j++){
                if(A[i]+A[j] == n){
                    System.out.println(A[i]+" "+A[j]);
                }
            }
        }
    }

    private static void usingSorting(int[] A, int n) {
        mergeSort(A, 0, A.length-1);
        int i=0, j=A.length-1;
        while(i<j){
            int tempSum = A[i]+A[j];
            if(tempSum == n){
                System.out.println(A[i]+" "+A[j]);
                return;
            } else if(tempSum > n) j--;
            else i++;
        }
    }

    private static void mergeSort(int[] A, int start, int end) {
        if(start >= end) return;
        int middle = (start+end)/2;
        mergeSort(A, start, middle);
        mergeSort(A, middle+1, end);
        merge(A, start, middle, end);
    }
    
    private static void merge(int[] A, int start, int middle, int end) {
        int n1 = middle-start+1;
        int n2 = end - middle;
        
        int []a1 = new int[n1];
        int []a2 = new int[n2];
        for(int i=0;i<n1;i++){
            a1[i]=A[i+start];
        }
        for(int i=0;i<n2;i++){
            a2[i]=A[i+middle+1];
        }
        int i=0, j=0, index=start;
        while(i<n1 && j<n2){
            if(a1[i]<=a2[j]){
                A[index] = a1[i];
                i++;
            } else {
                A[index] = a2[j];
                j++;
            }
            index++;
        }
        while(i<n1){
            A[index] = a1[i];
            index++;i++;
        }
        while(j<n2){
            A[index] = a2[j];
            index++;j++;
        }
    }
    /*
    private static void mergeSortHelper(int[] A) {
        mergeSort(A, 0, A.length);
    }

    private static void mergeSort(int[] A, int i, int j) {
        if(i==j){
            return;
        }
        
        int mid = (i+j)/2;
        int n1 = mid-i+1;
        int n2 = j-mid;
        mergeSort(A, i, mid);
        mergeSort(A, mid+1, j);
        int [] left = new int[n1];
        int [] right = new int[n2];
        for(int k=0;k<n1;k++){
            left[k] = A[k+i];
        }
        for(int k=0;k<n2;k++){
            System.out.println(k+" "+mid+" "+j);
            right[k] = A[k+mid+1];
        }
        int a = 0, b = 0, index=0;
        while(a < (n1) && b < n2){
            if(left[a] < right[b]){
                A[index] = left[a];
                a++;
            } else {
                A[index] = right[b];
                b++;
            }
        }
        while(a < n1){
            A[index] = left[a];
            a++;
            index++;
        }
        //System.out.println(j-mid);
        while(b < n2){
            A[index] = right[b];
            b++;
            index++;
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    */

    
}
