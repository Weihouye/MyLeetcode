/**
 * 第四题：
 *
 * 描述：
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 *
 *
示例1
 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0

示例2
 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

 *  答案参考大神github：https://github.com/qiyuangong/leetcode/tree/master/java
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ls1 = nums1.length;
        int ls2 = nums2.length;
        int p1 = 0,p2 = 0,pos = 0;   //p1,p2,pos 分别记录nums1,nums2,allNums数组的下标
        double median = 0;   //中位数
        int[] allNums = new int[ls1 + ls2]; //创建一个新数组将nums1,nums2重新接收并排序

        while (p1 < ls1 && p2 < ls2){   //当nums1,num2有一个数组全部遍历后循环结束
            if(nums1[p1] < nums2[p2])    //当nums1最小值（即下标最小元素）< nums2最小值 时，将nums1最小值添加到allNums数组中
                allNums[pos++] = nums1[p1++];  //nums1 和 allNums 下标指针均加1
            else                         //相反同理
                allNums[pos++] = nums2[p2++];
        }

        while (p1 < ls1){  //若当上一轮循环结束后，nums1未遍历完全，则将nums1中元素挨个添加到allNums中
            allNums[pos++] = nums1[p1++];
        }

        while (p2 < ls2){  //若当上一轮循环结束后，nums2未遍历完全，则将nums2中元素挨个添加到allNums中
            allNums[pos++] = nums2[p2++];
        }

        if ((ls1 + ls2) % 2 == 1)    //元素总数为奇数
            median = allNums[(ls1 + ls2)/2];
        else  //总数为偶数
            median = (allNums[(ls1 + ls2)/2] + allNums[(ls1 + ls2)/2 - 1]) / 2.0;

        return median;
    }
}