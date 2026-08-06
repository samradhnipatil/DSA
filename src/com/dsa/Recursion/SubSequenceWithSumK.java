import java.util.ArrayList;

public class SubSequenceWithSumK {

    public static void main(String[] args) {
        int[] nums = {4, 2, 10, 5, 1, 3};
        getSubSeq(nums,5,new ArrayList<>(), 0);
    }

    public static void getSubSeq(int[] nums, int target, ArrayList<Integer> ans, int ind) {
        if( target == 0){
            System.out.println(ans);
            return;
        }
        if(ind == nums.length)
            return;

        if( ind < nums.length) {
            if (nums[ind] <= target) {
                ans.add(nums[ind]);
                getSubSeq(nums, target - nums[ind], ans, ind + 1);
                ans.removeLast();
            }
            getSubSeq(nums, target, ans, ind + 1);
        }
        return;
    }
}
