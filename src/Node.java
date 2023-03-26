public class Node {

    public String from;
    public String to;
    public int distance;
    public Node next;

    public Node(String from, String to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.next = null;
    }

}