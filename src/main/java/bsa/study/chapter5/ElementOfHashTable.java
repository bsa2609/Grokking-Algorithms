package bsa.study.chapter5;

public class ElementOfHashTable {
    private final String key;
    private Integer value;
    private ElementOfHashTable nextElement;
    private ElementOfHashTable previousElement;

    public ElementOfHashTable(String key, int value) {
        this.key = key;
        this.value = value;
        nextElement = null;
        previousElement = null;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setNextElement(ElementOfHashTable nextElement) {
        this.nextElement = nextElement;
    }

    public ElementOfHashTable getNextElement() {
        return nextElement;
    }

    public void setPreviousElement(ElementOfHashTable previousElement) {
        this.previousElement = previousElement;
    }

    public ElementOfHashTable getPreviousElement() {
        return previousElement;
    }

    public void clearNextAndPreviousElement() {
        nextElement = null;
        previousElement = null;
    }

    public boolean hasNextElement() {
        return nextElement != null;
    }

    public boolean hasPreviousElement() {
        return previousElement != null;
    }
}
