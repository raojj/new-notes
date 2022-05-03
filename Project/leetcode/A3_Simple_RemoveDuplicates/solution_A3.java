package leetcode.A3_Simple_RemoveDuplicates;

public class solution_A3 {
    public static int removeDuplicates(int[] nums) {
        int index=0;
        int pointer=1;
        int tempt = 0;
        while(pointer<nums.length){
            if(nums[index] == nums[pointer]){
                index++;
                pointer++;
                tempt++;
            }else{
                index++;
                pointer++;
            }
        }
        return nums.length-tempt;
    }
}
