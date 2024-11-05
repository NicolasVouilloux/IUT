import java.util.Arrays;

public class List<T> extends BTree<T> implements ListI<T> {
    
    private T data;
    private List<T> tail;
    private List<T> parent;

    @SafeVarargs
    public List(T head, T... data) {
        this.data = head;
        if (data.length == 0){
            this.tail = null;
        }
        else{
            this.tail = new List<T>(data[0], Arrays.copyOfRange(data, 1, data.length));
            this.parent = null;
            this.tail.parent = this;
        }
    }

    public T data(){
        return this.data;
    }

    public List<T> tail(){
        return this.tail;
    }

    public int length(){
        if (this.tail() == null){return 1;}
        return 1+ this.tail().length();
    }

    public List<T> parent(){
        return this.parent;
    }

    public void setTail(List<T> l){
        this.tail = l;
    }

    public String toString(){
        if (this.tail == null){
            return this.data().toString();
        }
        else{
            return this.data().toString() + ";" + this.tail().toString();
        }
    }

    public void display(){
        System.out.println(this.toString());
    }
    /* Pour la compatibilité avec BTree<T> */

    public List<T> left(){
        return this.tail();
    }

    public List<T> right(){
        return null;
    }

    public void setLeft(List<T> child){
        setTail(child);
    }

    public List<T> child(int i){
        if (i == 0) return this.tail();
        else return null;
    }

    public int nbChildren(){
        if (this.tail() == null) return 0;
        else return 1;
    }

    @SafeVarargs
    public final void addChildren(List<T>... childs){
        if (childs.length == 0) System.out.print("bla");
        this.setTail(childs[0]);
    }

    public void setChild(int i, List<T> child){
        if (i==0) setTail(child);
        else throw new IndexOutOfBoundsException();
    }

}