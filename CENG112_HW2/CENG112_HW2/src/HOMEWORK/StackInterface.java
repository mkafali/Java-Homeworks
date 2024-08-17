package HOMEWORK;

public interface StackInterface<T> {
    public void push(T newEntry);
    public T pop() throws EmptyStackException;
    public T peek() throws EmptyStackException;
    public boolean isEmpty();
    public void clear() throws EmptyStackException;
}
