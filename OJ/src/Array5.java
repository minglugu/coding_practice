import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
// 剑指 Offer 39. 数组中出现次数超过一半的数字
// 解题思路：    1. 定义map，使用<数字，次数>的映射关系，最后统计每个字符出现的次数 （空间复杂度高）
//             2. 排序，出现次数最多的数字，一定在中间位置。然后检测中间的数字，是否 出现的次数 > 数组长度/2
//             3. 遍历数组的时候，同时去掉两个不同的数字，到最后剩下的一个数，就是该数字。如果剩下两个，那么这两个也是结果。
//             4. 摩尔投票法： 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ，为本题的最佳解法。
public class Array5 {

    // reference URL: https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-pvh8/
    public int majorityElem1(int[] nums) {
        // hashmap<elem, frequency>
        Map<Integer, Integer> hashMap = new HashMap<>();
        int halfSize = nums.length / 2;
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
            if (hashMap.get(num) > halfSize) {
                return num;
            }
        }
        return 0;
    }

    public int majorityElem2(int[] nums) {
        
    }


}
