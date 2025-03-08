package bsa.study.chapter6;

public class ElementOfQueue<T> {
    private final T value;
    private ElementOfQueue<T> nextElement;

    public ElementOfQueue(T value) {
        this.value = value;
        nextElement = null;
    }

    public T getValue() {
        return value;
    }

    public ElementOfQueue<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(ElementOfQueue<T> nextElement) {
        this.nextElement = nextElement;
    }
}
