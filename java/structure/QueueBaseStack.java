import java.util.Stack;

/*
基于栈实现队列
*/
public class QueueBaseStack{
    private Stack<Integer> in;
    private Stack<Integer> out;

    public QueueBaseStack(){
        in=new Stack<>();
        out=new Stack<>();
    }
    //入队
    public void push(int x){
        in.push(x);
    }
    private void trans(){
        while(!in.empty()){
            out.push(in.pop());
        }
    }
    //出队
    public int pop(){
        if(out.empty()){
            trans();
        }
        return out.pop();
    }
    //获取队头元素
    public int peek(){
        if(out.empty()){
            trans();
        }
        return out.peek();
    }
    //判空
    public boolean empty(){
        if(in.empty()&&out.empty()){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        QueueBaseStack queue = new QueueBaseStack();
        for(int i=0;i<5;i++){
            queue.push(i);
        }
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.empty());
    }
}