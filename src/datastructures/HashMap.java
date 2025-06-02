package datastructures;

/* 
 * Simple HashMap implementation that uses Chaining to resolve collisions.
 * Hashes based on ASCII sum of key (modded by capacity).
 */
public class HashMap {
    HashEntry[] array;
    int length;  // No. of elements in HashMap
    int capacity;  // Size of backing array
    int verbosity;

    /**
     * Base constructor
     * 
     * @param verbosity For debug statements: 0 - No prints; 1 - All prints
     */
    public HashMap(int verbosity){
        this.length = 0;
        this.capacity = 2;  // Arbitrary initial capacity
        this.array = new HashEntry[this.capacity];
        this.verbosity = verbosity;
    }

    /**
     * Default constructor
     */
    public HashMap(){
        this(0);
    }

    /**
     * Simple hash entry getter.
     * 
     * @param key - Key for the required entry.
     * @return The required entry.
     */
    public HashEntry get(String key){
        int index = this.hash(key);
        return array[index];
    }

    /** 
     * Insert new element into HashMap. Handles collisions through chaining.
     * Does not support non-string keys or values.
     * 
     * @param key - Key to be hashed with.
     * @param val - Value to be stored.
     */
    public void insert(String key, String val){
        int index = this.hash(key);

        // Check for collisions
        if (this.array[index] != null){
            this.handleCollision(index, new HashEntry(key, val));
        } else {
            this.array[index] = new HashEntry(key, val);
        }
        this.length += 1;

        // Increase size if more than half of array is filled. Resize before next insertion for efficiency.
        if (this.length > 0.5 * this.capacity){
            this.resize();
        }

        if (verbosity == 1){
            System.out.printf("Capacity: %d, Length: %d", this.capacity, this.length);
        }
    }

    /**
     *  Hash by converting key string to index using sum & mod of ASCII char codes.
     * 
     * @param key The key (string) to be hashed for retrieval/insertion.
     * @return The hashed index based on input key.
     */
    private int hash(String key){
        int asciiSum = 0;
        for (int i = 0; i < key.length(); i++){
            asciiSum += (int) key.charAt(i);
        }
        return asciiSum % this.capacity;
    }

    /**
     * Handle collision through chaining hash entries.
     * 
     * @param index - Where collision happens in backing array.
     * @param newEntry - Entry to be inserted in chain.
     */
    private void handleCollision(int index, HashEntry newEntry){
        HashEntry entry = this.array[index];
        while (entry.chainedEntry != null) {
            entry = entry.chainedEntry;  // Iterate through the collision chain
        }
        entry.chainedEntry = newEntry;
    }

    /**
     * Double capacity & rehash all existing entries. Best called after insertion (before next insert).
     */
    private void resize(){
        this.capacity = this.capacity * 2;

        // Rehashing
        HashEntry[] oldArray = this.array;
        this.array = new HashEntry[this.capacity];
        for (HashEntry entry : oldArray){
            if (entry != null){
                int index = this.hash(entry.key);
                if (this.array[index] != null){
                    this.handleCollision(index, entry);
                } else {
                    this.array[index] = entry;
                }
            }
        }
    }
}
