class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private MyDoubleLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity);
        dll = new MyDoubleLinkedList();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            dll.moveToHead(node);
            
            return node.value;
        } return -1;
    }
    
    public void put(int key, int value) {
        // Map에 해당 key가 존재하는가?
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            dll.moveToHead(node);
        } else {
            if(map.size() >= capacity) {
                Node removeNode = dll.removeTail();
                map.remove(removeNode.key);
                
            }
            Node node = new Node(key, value);
            map.put(key, node);
            dll.addToHead(node);
        }
        
    }

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class MyDoubleLinkedList {
        Node head, tail;
        
        MyDoubleLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;        
        }

        public void moveToHead(Node node) {
            remove(node);
            addToHead(node);
        }

        public Node removeTail() {
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */