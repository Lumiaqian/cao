/* 
 数组实现栈
*/
public class Stack {
   private int[] arr;
   private int length;
   private int top;

   //初始化
   public Stack(int x){
       this.length = x;
       arr = new int[length];
       top = -1;//空栈
   }

   //入栈
   public void push(int x){
       if(top == arr.length-1){
          System.out.println("栈满了");
          return;
       }
       arr[++top]=x;
   }
   //出栈
   public int pop(){
       if(top == -1){
           System.out.println("栈空");
           return -1;
       }
       return arr[top--];
   }
   //打印栈
   public void printAll(){
       if(top == -1){
           return;
       }
       for(int i = 0;i < top;i++){
           System.out.print(arr[i] + " ");
       }
       System.out.println();
   }
   public static void main(String[] args) {
       Stack stack = new Stack(10);
       for(int i = 0;i<10;i++){
           stack.push(i);
       }
       stack.printAll();
       stack.pop();
       stack.printAll();
   }
}