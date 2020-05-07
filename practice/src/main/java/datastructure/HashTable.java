package datastructure;

public class HashTable<K, V> {
    private int size;
    private int capacity;
    private Node<K, V>[] nodes;

    @SuppressWarnings("unchecked")
    public HashTable() {
        size = 0;
        capacity = 4;
        nodes = new Node[this.capacity];
    }

    private int hash(int keyHash, int m) {
        keyHash = keyHash + m;
        int hash = keyHash < 0 ? Integer.MAX_VALUE + keyHash : keyHash;
        return hash % this.capacity;
    }

    public void add(K key, V value) {
        resize();
        probeAndInsert(this.nodes, new Node<>(key, value));
        this.size++;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        if (this.size >= ((this.capacity * 2) / 3)) {
            this.capacity *= this.capacity > 50000 ? 2 : 4;
            Node<K, V>[] temp = new Node[this.capacity];

            for (Node<K, V> node : this.nodes) {
                if (node != null && !node.deleteMe) {
                    probeAndInsert(temp, node);
                }
            }

            this.nodes = temp;
        }
    }

    private void probeAndInsert(Node<K, V>[] array, Node<K, V> node) {
        for (int i = 0; ; i++) {
            int hash = this.hash(node.key.hashCode(), i);
            if (array[hash] == null || array[hash].deleteMe) {
                array[hash] = node;
                return;
            } else if (array[hash].key.equals(node.key)) {
                array[hash] = node;
                this.size--;
                return;
            }
        }
    }

    public boolean exists(K key) {
        return getNode(key) != null;
    }

    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    public void remove(K key) {
        for (int i = 0; ; i++) {
            int hash = this.hash(key.hashCode(), i);
            if (this.nodes[hash] == null) {
                return;
            } else if (this.nodes[hash].key.equals(key)) {
                this.nodes[hash].deleteMe = true;
                this.size--;
                return;
            }
        }
    }

    private Node<K, V> getNode(K key) {
        for (int i = 0; ; i++) {
            int hash = this.hash(key.hashCode(), i);
            if (this.nodes[hash] == null) {
                return null;
            } else if (this.nodes[hash].key.equals(key)) {
                return this.nodes[hash].deleteMe ? null : this.nodes[hash];
            }
        }
    }


    private static class Node<K, V> {
        K key;
        V value;
        boolean deleteMe;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.deleteMe = false;
        }
    }
}
