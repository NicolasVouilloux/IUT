public interface BTreeI<T> extends TreeI<T>{ 
    public T data();
    public BTree<T> parent();
    public BTree<T> left();
    public void setLeft(BTree<T> t);
    public BTree<T> right();
    public void setRight(BTree<T> t);
    public String toString();
    public void display();

    /* Les méthodes suivantes sont ajoutées pour que les arbres binaires BTree fonctionnent pour les fonctions acceptant des arbres Tree
     * mais ne sont pas utiles si l'arbre est binaire.
     */
    public Tree<T> child(int i);
    public int nbChildren();
    public void addChildren(BTree<T>... childs);
    public void setChild(int i, BTree<T> child);
}