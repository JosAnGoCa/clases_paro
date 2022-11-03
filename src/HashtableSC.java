public class HashtableSC<K, V> {
    private class Entry {
        public K key;
        public int hash;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode();
        }

        @Override
        public boolean equals(Object otherEntry) {
            Entry other = (Entry) otherEntry;
            if(this.hash != other.hash) return false;
            return this.key.equals(other.key);
        }
    }

    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.667;

    private double maxLoadFactor;
    private int size = 0;
    private int capacity;
    private int thereshold;
    private SimpleLinkedList<Entry>[] table;

    public HashtableSC() {
        this(DEFAULT_LOAD_FACTOR, DEFAULT_CAPACITY);
    }

    public HashtableSC(double maxLoadFactor) {
        this(maxLoadFactor, DEFAULT_CAPACITY);
    }

    public HashtableSC(int capacity) {
        this(DEFAULT_LOAD_FACTOR, capacity);
    }

    public HashtableSC(double maxLoadFactor, int capacity) {
        if(maxLoadFactor >= 1 && maxLoadFactor > 0) {
            this.maxLoadFactor = DEFAULT_LOAD_FACTOR;
        } else {
            this.maxLoadFactor = Double.max(DEFAULT_LOAD_FACTOR, maxLoadFactor);
        }
        this.capacity = Integer.max(DEFAULT_CAPACITY, capacity);
        thereshold = (int) (maxLoadFactor * capacity);
        table = new SimpleLinkedList[capacity];
    }

    // Retorna la cantida de elementos que tenemos
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for(SimpleLinkedList<Entry> bucket: table) {
            bucket = null;
        }
        size = 0;
    }

    private int normalizeIndex(int hashKey) {
        return (hashKey & 0x7FFFFFFF) % capacity;
    }

    public void insert(K key, V value) {
        if(size >= thereshold) {
            resize();
        }
        Entry entrada = new Entry(key, value);
        int indice = normalizeIndex(entrada.hash);
        if (table[indice] == null) {
            table[indice] = new SimpleLinkedList<>();
            table[indice].addFirst(entrada);
            size++;
        } else {
            if (table[indice].has(entrada)) {
                table[indice].update(entrada, entrada);
            } else {
                table[indice].addFirst(entrada);
                size++;
            }
        }
    }

    public boolean hasKey(K keyToSearch) {
        int bucketIndex = normalizeIndex(keyToSearch.hashCode());
        for (Entry element: table[bucketIndex]) {
            if ((element.hash == keyToSearch.hashCode())
                    && keyToSearch.equals(element.key)) return true;
        }
        return false;
    }

    public V get(K keyToSearch) {
        int bucketIndex = normalizeIndex(keyToSearch.hashCode());
        for (Entry element: table[bucketIndex]) {
            if ((element.hash == keyToSearch.hashCode())
                    && keyToSearch.equals(element.key)) return element.value;
        }
        return null;
    }

    public void remove(K keyToRemove) {
        Entry aux = new Entry(keyToRemove, null);
        if(hasKey(keyToRemove)) {
            int bucketIndex = normalizeIndex(aux.hash);
            table[bucketIndex].searchAndDelete(aux);
            size--;
        }
    }

    public SimpleLinkedList<K> keys() {
        SimpleLinkedList<K> listOfKeys = new SimpleLinkedList<>();
        for (SimpleLinkedList<Entry> bucket: table)
            if (bucket != null)
                for (Entry element: bucket)
                    listOfKeys.addFirst(element.key);
        return listOfKeys;
    }

    public SimpleLinkedList<V> values() {
        SimpleLinkedList<V> listOfValues = new SimpleLinkedList<>();
        for (SimpleLinkedList<Entry> bucket: table)
            if (bucket != null)
                for (Entry element: bucket)
                    listOfValues.addFirst(element.value);
        return listOfValues;
    }

    private void resize() {
        capacity = capacity*2;
        thereshold = (int)(capacity * maxLoadFactor);
        SimpleLinkedList<Entry>[] oldTable = table;
        table = new SimpleLinkedList[capacity];
        size = 0;
        for (SimpleLinkedList<Entry> bucket: oldTable) {
            if (bucket != null){
                for (Entry element: bucket) {
                    insert(element.key, element.value);
                }
            }
        }
    }
}
