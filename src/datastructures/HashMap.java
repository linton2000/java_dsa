package datastructures;

public class HashMap {
    HashEntry[] array;
    int length;  // No. of elements in HashMap
    int capacity;  // Size of backing array
    int verbosity; // 0 - No prints; 1 - All prints

    public HashMap(int verbosity){
        this.length = 0;
        this.capacity = 2;  // Arbitrary initial capacity
        this.array = new HashEntry[this.capacity];
        this.verbosity = verbosity;
    }

    public HashMap(){
        this(0);
    }

    public void insert(String key, String val){
        int index = this.hash(key);
        this.array[index] = new HashEntry(key, val);
        this.length += 1;

        // Increase size if more than half of array is filled. Resize before next insertion for efficiency.
        if (this.length > 0.5 * this.capacity){
            this.resize();
        }

        if (verbosity == 1){
            System.out.printf("Capacity: %d, Length: %d", this.capacity, this.length);
        }
    }

    public HashEntry get(String key){
        int index = this.hash(key);
        return array[index];
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

    private void resize(){
        this.capacity = this.capacity * 2;

        // Rehashing
        HashEntry[] oldArray = this.array;
        this.array = new HashEntry[this.capacity];
        for (HashEntry entry : oldArray){
            if (entry != null){
                int index = this.hash(entry.key);
                this.array[index] = entry;
            }
        }
    }

}