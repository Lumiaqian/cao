/* 
 链表实现栈
*/
public class LinkNodeStack {
    private ListNode top = null;

    //入栈
    public void push(int val){
        ListNode node = new ListNode(val);
        //判断栈是否为空
        if(top == null){
            top = node;
        }else {
            node.next = top;
            top = node;
        }
    }

    //出栈
    public int pop(){
        if(top == null) return -1;
        int val = top.val;
        top = top.next;
        return val;
    }
    //打印栈中所有元素
    public void printAll(){
        ListNode cur = top;
        while(cur!=null){
            System.out.print(cur.val + " ");
            cur=cur.next;
        }
        System.out.println();
    }
    //栈的大小
    public int size(){
        int size = 0;
        ListNode cur = top;
        while(cur!=null){
            size ++;
            cur=cur.next;
        }
        return size;
    }

    public static void main(String[] args) {
        LinkNodeStack lStack = new LinkNodeStack();
        for(int i=0;i<10;i++){
            lStack.push(i);
        }
        int size = lStack.size();
        System.out.println("栈大小："+size);
        lStack.printAll();
        lStack.pop();
        lStack.printAll();
        size = lStack.size();
        System.out.println("栈大小："+size);
    }
}