import java.util.Iterator;

/**
 * An iterator class that iterates over the elements in the queue.
 */
public class IsraeliQueueIterator<E> implements Iterator<E> {
    private Node<Node<E>> current; // the current node
    private Node<E> currentFriendGroup; // the current friend group

    /**
     * Constructs an iterator with the given current node.
     * @param current the current node
     */
    public IsraeliQueueIterator(Node<Node<E>> current) {
        this.current = current;
        if (current != null) {
            this.currentFriendGroup = current.getValue();
        }
    }

    /**
     * Checks if there is a next element in the queue.
     * @return true if there is a next element in the queue, false otherwise
     */
    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    /**
     * Returns the next element in the queue.
     * @return the next element in the queue
     */
    @Override
    public E next() {
        E element = currentFriendGroup.getValue();
        if (currentFriendGroup.hasNext()) {
            currentFriendGroup = currentFriendGroup.getNext();
        }
        else {
            current = current.getNext();
            if (current != null) {
                currentFriendGroup = current.getValue();
            }
        }
        return element;
    }
}