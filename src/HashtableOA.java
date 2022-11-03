public class HashtableOA<K, V> {
    private static final int DEFAULT_CAPACITY = 4;
    private static final double DEFAULT_LOAD_FACTOR = 0.667;
    private final K TOMBSTONE = (K) new Object();

    private K[] keysTable;
    private V[] valuesTable;
    private double maxLoadFactor;
    private int size = 0;
    private int capacity;
    private int thereshold;

    public HashtableOA() {
        this(DEFAULT_LOAD_FACTOR, DEFAULT_CAPACITY);
    }

    public HashtableOA(double maxLoadFactor) {
        this(maxLoadFactor, DEFAULT_CAPACITY);
    }

    public HashtableOA(int capacity) {
        this(DEFAULT_LOAD_FACTOR, capacity);
    }

    public HashtableOA(double maxLoadFactor, int capacity) {
        if(maxLoadFactor >= 1 && maxLoadFactor > 0) {
            this.maxLoadFactor = DEFAULT_LOAD_FACTOR;
        } else {
            this.maxLoadFactor = Double.max(DEFAULT_LOAD_FACTOR, maxLoadFactor);
        }
        this.capacity = Integer.max(DEFAULT_CAPACITY, capacity);
        adjustCapacity();
        thereshold = (int) (maxLoadFactor * capacity);
        keysTable = (K[]) new Object[capacity];
        valuesTable = (V[]) new Object[capacity];
    }

    private void adjustCapacity() {
        int pow2 = Integer.highestOneBit(capacity);
        if (capacity == pow2) return;
        increaseCapacity();
    }

    private void increaseCapacity() {
        capacity = Integer.highestOneBit(capacity) << 1;
    }

    private int prove(int x) {
        return (x * x + x) / 2;
    }

    private boolean compareKeys(K key1, K key2) {
        return key1.hashCode() == key2.hashCode() && key2.equals(key2);
    }

    private boolean isInBounds(int index) {
        return index >= 0 && index < capacity;
    }

    private int normalizeIndex(int hashKey) {
        return (hashKey & 0x7FFFFFFF) % capacity;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            valuesTable[i] = null;
            keysTable[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(K key, V value) {
        if (size >= thereshold) {
            resize();
        }

        if (!hasKey(key)) {
            size++;
        }
        int x = 0;
        int index = (normalizeIndex(key.hashCode()) + prove(x)) % capacity;
        while (keysTable[index] != null && keysTable[index] != TOMBSTONE &&
                !compareKeys(keysTable[index], key)) {
            x++;
            index = (normalizeIndex(key.hashCode()) + prove(x)) % capacity;
        }

        keysTable[index] = key;
        valuesTable[index] = value;
    }

    public boolean hasKey(K key) {
        int x = 0;
        int thombstoneIndex = -1;
        int index = (normalizeIndex(key.hashCode()) + prove(x)) % capacity;
        while (isInBounds(index) && keysTable[index] != null) {
            if(keysTable[index] == TOMBSTONE && thombstoneIndex == -1) {
                thombstoneIndex = index;
            }
            if (compareKeys(keysTable[index], key)) {
                if (thombstoneIndex >= 0) {
                    keysTable[thombstoneIndex] = keysTable[index];
                    valuesTable[thombstoneIndex] = valuesTable[index];
                    keysTable[index] = TOMBSTONE;
                    valuesTable[index] = null;
                }
                return true;
            }
            x++;
            index = (normalizeIndex(key.hashCode()) + prove(x)) % capacity;
        }
        return false;
    }

    public V get(K key) {
        int x = 0;
        int thombstoneIndex = -1;
        int index = (normalizeIndex(key.hashCode()) + prove(x)) % capacity;
        while (isInBounds(index) && keysTable[index] != null) {
            if(keysTable[index] == TOMBSTONE && thombstoneIndex == -1) {
                thombstoneIndex = index;
            }
            if (compareKeys(keysTable[index], key)) {
                if (thombstoneIndex >= 0) {
                    keysTable[thombstoneIndex] = keysTable[index];
                    valuesTable[thombstoneIndex] = valuesTable[index];
                    keysTable[index] = TOMBSTONE;
                    valuesTable[index] = null;
                    index = thombstoneIndex;
                }
                return valuesTable[index];
            }
            x++;
            index = (normalizeIndex(key.hashCode()) + prove(x)) % capacity;
        }
        return null;
    }

    public void remove(K key) {
        int x = 0;
        int index = (normalizeIndex(key.hashCode()) + prove(x)) % capacity;
        if(hasKey(key)) {
            while (isInBounds(index) && keysTable[index] != null) {
                if (compareKeys(keysTable[index], key)) {
                    keysTable[index] = TOMBSTONE;
                    valuesTable[index] = null;
                    size--;
                    return;
                }
                x++;
                index = (normalizeIndex(key.hashCode()) + prove(x)) % capacity;
            }
        }
    }

    public SimpleLinkedList<K> keys() {
        SimpleLinkedList<K> listOfKeys = new SimpleLinkedList<>();
        for (K key : keysTable) {
            if (key != null && key != TOMBSTONE) {
                listOfKeys.addFirst(key);
            }
        }

        return listOfKeys;
    }

    public SimpleLinkedList<V> values() {
        SimpleLinkedList<V> listOfValues = new SimpleLinkedList<>();
        for (V value : valuesTable) {
            if (value != null) {
                listOfValues.addFirst(value);
            }
        }

        return listOfValues;
    }

    public void resize() {
        System.out.print("HashTable paso de " + capacity);
        increaseCapacity();
        System.out.println(" a " + capacity);
        thereshold = (int)(capacity * maxLoadFactor);
        K[] oldKeysTable = keysTable;
        V[] olsValuesTable = valuesTable;
        keysTable = (K[]) new Object[capacity];
        valuesTable = (V[]) new Object[capacity];
        size = 0;
        for (int i = 0; i < oldKeysTable.length; i++) {
            if (oldKeysTable[i] != null && oldKeysTable[i] != TOMBSTONE) {
                insert(oldKeysTable[i], olsValuesTable[i]);
            }
        }
    }
}
