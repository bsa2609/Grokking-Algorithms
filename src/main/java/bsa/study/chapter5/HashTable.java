package bsa.study.chapter5;

public class HashTable {
    private int elementsCount;
    private int allElementsCount;
    private ElementOfHashTable[] storage;
    private final double maxFillFactor = 0.7;

    public HashTable() {
        allElementsCount = 8;
        elementsCount = 0;
        storage = new ElementOfHashTable[allElementsCount];
    }

    private int generateHashIndex(String key) {
        int sumOfChars = 0;

        char[] symbols = key.toCharArray();
        for (char symbol : symbols) {
            sumOfChars += (int) symbol;
        }

        return sumOfChars % allElementsCount;
    }

    private int addNextElementToArray(ElementOfHashTable[] currentElements, int index, ElementOfHashTable element) {
        if (element.hasNextElement()) {
            currentElements[++index] = element.getNextElement();
            return addNextElementToArray(currentElements, index, element.getNextElement());
        }

        return index;
    }

    private ElementOfHashTable[] getElements() {
        ElementOfHashTable[] elements = new ElementOfHashTable[elementsCount];

        int index = -1;
        for (ElementOfHashTable element : storage) {
            if (element != null) {
                elements[++index] = element;
                index = addNextElementToArray(elements, index, element);
            }
        }

        return elements;
    }

    private void increaseAndReorganizeTheStorage() {
        ElementOfHashTable[] elements = getElements();

        allElementsCount *= 2;
        storage = new ElementOfHashTable[allElementsCount];

        for (ElementOfHashTable element : elements) {
            element.clearNextAndPreviousElement();
            putElement(element);
        }
    }

    private ElementOfHashTable findElementByKey(ElementOfHashTable element, String key) {
        if (element.getKey().equals(key)) {
            return  element;
        } else if (element.hasNextElement()) {
            return findElementByKey(element.getNextElement(), key);
        } else {
            return null;
        }
    }

    private ElementOfHashTable getElement(String key) {
        int hashIndex = generateHashIndex(key);
        if (storage[hashIndex] == null) {
            return null;
        } else {
            return findElementByKey(storage[hashIndex], key);
        }
    }

    private void attachToLastElement(ElementOfHashTable element, ElementOfHashTable nextElement) {
        if (element.hasNextElement()) {
            attachToLastElement(element.getNextElement(), nextElement);
        } else {
            element.setNextElement(nextElement);
            nextElement.setPreviousElement(element);
        }
    }

    private void putElement(ElementOfHashTable element) {
        int hashIndex = generateHashIndex(element.getKey());
        if (storage[hashIndex] == null) {
            storage[hashIndex] = element;
        } else {
            attachToLastElement(storage[hashIndex], element);
        }
    }

    public int size() {
        return elementsCount;
    }

    public Integer get(String key) {
        ElementOfHashTable element = getElement(key);

        if (element == null) {
            return null;
        } else {
            return element.getValue();
        }
    }

    public void put(String key, Integer value) {
        ElementOfHashTable element = getElement(key);
        if (element == null) {
            double fillFactor = (double) elementsCount / allElementsCount;
            if (fillFactor > maxFillFactor) {
                increaseAndReorganizeTheStorage();
            }

            elementsCount++;

            ElementOfHashTable newElement = new ElementOfHashTable(key, value);
            putElement(newElement);

        } else {
            element.setValue(value);
        }
    }

    public void delete(String key) {
        ElementOfHashTable element = getElement(key);
        if (element != null) {
            if (element.hasPreviousElement() && element.hasNextElement()) {
                element.getPreviousElement().setNextElement(element.getNextElement());
                element.getNextElement().setPreviousElement(element.getPreviousElement());
                element.clearNextAndPreviousElement();

            } else if (element.hasNextElement()) {
                int hashIndex = generateHashIndex(element.getKey());
                storage[hashIndex] = element.getNextElement();
                element.getNextElement().setPreviousElement(null);
                element.clearNextAndPreviousElement();

            } else if (element.hasPreviousElement()) {
                element.getPreviousElement().setNextElement(null);
                element.clearNextAndPreviousElement();

            } else {
                int hashIndex = generateHashIndex(element.getKey());
                storage[hashIndex] = null;
            }

            elementsCount--;
        }
    }

    @Override
    public String toString() {
        StringBuilder representationBuilder = new StringBuilder();

        ElementOfHashTable[] elements = getElements();
        for (ElementOfHashTable element : elements) {
            if (!representationBuilder.isEmpty()) {
                representationBuilder.append(", ");
            }

            representationBuilder.append(element.getKey());
            representationBuilder.append("=");
            representationBuilder.append(element.getValue());
        }

        representationBuilder.insert(0, "{");
        representationBuilder.append("}");

        return representationBuilder.toString();
    }
}
