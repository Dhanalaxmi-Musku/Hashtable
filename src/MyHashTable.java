
public class MyHashTable<T, V> {
	private LinkedList<MyMapNode<T, V>>[] bucketArray;
    private int numBuckets;
    private int size;

    public MyHashTable() {
        this.numBuckets = 10;
        this.bucketArray = new LinkedList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            bucketArray[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    private int getBucketIndex(T key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % numBuckets;
    }

    public void add(T key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<MyMapNode<T, V>> bucket = bucketArray[bucketIndex];
        Node<MyMapNode<T, V>> current = bucket.head;

        while (current != null) {
            if (current.data.key.equals(key)) {
                current.data.value = value;
                return;
            }
            current = current.next;
        }

        MyMapNode<T, V> newNode = new MyMapNode<>(key, value);
        bucket.add(newNode);
        size++;
    }

    public V get(T key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<MyMapNode<T, V>> bucket = bucketArray[bucketIndex];
        Node<MyMapNode<T, V>> current = bucket.head;

        while (current != null) {
            if (current.data.key.equals(key)) {
                return current.data.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(T key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<MyMapNode<T, V>> bucket = bucketArray[bucketIndex];
        Node<MyMapNode<T, V>> current = bucket.head;
        Node<MyMapNode<T, V>> prev = null;

        while (current != null) {
            if (current.data.key.equals(key)) {
                if (prev == null) {
                    bucket.head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public int size() {
        return size;
    }
}