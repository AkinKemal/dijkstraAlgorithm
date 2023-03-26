public interface InterfaceLinkedList {

    void add(String from, String to, int distance);

    boolean contains(String from, String to);

    boolean containsGraph(String from);

    int size();

    void printList();

    boolean isEmpty();

    void clear();

}