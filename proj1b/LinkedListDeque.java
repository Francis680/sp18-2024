public class LinkedListDeque<T> implements Deque<T> {
    public class Node {
        private T item;
        private Node pre;
        private Node next;

        public Node(Node p, Node n, T i) {
            pre = p;
            next = n;
            item = i;
        }
    }

    private Node sentinelF;
    private Node sentinelB;
    private int size;

    public LinkedListDeque() {
        //  T x = new T();
        sentinelB = new Node(null, null, null);
        sentinelF = new Node(null, null, null);
        sentinelF.next = sentinelB;
        sentinelB.pre = sentinelF;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node temp = new Node(sentinelF, sentinelF.next, item);
        sentinelF.next.pre = temp;
        sentinelF.next = temp;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node temp = new Node(sentinelB.pre, sentinelB, item);
        sentinelB.pre.next = temp;
        sentinelB.pre = temp;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node ptr = sentinelF.next;
        while (ptr != null) {
            System.out.println(ptr.item);
            ptr = ptr.next;
        }
    }

    @Override
    public T removeFirst() {
        T firstItem = sentinelF.next.item;
        sentinelF.next.next.pre = sentinelF;
        sentinelF.next = sentinelF.next.next;
        --size;
        return firstItem;
    }

    @Override
    public T removeLast() {
        T lastItem = sentinelB.pre.item;
        sentinelB.pre.pre.next = sentinelB;
        sentinelF.pre = sentinelB.pre.pre;
        --size;
        return lastItem;
    }

    @Override
    public T get(int index) {
        if (index > size)
            return null;

        Node ptr = sentinelF.next;
        for (int i = index; i > 0; i--) {
            ptr = ptr.next;
        }
        return ptr.item;
    }


    public T getRecursive(int index) {
        if (index == 0)
            return null;
        return getRecursiveHelp(sentinelF.next, index);
    }

    public T getRecursiveHelp(Node ptr, int t) {
        if (t == 0) {
            return ptr.item;
        }
        return getRecursiveHelp(ptr.next, --t);
    }
}



