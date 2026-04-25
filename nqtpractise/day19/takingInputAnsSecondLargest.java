import java.util.*;

class Main {
    
    public static int[] convertStrToNums(String[] arr)
    {
        int n = arr.length;
        
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i ++)
        {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return nums;   
    }
    

    public static int secondLarget(int[] nums)
    {
        int n = nums.length;
        
        if(n < 2) return -1;
        
        Arrays.sort(nums);
        return nums[n-2];
        
    }
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
    
        while(sc.hasNextLine())
        {
            String s = sc.nextLine();
            if(s.trim().isEmpty()) continue;
        
            String[] strNum = s.split(" ");
            int[] nums = convertStrToNums(strNum);

            System.out.println(secondLarget(nums));
        
        }
    
     }
}





