package bsa.study.chapter6.Graph;

public class Node<T> {
    private final T value;
    private boolean isSeller;
    private boolean isChecked;

    public Node(T value, boolean isSeller) {
        this.value = value;
        this.isSeller = isSeller;
        this.isChecked = false;
    }

    public T getValue() {
        return value;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
