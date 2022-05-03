package leetcode.A5_Simple_SearchInsert;
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
返回它将会被按顺序插入的位置(索引值)。
 */
public class A5_Simple_SearchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,6};
        int target = 7;
        System.out.println(solution_A5.searchInsert(nums,target));
    }
}
