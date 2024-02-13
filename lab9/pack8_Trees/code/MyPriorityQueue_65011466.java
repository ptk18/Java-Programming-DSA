package lab9.pack8_Trees.code;

public class MyPriorityQueue_65011466 {
    MyMinHeap_65011466 heap = new MyMinHeap_65011466();
    public void enqueue(int d){
        if(!isFull())
            heap.insert(d);
    }
    public int dequeue(){
        if(!isEmpty())
            return heap.remove();
        return -1;
    }
    public int front(){
        return heap.peek();
    }
    public boolean isFull(){
        return heap.isFull();
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
    public String toString(){
        return heap.toString();
    }
}
