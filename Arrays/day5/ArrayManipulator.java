import java.util.*;

class ArrayManipulator {
    // Method to rearrange elements so that positives and negatives alternate
    public int[] rearrangeBySign(int[] A, int n) {
     ArrayList<Integer> pos = new ArrayList<>();
     ArrayList<Integer> neg = new ArrayList<>();
     
     for(int i : A)
     {
         if(i > 0)
         {
             pos.add(i);
         }
         else{
             neg.add(i);
         }
     }
     
     for(int i=0;i<n/2;i++)
     {
         A[2*i] = pos.get(i);
         A[2*i+1] = neg.get(i);
         
     }
     
     return A;
}

    public static void main(String[] args) {
        int[] A = {1, 2, -4, -5};
        int n = A.length;

        ArrayManipulator obj = new ArrayManipulator();
        int[] result = obj.rearrangeBySign(A, n);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}