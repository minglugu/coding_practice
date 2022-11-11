// https://www.nowcoder.com/questionTerminal/ef1f53ef31ca408cada5093c8780f44b?answerType=1&f=discussion
// Description: odd numbers are in the front of even numbers, there are 2 scenarios
// 1. relative orders of odd and even remain the same
// 2. order does not matter

import java.util.Arrays;

public class Array4 {
    // relative order of odd and even numbers do not matter
    public static int[] reorderArray1 (int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // array[left] is odd, no swap and move 1 index to the right
            // 判断奇数和偶数的方法 array[left] & 1 == 1 --> 奇数，array[left] & 1 == 0 --> 偶数
            while((left < right) && (array[left] % 2 == 1)) {
                left++;
            }
            // array[right] is even, no swap and move 1 index to the left
            while((left < right) && (array[right] % 2 == 0)) {
                right--;
            }
            // If array[left] is even and array[right] is odd, swap.
            if(left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return array;
    }

    // relative orders of odd and even numbers matter
    // From the left to right, move the even number to the right position.
    // 从前往后，把偶数后移，腾出位置，放入奇数。奇数前插，偶数后插，所以奇数和偶数的相对位置，都不会变化
    public static int[] reorderArray2 (int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        int k = 0;
        for (int i = 0; i < array.length; i++) {
            // 从左向右，每次遇到的，都是最前面的奇数，需要放在 k 下标处
            if((array[i] & 1) == 1) { // 奇数
                int temp = array[i]; // 保存当前奇数到临时的整数变量里
                int j = i;
                while (j > k) { // 将该奇数之前的内容（偶数序列），整体后移一个位置
                    array[j] = array[j-1];
                    j--;
                }
                array[k++] = temp; // 将奇数保存在它将来的位置，因为是从左向右放的，没有跨越奇数，所以相对位置是不变的
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
        array = reorderArray1(array);
        System.out.println("=======================");
        System.out.println(Arrays.toString(array));

        int[] array2 = {3, 5, 2, 4, 6, 8, 1, 7, 9};
        System.out.println(Arrays.toString(array2));
        array2 = reorderArray2(array2);
        System.out.println("=======================");
        System.out.println(Arrays.toString(array2));
    }


}

