package Assignment2;

public class main {
    public static void main(String[] args)  {
        arrayListStack<Integer> stack = new arrayListStack<>();
        System.out.println("Stack is empty: " + stack.isEmpty()); //expect: true
        stack.push(10);
        stack.push(32);
        stack.push(3);
        stack.push(83);
        System.out.println("Top element removed (pop): " + stack.pop()); //expect: 83
        System.out.println("Peeking new top element: " + stack.peek()); //expect: 3
        System.out.println("Average of values in stack: " + stack.average()); //expect: (45/3) = 15.0 (double)
    }
}