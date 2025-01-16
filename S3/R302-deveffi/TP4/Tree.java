import java.util.ArrayList;

public class Tree<T> implements TreeI<T>{

    private T data;
    private ArrayList<Tree<T>> children;
    private Tree<T> parent;

    public Tree(){}

    @SafeVarargs
    public Tree(T data, Tree<T>... childs) {
        this.data = data;
        this.children = new ArrayList<Tree<T>>();
        for (Tree<T> child : childs){
            this.children.add(child);
        }
        this.parent = null;
    }

    public T data(){
        return this.data;
    }

    public Tree<T> child(int n) {
        try{
            return this.children().get(n);
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    private ArrayList<Tree<T>> children(){
        return this.children;
    }

    public int nbChildren(){
        return this.children().size();
    }

    public Tree<T> parent(){
        return this.parent;
    }

    @SafeVarargs
    public final void addChildren(Tree<T>... childs) {
        for (Tree<T> child : childs){
            child.parent = this;
            this.children.add(child);
        }
    }

    /* Attention : la méthode suivante ne peut que modifier un enfant existant */
    public void setChild(int i, Tree<T> child) {
        this.children.set(i, child);
    }

    public int profondeur() {
    	int deep = 1;
    	
    	for (int i = 0; i < nbChildren(); i++) {
    		if (deep < 1 + children.get(i).profondeur()) {
    			deep = 1 + children.get(i).profondeur();
    		}
    	}
    	
    	return deep;
    }
    
    public int max() {
    	int val = 0;
    	
    	for (int i = 0; i < nbChildren(); i++) {
    		if (val < children.get(i).max()) {
    			val = children.get(i).max();
    		}
    	}
    	
    	return val;
    }
    
    public int nbSommet() {
    	int totalSommet = 1;
  	  for(int i = 0; i < nbChildren(); i++) {
  		  totalSommet += children.get(i).nbSommet();
  	  }
  	  return totalSommet;
    }

     /* Adapted from VasiliNovikov@StackOverflow */

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.data());
        buffer.append('\n');
        for (int i = 0; i < nbChildren(); i++) {
            Tree<T> next = this.child(i);
            if (i < nbChildren() -1) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    public void display() {
        System.out.println(this.toString());
    }
    
    
    @SuppressWarnings("unchecked")
	public static void main(String[] args){


        Tree<Integer> root = new Tree(0, 
        		new Tree(1, 
        				new Tree(22,
        						new Tree(33)),
        				new Tree(21),
        				new Tree(2, 
        						new Tree(32),
        						new Tree(31, 
        								new Tree(43)),
        						new Tree(3,
        								new Tree(42),
        								new Tree(41),
        								new Tree(4)))));

        
        root.display();
        System.out.println(root.max());

    }
}