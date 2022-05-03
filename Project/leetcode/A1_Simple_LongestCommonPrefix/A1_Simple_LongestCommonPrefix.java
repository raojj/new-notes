package leetcode.A1_Simple_LongestCommonPrefix;
/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1：
输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀
 */
public class A1_Simple_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] test = new String[]{"flower","flow","flight"};
        System.out.println(solution_A1.longestCommonPrefix(test));
    }
}
