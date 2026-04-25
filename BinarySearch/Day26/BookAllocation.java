/*
KEYNOTE: Binary search on max pages [max(arr), sum(arr)].
Check if we can allocate to m students: keep adding pages 
until sum exceeds max, then create new student.
Find minimum largest sum among all students.
*/

public class BookAllocation {
    public static void main(String[] args) {
        int[] pages = {10, 20, 30, 40};
        int students = 2;
        System.out.println("Minimum largest sum: " + findPages(pages, students));
    }
    
    public static int findPages(int[] pages, int students) {
        if (students > pages.length) {
            return -1;
        }
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for (int page : pages) {
            low = Math.max(low, page);
            high += page;
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (isPossible(pages, students, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static boolean isPossible(int[] pages, int students, int maxPages) {
        int studentCount = 1;
        int currentSum = 0;
        
        for (int page : pages) {
            if (currentSum + page > maxPages) {
                studentCount++;
                currentSum = page;
                if (studentCount > students) {
                    return false;
                }
            } else {
                currentSum += page;
            }
        }
        return true;
    }
}