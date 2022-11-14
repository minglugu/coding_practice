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
    // 哈希表统计法： 遍历数组 nums ，用 HashMap 统计各数字的数量，即可找出 众数 。此方法时间和空间复杂度均为 O(N)O(N) 。
    public int majorityElem1(int[] nums) {
        // hashmap<elem, frequency>
        Map<Integer, Integer> hashMap = new HashMap<>();
        int halfSize = nums.length / 2;
        // iterate the array
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                // contains the number/key, then value increase by 1
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                // do not contain the key, add the key-value pair in the hashmap
                hashMap.put(num, 1);
            }
            // compare the size and value
            if (hashMap.get(num) > halfSize) {
                return num;
            }
        }
        // Number does not exist.
        return 0;
    }

    // 先 sort，再判断。
    // 数组排序法： 将数组 nums 排序，数组中点的元素 一定为众数。
    public int majorityElem2(int[] nums) {
        Arrays.sort(nums);
        int half = nums.length / 2;
        int target = nums[half];
        int count = 0;

        for(int number : nums) {
            if(target == number) {
                count++;
            }
        }

        if(count > half) {
            return target;
        }
        return 0;
    }

    public static int majorityElem3(int[] nums) {
        /*
        1. 初始化： 票数统计 votes = 0 ， 众数 mode；
        2. 循环： 遍历数组 nums 中的每个数字 num ；
           - 当票数 votes 等于 0 ，则假设当前数字 num 是众数；
           - 当num = mode 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 ；
        3. 返回值： 返回 x 即可；

        作者：jyd
        链接：https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        */

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int mode = 0, votes = 0;
        // 疑惑的部分，mode = num，然后又判断 num == mod。
        // 答疑：当进行新的一轮 if 判定时，votes = 1 的情况下，直接进入 line 80，进行 +1 或 -1
        for(int num : nums){
            if(votes == 0) mode = num;
            votes += (num == mode ? 1 : -1);
        }
        System.out.println(mode);
        return mode;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2,2,2,5,4,2};
        majorityElem3(nums);
    }
}
