package com.cjs.leetcode.length_of_longest_substring;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 这种方法性能不太好。。。leetcode上还是能通过
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (true) {
            int tlength = 1;
            rightIndex = leftIndex + 1;
            while (rightIndex < s.length()) {
                int oki = s.substring(leftIndex, rightIndex).indexOf(s.charAt(rightIndex));
                rightIndex++;
                if (oki == -1) {
                    tlength++;
                } else {
                    leftIndex = leftIndex + oki + 1;
                    maxlen = Math.max(maxlen, tlength);
                    break;
                }
            }

            if (rightIndex >= s.length()) {
                break;
            }
        }

        return Math.max(maxlen, s.length() - leftIndex);
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
