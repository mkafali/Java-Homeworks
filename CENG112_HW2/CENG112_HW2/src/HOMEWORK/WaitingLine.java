package HOMEWORK;

public class WaitingLine<T> implements QueueInterface<T>{
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 1000;

    public WaitingLine(){
        this(DEFAULT_CAPACITY);
    }

    public WaitingLine(int initialCapacity){
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        initialized = true;
    }

    public void enqueue(T newEntry) {
        checkInitialization();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    public T dequeue() throws EmptyQueueException {
        checkInitialization();
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return front;
        }
    }

    public T getFront() throws EmptyQueueException {
        checkInitialization();
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            return queue[frontIndex];
        }
    }

    public boolean isEmpty() {
        return frontIndex == (backIndex + 1) % queue.length;
    }

    public void clear() throws EmptyQueueException {
        while (!isEmpty()) {
            dequeue();
        }
    }

    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize - 1);
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

    public void checkCapacity(int capacity){
        if(capacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a queue whose capacity exceeds allowed capacity.");
        }
    }

    public void checkInitialization(){
        if(!initialized){
            throw new SecurityException("Queue is not initialized properly");
        }
    }

    public String toString(){
        int tempFront = frontIndex;
        T[] tempQueue = queue;
        String result = "";
        int numberOfRoom = 0;
        for(int i = 0; i < tempQueue.length - 1 ; i++){
            if (queue[tempFront] != null){
            String element = tempQueue[tempFront].toString();
            tempFront = (tempFront + 1)%tempQueue.length;
            result = result + element;
            result += "\n";
            numberOfRoom ++;
        }}
        if(numberOfRoom == 0){
            result = "Waiting Line is Empty\n";
        }
        return result;
    }


}































