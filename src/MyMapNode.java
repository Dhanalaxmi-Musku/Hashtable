public class MyMapNode<T, V> {
    T key;
    V value;
    MyMapNode<T, V> next;

    public MyMapNode(T key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
