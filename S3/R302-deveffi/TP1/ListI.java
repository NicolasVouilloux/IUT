public interface ListI<T> extends BTreeI<T>{ 
    public T data();
    public List<T> tail();
    public List<T> parent();
    public int length();
    public void setTail(List<T> l);
    public String toString();
    public void display();

    /* Les méthodes suivantes sont ajoutées pour que les listes fonctionnent pour les fonctions acceptant des arbres
     * mais ne sont pas utiles en général.
     */
     
    public List<T> left();
    public List<T> right();
    public void setLeft(List<T> t);
    public List<T> child(int i);
    public int nbChildren();
    public void addChildren(List<T>... childs);
    public void setChild(int i, List<T> child);
}