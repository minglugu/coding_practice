# coding_practice

##  1. 自定义异常实现登录
### 实现一个简单的控制台版用户登陆程序, 程序启动提示用户输入用户名密码. 如果用户名密码出错, 使用自定义异常的方式来处理

##  2. 二维数组中的查找：URL：https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e?answerType=1&f=discussion
### 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
- 查找的过程，本质是排除的过程。一次能够排除一批，比较有效率
- 跟bottom left的number bl，和top right 的number tr的数值比较。
- bl 是这一列里，maximum number, 是这一行里，minumum number。
  tr 是这一列里，minumum number, 是这一行里，maximum number。

  情况1.    排除整行或整列
            如果查找的值 x < tr, 将 tr 这一列的值都排除
            update tr
            剩下的还是 二维数组，如果 x > updated tr，那么 undated tr 这一行的值都排除

            临界条件：没有找到的情况下，如何写代码

## 2. 二分查找：旋转数组的最小数字。https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&ru=/exam/oj
### 把一个数组最开始的若干个元素搬到数组的末尾，称之为数组的旋转。

## 3. https://www.nowcoder.com/questionTerminal/ef1f53ef31ca408cada5093c8780f44b?answerType=1&f=discussion
### 输入整数数组，奇数位于偶数前面