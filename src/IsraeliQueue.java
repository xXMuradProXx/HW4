import java.util.Iterator;

public class IsraeliQueue<E extends Cloneable> implements Cloneable, Iterable<E> {
    private Node<Node<E>> head; // the head of the queue
    private Node<E> tail; // the tail of the queue
    private int size; // the size of the queue

    /**
     * Constructs an IsraeliQueue with no elements.
     */
    public IsraeliQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the queue. If the friend is not null, then the element is added to the friend group of the friend.
     * @param element the element to be added to the queue
     * @param friend the friend of the element that is used to find the relevant friend group
     */
    public void add(E element, E friend) {
        if (element == null) {
            throw new InvalidInputException();
        }

        Node<E> newElement = new Node<>(element); // the new element to be added to the queue
        if (this.head == null) {
            // creates the first friend group in the queue with the given element
            this.head = new Node<>(new Node<>(element));
        }
        else {
            Node<Node<E>> current = head; // the pointer to the beginning of the queue
            while (current != null) {
                Node<E> currentFriendGroup = current.getValue(); // the pointer to the beginning of the friend group
                if (currentFriendGroup.isContained(friend)){
                    currentFriendGroup.setTail(newElement); // adds the new element to the friend group
                    updateTailAndSize();
                    return;
                }
                current = current.getNext(); // moves to the next friend group
            }

            this.head.setTail(new Node<>(newElement)); // adds the new friend group to queue's end
        }

        updateTailAndSize();
    }

    private void updateTailAndSize() {
        this.tail = head.getTail().getValue().getTail(); // updates the tail of the queue
        this.size++; // updates the size of the queue
    }

    /**
     * Adds an element to the queue. Since the friend parameter is not given, a new friend group with the given element
     * will be created and added to the end of the queue.
     * @param element the element to be added to the queue
     */
    public void add(E element) {
        add(element, null);
    }

    /**
     * Removes the first element from the queue and returns it.
     * @return the first element in the queue
     */
    public E remove() {
        E element = peek();
        if (head.getValue().getNext() == null) {
            head = head.getNext(); // if there is only one element in the friend group,
            // then the queue jumps to the next group
        }
        else {
            Node<E> temp = head.getValue(); // gets the first friend group in the queue
            temp = temp.getNext(); // moves to the next element in the friend group
            head.setValue(temp); // updates the friend group in the queue
        }
        this.size--;
        return element;
    }

    /**
     * Returns the first element in the queue without removing it.
     * @return the first element in the queue
     */
    public E peek() {
        if (head == null) {
            throw new EmptyQueueException();
        }
        else {
            return head.getValue().getValue();
        }
    }

    /**
     * Returns the size of the queue.
     * @return the size of the queue
     */
    public int size() {
        return this.size;
    }

    /**
     * Clones the queue.
     * @return a clone of the queue
     */
    @Override
    public IsraeliQueue<E> clone() {
        try {
            IsraeliQueue<E> clone = (IsraeliQueue<E>) super.clone(); // shallow copy
            clone.head = this.head.clone(); // deep copy
            clone.tail = this.tail.clone(); // deep copy

            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Returns an iterator over the elements in the queue.
     * @return an iterator over the elements in the queue
     */
    @Override
    public Iterator<E> iterator() {
        return new IsraeliQueueIterator<>(head);
    }

}
