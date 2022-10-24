import java.util.Objects;

public class HastableSC<K, V> {
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

    public HastableSC() {
        this(DEFAULT_LOAD_FACTOR, DEFAULT_CAPACITY);
    }

    public HastableSC(double maxLoadFactor) {
        this(maxLoadFactor, DEFAULT_CAPACITY);
    }

    public HastableSC(int capacity) {
        this(DEFAULT_LOAD_FACTOR, capacity);
    }

    public HastableSC(double maxLoadFactor, int capacity) {
        if(maxLoadFactor >= 1 && maxLoadFactor > 0) {
            this.maxLoadFactor = DEFAULT_LOAD_FACTOR;
        } else {
            this.maxLoadFactor = Double.max(DEFAULT_LOAD_FACTOR, maxLoadFactor);
        }
        if(capacity < 3) {
            this.capacity = DEFAULT_CAPACITY;
        } else {
            this.capacity = Integer.max(DEFAULT_CAPACITY, capacity);
        }
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
        for(SimpleLinkedList<Entry> lista: table) {
            lista = null;
        }
        size = 0;
    }

    private int normalizeIndex(int hashKey) {
        return (hashKey & 0x7FFFFFFF) % capacity;
    }

    public void insert(K key, V value) {
        // RESIZE
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
}
