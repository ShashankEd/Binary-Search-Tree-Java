interface Tree<T extends Comparable<T>> {
    void insert(T data);
    void remove(T data);
    //in order traversal yields the natural ordering
    void traversal();
    T getMax();
    T getMin();
}
