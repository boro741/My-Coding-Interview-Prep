import java.util.*;

class javaTest {

    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for (int i=0;i<nums.length;i++) {
            startIndex = 0;
            // if current and the previous elements are same, create new subsets only from the subsets 
            // added in the previous step
            if (i > 0 && nums[i] == nums[i - 1])
              startIndex = endIndex + 1; // Start index of previous duplicate.
                                         // Since abhi tak endIndex calculate nahi hua. So we get start index by adding 1
            
            endIndex = subsets.size() - 1;

            for (int j = startIndex; j <= endIndex; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }
    public static void main(String[] args) {
       List<List<Integer>> result;
        result = findSubsets(new int[] { 1, 3, 3 });

        //1.  Using set data structure
        //HashSet<List<Integer>> res = new HashSet<List<Integer>>(result);
        System.out.println("Here is the list of subsets: " + result);
    }
}

/*
            0   1    2      3       4       5 
Subsets:  [[], [1], [3], [1, 3], [3, 3], [1, 3, 3]]


*/