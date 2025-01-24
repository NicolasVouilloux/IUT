public class Element {
    private int value;
    private Element next;
    private Element previous;

    public Element (int v, Element p, Element n){
        this.value = v;
        this.previous = p;
        this.next = n;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int v) {
        this.value = v;
    }

    public Element getNext() {
        return this.next;
    }

    public void setNext(Element n) {
        this.next = n;
    }

    public Element getPrevious() {
        return this.previous;
    }

    public void setPrevious(Element p) {
        this.previous = p;
    }
}