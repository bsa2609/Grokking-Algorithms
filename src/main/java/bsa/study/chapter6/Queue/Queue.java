package bsa.study.chapter6.Queue;

public class Queue<T> {
    private ElementOfQueue<T> head;
    private ElementOfQueue<T> end;

    public Queue() {
        head = null;
        end = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void put(T value) {
        ElementOfQueue<T> elementOfQueue = new ElementOfQueue<>(value);

        if (isEmpty()) {
            head = elementOfQueue;
            end = elementOfQueue;

        } else {
            end.setNextElement(elementOfQueue);
            end = elementOfQueue;
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        ElementOfQueue<T> headElement = head;

        head = headElement.getNextElement();
        if (isEmpty()) {
            end = null;
        }

        return headElement.getValue();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }

        StringBuilder representationBuilder = new StringBuilder();

        ElementOfQueue<T> currentElement = head;

        do {
            if (!representationBuilder.isEmpty()) {
                representationBuilder.append(", ");
            }

            representationBuilder.append(currentElement.getValue().toString());

            currentElement = currentElement.getNextElement();
        } while (currentElement != null);

        representationBuilder.insert(0, "{");
        representationBuilder.append("}");

        return representationBuilder.toString();

    }
}
