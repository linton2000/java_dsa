package datastructures;

public class HashEntry {
    public String key;
    public String val;
    public HashEntry chainedEntry;

    public HashEntry(String key, String val){
        this.key = key;
        this.val = val;
    }

    public void chainEntry(HashEntry nextEntry){
        this.chainedEntry = nextEntry;
    }

    @Override
    public String toString(){
        return String.format("(%s, %s)", this.key, this.val);
    }
}
