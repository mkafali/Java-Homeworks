package HOMEWORK;

import java.util.Arrays;

public class PileRoom<T> implements StackInterface<T> {

    private T[] stack;
    private int topIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 1000;

    public PileRoom() {
        this(DEFAULT_CAPACITY);
    }

    public PileRoom(int initialCapacity){
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;
    }

    public void checkInitialization(){
        if(!initialized){
            throw new SecurityException("Stack is not initialized properly");
        }
    }

    public void checkCapacity(int capacity){
        if(capacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a stack whose capacity exceeds allowed capacity.");
        }
    }

    public void clear() throws EmptyStackException {
        while(!isEmpty()){
            pop();
        }
    }

    public boolean isEmpty(){
        return topIndex < 0;
    }

    public T pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else {
            T topElement = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return topElement;
        }
    }

    public T peek() throws EmptyStackException{
        checkInitialization();
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            return stack[topIndex];
        }
    }

    public void push(T newEntry){
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    public void ensureCapacity(){
        if(topIndex == stack.length - 1){
            int newLength = 2*stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }



}







































