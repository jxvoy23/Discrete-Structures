public class SinglyLinkedList<E> {

    // Nested Node class
    private static class Node<E> { 
        private E element;  // Reference to the element stored at this node
        private Node<E> next;  // Reference to the subsequent node in the list
        
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    } // End of nested Node class    

    // Instance variables of the singly linked list
    private Node<E> head = null; // Head node of the list (or null if empty)
    private Node<E> tail = null; // Last node of the list (or null if empty)
    private int size = 0; // Number of nodes in the list

    public SinglyLinkedList() {}  // Constructs an initially empty list

    // Access methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E first() {   // Returns (but does not remove) the first element
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {   // Returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // Update methods
    public void addFirst(E e) {  // Adds element e to the front of the list
        head = new Node<>(e, head);  // Create and link a new node
        if (size == 0) {
            tail = head; // Special case: new node becomes tail too
        }
        size++;
    }

    public void addLast(E e) {   // Adds element e to the end of the list
        Node<E> newest = new Node<>(e, null);   // New node to be the tail
        if (isEmpty()) {
            head = newest;   // Special case: previously empty list
        } else {
            tail.setNext(newest);  // New node follows the current tail
        }
        tail = newest;   // New node becomes the tail
        size++;
    }

    public E removeFirst() {   // Removes and returns the first element
        if (isEmpty()) return null;   // Nothing to remove
        E answer = head.getElement();
        head = head.getNext();   // Head moves to the next node
        size--;
        if (size == 0) {
            tail = null;   // Special case: list is now empty
        }
        return answer;
    }
    // output linked list
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(40);
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(50);

        list.printList();
    }

    
}
