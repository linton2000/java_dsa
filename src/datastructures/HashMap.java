package datastructures;

public class HashMap {
    HashEntry[] array;
    int length;  // No. of elements in HashMap
    int capacity;  // Size of backing array

    public HashMap(){
        this.length = 0;
        this.capacity = 2;  // Arbitrary initial capacity
        this.array = new HashEntry[this.capacity];
    }

    public void insert(String key, String val){
        if (this.length > 0.5 * this.capacity){  // Increase size if more than half of array is filled.
            this.resize();
        }

        int index = this.hash(key);
        array[index] = new HashEntry(key, val);
        this.length += 1;
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
        System.out.println("resize() called!");
    }

}