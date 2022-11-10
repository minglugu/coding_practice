// https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&ru=/exam/oj
// 旋转数组的最小数字

// 题解：https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&ru=/exam/oj

public class Array3 {
    // not matter how rotating the array, the first and second half of arrays are in descending order(非递减)
    // 1 2 3 4 5   --> 5 1 2 3 4
    //             --> 4 5 1 2 3
    // 本质上是，最小值是靠近 二分之一的前半部分还是后半部分
    // 用二分查找的方法
    public int minNumberInRotateArray(int [] array) {
        // 特殊情况判断
        if (array.length== 0) {
            return 0;
        }
        // 左右指针i j
        int left = 0, right = array.length - 1;
        // 循环
        while (left < right) {
            // 找到数组的中点 m
            int m = (left + right) / 2;
            // m在左排序数组中，旋转点在 [m+1, j] 中
            if (array[m] > array[right]) {
                left = m + 1;
            }else if (array[m] < array[right]) {
                // m 在右排序数组中，旋转点在 [i, m]中
                right = m;
            } else {
                // 缩小范围继续判断
                right--;
            }
        }
        // 返回旋转点
        return array[right];
    }
}
