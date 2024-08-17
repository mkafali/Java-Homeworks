package HOMEWORK;
//Bag Class
public class Bag<T> implements IBag<T> {
    private static int DEFAULT_CAPACITY = 100;
    private T[] bag;
    private int itemCount;


    public Bag() {
        this(DEFAULT_CAPACITY);
    }

    
    @SuppressWarnings("unchecked")
    public Bag(int capacity) {
        bag = (T[]) new Object[capacity];
        itemCount = 0;
    }

    
    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            doubleCapacity(); //First, check whether a space exists in the bag. If not, make the bag size double.
        }
        bag[itemCount] = newEntry;
        itemCount++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return itemCount == 0;
    }

    @Override
    public boolean isFull() {
        return itemCount >= bag.length;
    }

    @Override
    public T removeByIndex(int index) {
        if (index < 0 || index >= itemCount) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        T removedItem = bag[index];
        bag[index] = bag[itemCount - 1];
        bag[itemCount - 1] = null; //Basically replace removedItem with last item, so removedItems would be removed. Then, make the last item null.
        itemCount--;
        return removedItem;
    }

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index >= 0) {
            removeByIndex(index);
            return true;
        }
        return false; //index<0 means anEntry does not exist in bag. So it returns false.
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Bag is empty!");
        }
        T removedItem = bag[itemCount-1];
        removeByIndex(itemCount - 1);
        return removedItem;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (int i = 0; i < itemCount; i++) {
            if (bag[i].equals(anEntry)) {
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    public int getIndexOf(T anEntry) {
        for (int i = 0; i < itemCount; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1; //If anEnty does not exist in the bag, it returns -1. Since -1<0, it helps us in other methods.
    }

    @Override
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) >= 0;
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] emptyArray = (T[]) new Object[DEFAULT_CAPACITY];
        bag = emptyArray; 
        itemCount = 0; //create new bag which capacity is DEFAULT_CAPACITY which is 100, and reset itemCount.
    }

    @Override
    public void displayItems() {
        for (int i = 0; i < itemCount; i++) {
            System.out.print(bag[i] + " "); //It place a space between each bag element, then print them.
        }
    }

    public T[] getBag() {
        return bag;
    }

    @Override
    public int getCurrentSize() {
        return itemCount;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[itemCount];
        for(int index=0; index<itemCount; index++){
            result[index] = bag[index];
        }
        return result; //It returns copy of bag.
    }
    
    public void doubleCapacity(){
            @SuppressWarnings("unchecked")
            T[] result = (T[]) new Object[2*itemCount];
            System.arraycopy(bag, 0, result, 0, itemCount); //Make bag's size double.
            bag = result;
    }
}

