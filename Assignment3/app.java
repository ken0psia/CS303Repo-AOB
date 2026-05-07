package Assignment3;
/*TODO: enqueue to the rear and dequeue from the front
 TODO: 

*/

    
public class app {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        System.out.println("With an empty queue head is [poll()]: " + q.poll());
        q.offer(3); //0
        q.offer(7); //1
        q.offer(24); //2
        q.offer(13); //3
        q.offer(8); //4
        q.offer(77); //5
        q.offer(35); //6
        q.offer(49); //7
        q.offer(24); //8 - SECOND OCCURRENCE OF 24
        q.offer(9); //9

        System.out.println("\n\nBEFORE SORTING: " + q.toString());
        System.out.println("The second occurrence of 24: " + q.contains(24)); //8
        q.insertionSort();
        System.out.println("AFTER SORTING: " + q.toString());
        q.moveToEnd();
        System.out.println("Size of queue: " + q.size());
        System.out.println("After moving front element to end: " + q.toString());
        q.clear();
        System.out.println("After clearing the queue, is the queue empty? -- " + q.isEmpty());
    }
}

