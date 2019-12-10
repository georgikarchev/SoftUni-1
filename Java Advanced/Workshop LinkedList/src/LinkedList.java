public class LinkedList {
    private  Node head;
    private  Node tail;
    private  int size;

    LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public  void  addFirst(int el){
        Node node = new Node(el);

    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getSize() {
        return size;
    }

    public void setSize(Node size) {
        this.size = size;
    }
}
