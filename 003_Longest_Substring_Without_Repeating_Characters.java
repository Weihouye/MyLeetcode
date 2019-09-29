/**
 * 第三题：
 *
 * 描述：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
示例1
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例2
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例3
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

 *  答案参考大神github：https://github.com/qiyuangong/leetcode/tree/master/java
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charList = new int[256];    //ASCII 有256个字符  用一个256长度的数组映射每一个字符
        Arrays.fill(charList,-1);    //初始化数组为-1 表示均未出现
        int i = 0,maxLen = 0;  //i 用于记录上一个出现的重复字符
        for (int j=0;j<s.length();j++){
            if(charList[s.charAt(j)] >= i){  //如果某个字符的在数组中的上一个出现的重复字符的位置，则重置i
                i = charList[s.charAt(j)] + 1;   //重置i为上一个重复字符的下标加1
            }
            charList[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1,maxLen);
        }
        return maxLen;
    }
}