import java.lang.reflect.InvocationTargetException;

public class Node<E> implements Cloneable {
    private E value;
    private Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public Node(E value) {
        this(value, null);
    }

    public E getValue() {
        return value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**
     * Checks if the list contains the given element.
     * @param other the element to be checked
     * @return true if the list contains the given element, false otherwise
     */
    public boolean isContained(E other) {
        if (this.value.equals(other))
            return true;
        if (this.next == null)
            return false;
        return next.isContained(other);
    }

    /**
     * Returns the tail of the list.
     * @return the tail of the list
     */
    public Node<E> getTail() {
        return this.next == null ? this : next.getTail();
    }

    /**
     * Sets the tail(last node) of the list.
     * @param tail the tail of the list
     */
    public void setTail(Node<E> tail) {
        if (this.next == null)
            this.next = tail;
        else
            next.setTail(tail);
    }

    /**
     * Checks if the list has a next node.
     * @return true if the list has a next node, false otherwise
     */
    public boolean hasNext() {
        return this.next != null;
    }

    /**
     * Clones the list.
     * @return a clone of the list
     */
    @Override
    public Node<E> clone() {
        try {
            Node<E> clone = (Node<E>) super.clone(); // shallow copy
            E element = this.value; // the value of the current node

            if (element instanceof Cloneable) {
                clone.value = (E) element.getClass().getMethod("clone").invoke(element); // deep copy
            }

            if (hasNext()) {
                clone.next = this.next.clone(); // moves to the next node and clones it
            }

            return clone; // returns the cloned list
        } catch (CloneNotSupportedException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            return null;
        }
    }

}