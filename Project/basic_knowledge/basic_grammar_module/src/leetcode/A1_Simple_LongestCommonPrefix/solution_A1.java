package leetcode.A1_Simple_LongestCommonPrefix;

public class solution_A1 {
    public static String longestCommonPrefix(String[] strs) {
        // 如果字符串数组长度为0
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 假定第一个元素本身就为最长公共前缀
        String commPrefix = strs[0];
        // 遍历比较剩下的元素
        for (int i = 1; i < strs.length; i++) {
            // 获取两个元素长度的较小那一值
            int length = Math.min(commPrefix.length(), strs[i].length());
            // 从每个元素的第一个字符开始比较
            int index = 0;
            // 如果当前索引对应的字符相等，继续比较下一个字符
            while (index < length && commPrefix.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            // 更新公共前缀
            commPrefix = strs[i].substring(0, index);
        }
        return commPrefix;
    }
}
