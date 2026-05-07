package Assignment2;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class arrayListStack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T data) {
        stack.add(data); //end of the list == top of the stack
    }
    
    public T pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.remove(stack.size() - 1); 
    }
    
    public T peek() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public double average() {
        if (stack.isEmpty()) throw new EmptyStackException();
        double sum = 0;
        for (T element : stack) {
            if (element instanceof Number) {
                sum += ((Number) element).doubleValue();
            } else {
                throw new IllegalArgumentException(); //triggered when non-numeric data is found
            }
        }
        return sum / stack.size();
    }
}
