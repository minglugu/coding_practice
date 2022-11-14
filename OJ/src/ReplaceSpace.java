// https://leetcode.cn/problems/ti-huan-kong-ge-lcof/


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
        replaceSpace2("We are happy!");
    }
}
