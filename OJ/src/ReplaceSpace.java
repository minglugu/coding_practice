// https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
import java.lang.*;

public class ReplaceSpace {

    public static String replaceSpace1(String s) {
        String newStr = s.replace(" ", "%20");

        System.out.println(newStr);
        return s;
    }

    public static String replaceSpace2(String s) {
        // use StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        char[] strTochar  = s.toCharArray();

        for (char c: strTochar) {
            stringBuilder.append( c == ' '? "%20" : c);
        }
        String newStr = stringBuilder.toString();
        System.out.println(newStr);
        return newStr;
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We are happy!");
        replaceSpace3(stringBuffer);
    }

    // 降低时间复杂度和空间复杂度
    // 有同学问了，为什么要从后向前填充，从前向后填充不行么？
    //
    //从前向后填充就是O(n^2)的算法了，因为每次添加元素都要将添加元素之后的所有元素向后移动。
    //
    //其实很多数组填充类的问题，都可以先预先给数组扩容带填充后的大小，然后在从后向前进行操作。
    //
    //这么做有两个好处：
    //
    //不用申请新数组。
    //从后向前填充元素，避免了从前先后填充元素要来的 每次添加元素都要将添加元素之后的所有元素向后移动。
    //时间复杂度，空间复杂度均超过100%的用户。
    //
    //作者：carlsun-2
    //链接：https://leetcode.cn/problems/ti-huan-kong-ge-lcof/solution/cshuang-100dong-hua-zhan-shi-xiang-xi-zhu-shi-by-c/
    //来源：力扣（LeetCode）
    public static String replaceSpace3(StringBuffer s) {
        int count = 0;
        int oldLength = s.length();
        for (int i = 0; i < oldLength; i++) {
            if(s.charAt(i) == ' ') {
                count++;
            }
        }

        int new_length = oldLength + 2 * count;
        int old_end_index = oldLength - 1;
        int new_end_index = new_length - 1;
        s.setLength(new_length);

        while(old_end_index > 0 && new_end_index > 0) {
            if(s.charAt(old_end_index) == ' ') {
                // 从后往前插入
                s.setCharAt(new_end_index--, '0');
                s.setCharAt(new_end_index--, '2');
                s.setCharAt(new_end_index--, '%');
                old_end_index--;
            } else {
                s.setCharAt( new_end_index, s.charAt(old_end_index));
                new_end_index--;
                old_end_index--;
            }
        }
        System.out.println(s.toString());
        return s.toString();
    }
}
