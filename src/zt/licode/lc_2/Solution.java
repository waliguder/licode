package zt.licode.lc_2;

public class Solution {

    /**
     * 大佬解答
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义了一个为空的头和尾节点
        ListNode head = null, tail = null;
        //定义进位参数carry
        int carry = 0;
        // 循环条件为只要任意的两个链表都不为空
        while (l1 != null || l2 != null) {
            // 如果l1为空则0，不为空则为val值
            int n1 = l1 != null ? l1.val : 0;
            // 如果l2为空则0，不为空则为val值
            int n2 = l2 != null ? l2.val : 0;
            // 计算当前同位的相加值+进位值
            int sum = n1 + n2 + carry;
            // 如果头结点为空，则初始化头尾节点都为当前相加值mod10，即获取相加后的尾数
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                // 不为空，则将尾节点的next设置为当前的计算值
                tail.next = new ListNode(sum % 10);
                // 更新当前的尾节点的地址为上次尾节点的赋值next
                tail = tail.next;
            }
            // 这个时候开始判断是否有进位，即sum会不会超过10
            carry = sum / 10;
            // 循环下一个节点
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 获取进位数值
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        // 返回整个链表结果
        return head;
    }

    /**
     * 官方解答
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 定义一个root节点作为头结点，并初始化val为0
        ListNode root = new ListNode(0);
        // 定义尾节点初始化为root，此时cursor的内存地址就是指向root
        ListNode cursor = root;
        // 定义进位的标志，初始化为0
        int carry = 0;
        // 循环有三个条件，前两个必须，后面这个为什么加上呢，如果进位不为0，也需要同样需要一次生成到尾节点的操作
        // 减少了单独判断的代码
        while(l1 != null || l2 != null || carry != 0) {
            // 如果l1为空则0，不为空则为val值
            int l1Val = l1 != null ? l1.val : 0;
            // 如果l2为空则0，不为空则为val值
            int l2Val = l2 != null ? l2.val : 0;
            // 计算当前同位的相加值+进位值
            int sumVal = l1Val + l2Val + carry;
            // 获取进位数值
            carry = sumVal / 10;
            // 新生成一个统计节点，val为相加总和 mod 10
            ListNode sumNode = new ListNode(sumVal % 10);
            // 先将统计节点放在cursor之后，一次循环cursor为root，则相当于在root后加入一个尾节点
            cursor.next = sumNode;
            // 再将统计节点设置赋值给cursor，此时cursor的指针指向了sumNode，但是sumNode此时又是root的尾节点
            // 相当于cursor又变成root的尾节点了，代码等同于cursor = cursor.next
            cursor = sumNode;
            // 循环下一个节点
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        // 由于root从0开始，所以需要返回第一个节点的next之后的链表
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l12.next = new ListNode(3);
        l1.next = l12;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        l22.next = new ListNode(4);
        l2.next = l22;

        ListNode result = addTwoNumbers(l1,l2);
        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }
    }

}
