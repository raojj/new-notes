package leetcode.A5_Simple_SearchInsert;

public class solution_A5 {
    public static int searchInsert(int[] nums, int target) {
        int i =0;
        int tar=0;
        for( i = 0; i<nums.length;i++){
            if(nums[i] == target){
                tar = i;
            }
        }
        i = tar;
        //target不在数组内部
        if(tar == 0 && nums[tar] != target){
            i =0;
            while(target>nums[i] && i<nums.length-1){
                i++;
            }
            //target要插入到数组的最后的时候
            if(target>nums[nums.length-1]){
                i = nums.length;
            }
        }
        return i;
    }
}
