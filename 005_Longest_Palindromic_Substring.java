/**
 * 第五题：
 *
 * 描述：
  给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000

 *
 *
示例1
 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。

 则中位数是 2.0

示例2
 输入: "cbbd"
 输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

 *  答案参考大神github：https://github.com/qiyuangong/leetcode/tree/master/java
 */

class Solution {
    public String longestPalindrome(String s){
        String longest = "";

        for(int i=0;i<s.length();i++){
            //中心节点法  xbabx 中心对称型
            String str1 = expandAroundCenter(s,i,i);
            //中心节点法  xbbx 间隔对称型
            String str2 = expandAroundCenter(s,i,i+1);

            String tempStr = str1.length() > str2.length() ? str1 : str2;
            longest = longest.length() >= tempStr.length() ? longest : tempStr;
        }

        return longest;
    }

    private static String expandAroundCenter(String s,int left,int right){
        int l = left,r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r-1+1);
    }
}