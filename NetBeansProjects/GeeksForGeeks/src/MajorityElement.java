/*
 * A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).
   I/P : 3 3 4 2 4 4 2 4 4
   O/P : 4
 */

/**
 *
 * @author vijayshrenikraj
 */
public class MajorityElement {
    public static void main(String[] args) {
        int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        findMajority(a);
    }

    private static void findMajority(int[] a) {
        int number=0 ;
        int count=0;
        for(int i=0;i<a.length;i++){
            if(count ==0){
                number = a[i];
                count=1;
            }
            else if(a[i] == number) count++;
            else count--;
        }
        
        int actualCount = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] == number) actualCount++;
        }
        
        if(actualCount > (a.length/2)){
            System.out.println(number);
        }
    }
    
}
