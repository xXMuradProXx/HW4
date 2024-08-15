import java.lang.reflect.InvocationTargetException;

public class Node<E>{
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

    public boolean isContained(E other){
        if (this.value.equals(other))
            return true;
        if (this.next == null)
            return false;
        return next.isContained(other);
    }

    public Node<E> getTail(){
        return this.next == null ? this : next.getTail();
    }

    public void setTail(Node<E> tail){
        if (this.next == null)
            this.next = tail;
        else
            next.setTail(tail);
    }

    public boolean hasNext() {
        return next != null;
    }
}
