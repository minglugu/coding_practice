
// description: 二维数组，每行和每列都是递增的。从中的查找,是否存在某个整数
// URL：https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e?answerType=1&f=discussion
import java.util.*;

public class Array2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param target int整型
     * @param array int整型二维数组
     * @return bool布尔型
     */
    public boolean Find (int target, int[][] array) {
        if (array == null) {
            return false;
        }

        // write code here
        int i = 0; // 第一行, row index
        int j = array[0].length - 1; // 最后一列, column index

        // 数据的合法下标
        while (i < array.length && j >=0) {
            // delete column j, moving to the left column
            if (target < array[i][j]) {
                j--;
            } else if (target > array[i][j]) {
                // delete row i, moving to the next row
                i++;
            } else {
                return true;
            }
        }

        return false;
    }
}