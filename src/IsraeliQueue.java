import java.util.Iterator;

public class IsraeliQueue<E> implements Iterable<E> {
    private Node<Node<E>> head;
    private Node<E> tail;
    private int size;

    public IsraeliQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(E element, E friend) {
        if (element == null) {
            try {
                throw new InvalidInputException("Element cannot be null");
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }
        }

        if (head == null) {
            this.head = new Node<>(new Node<>(element));
        }
        else {
            Node<E> newElement = new Node<>(element);
            Node<Node<E>> current = head;
            while (current != null) {
                Node<E> currentFriendGroup = current.getValue();
                if (currentFriendGroup.isContained(friend)){
                    currentFriendGroup.getTail().setNext(newElement);
                    tail = head.getTail().getValue().getTail();
                    size++;
                    return;
                }
                current = current.getNext();
            }

            Node<E> newFriendGroup = new Node<>(element);
            head.getTail().setNext(new Node<>(newFriendGroup));
        }

        tail = head.getTail().getValue().getTail();
        size++;
    }

    public void add(E element) {
        add(element, null);
    }

    public E remove() {
        E element = peek();
        if (head.getValue().getNext() == null) {
            head = head.getNext(); // if there is only one element in the friend group,
            // then the queue jumps to the next group
        }
        else {
            Node<E> temp = head.getValue(); //gets the first element in the friend group
            temp = temp.getNext(); // moves to the next element in the friend group
            head.setValue(temp); // sets the new first element in the friend group
        }
        size--;
        return element;
    }

    public E peek() {
        if (head == null) {
            try {
                throw new EmptyQueueException("Queue is empty");
            } catch (EmptyQueueException e) {
                throw new RuntimeException(e);
            }
        }
        return head.getValue().getValue();
    }

    public int size() {
        return this.size;
    }


    @Override
    protected IsraeliQueue<E> clone() throws CloneNotSupportedException {
        IsraeliQueue<E> cloned = new IsraeliQueue<>();
        Node<Node<E>> current = head;
        while (current != null) {
            Node<E> currentFriendGroup = current.getValue();
            Node<E> newFriendGroup = new Node<>(currentFriendGroup.getValue());
            Node<E> newCurrent = newFriendGroup;
            while (currentFriendGroup.hasNext()) {
                currentFriendGroup = currentFriendGroup.getNext();
                newCurrent.setNext(new Node<>(currentFriendGroup.getValue()));
                newCurrent = newCurrent.getNext();
            }
            cloned.add(newFriendGroup.getValue());
            current = current.getNext();
        }
        return cloned;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<Node<E>> current = head;
            private Node<E> currentFriendGroup = head.getValue();

            @Override
            public boolean hasNext() {
                return current != null;
            }

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
        };
    }
}
