package NodeToArray;
// https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
// singly linked list
// 可以使用以下方法
// 1. 遍历 linked list, 入栈，再出栈
// 2. 遍历，保存到数组中，逆置，就得到了结果
// 3. recursive，递归

import java.util.ArrayList;
import java.util.Stack;

// 方法2.
public class LinkedListToArrayList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        if(listNode == null) return null;

        while(listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        if(!stack.empty()) {
            arrayList.add(stack.pop());
        }

        return arrayList;
    }

    // 给大佬补充一个递归代码，不需要重新遍历ArrayList，时间100%。
    // https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/
    
}
