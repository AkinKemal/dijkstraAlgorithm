import java.util.Objects;

public class LinkedList implements InterfaceLinkedList {

    public Node head = null;

    @Override
    public void add(String from, String to, int distance) {
        Node node = new Node(from, to, distance);
        if (head == null) {
            head = node;
        } else {
            Node walk = head;
            while (walk != null) {
                if (walk.next == null) {
                    break;
                }
                walk = walk.next;
            }
            walk.next = node;
        }
    }

    @Override
    public boolean contains(String from, String to) {
        Node walk = head;
        while (walk != null) {
            if (Objects.equals(walk.from, from) && Objects.equals(walk.to, to)) {
                return false;
            }
            walk = walk.next;
        }
        return true;
    }

    @Override
    public boolean containsGraph(String from) {
        Node walk = head;
        while (walk != null) {
            if (Objects.equals(walk.from, from)) {
                return true;
            }
            walk = walk.next;
        }
        return false;
    }

    @Override
    public int size() {
        int counter = 0;
        Node walk = head;
        while (walk != null) {
            counter++;
            walk = walk.next;
        }
        return counter;
    }

    @Override
    public void printList() {
        Node walk = head;
        System.out.println("LinkedList: ");
        while (walk != null) {
            System.out.println(walk.from + "->" + walk.to + ": " + walk.distance);
            walk = walk.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
        System.out.println("The LinkedList has been successfully cleared.");
    }

}