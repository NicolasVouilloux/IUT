import java.util.ArrayList;
import java.util.Hashtable;

public class HashTable {
	//-------------------------------------- HASH WITH ARRAYLIST----------------------------------------
//    /* Choisissez vos méthodes */
//	private int size;
//	private ArrayList<String>[]tab;
//	
//    public HashTable(int size){
//        /* Faites votre constructeur */
//    	this.size=size;
//    	this.tab = new ArrayList[size];
//    	
//    	for (int i=0;i<size;i++) {
//    		this.tab[i] = new ArrayList<>();
//    	}
//    }
//
//    public int hash(String key){
//        int hash = 0;
//        for (int i = 0; i < key.length() ; i++){
//            hash += key.charAt(i);
//        }
//        return hash % size;
//    }
//
//    public void insert(String key){
//    	int index = hash(key);
//    	if (!check(key))
//    		this.tab[index].add(key);
//    }
//
//    public boolean check(String key){
//        return (this.tab[hash(key)].contains(key));
//    }
//
//    public void remove(String key){
//    	if(this.tab[hash(key)].contains(key)) {
//    		this.tab[hash(key)].remove(key);
//    	}
//    	
//    }
	
//	----------------------------------------------HASH WITH ARRAY
    /* Choisissez vos méthodes */
	private int size;
	private String[]tab;
	
    public HashTable(int size){
        /* Faites votre constructeur */
    	this.size=size;
    	this.tab = new String[size];
    }

    public int hash(String key){
        int hash = 0;
        for (int i = 0; i < key.length() ; i++){
            hash += key.charAt(i);
        }
        return hash % size;
    }

    public void insert(String key){
    	int index = hash(key);
    	if (!check(key)) {
    		while(this.tab[index]!=null&&(index+1)<=(this.tab.length))
    			index++;
    		if (this.tab[index]==null)
    			this.tab[index]= key;
    		else 
    			System.out.println("yaplusdplace");
    	}
    }

    public boolean check(String key){
    	int index = hash(key);
    	while(this.tab[index]!=null&&(index+1)<=(this.tab.length)&&this.tab[index]!=key)
    		index++;
    	if (this.tab[index]==key)
    		return true;
    	return false;
    }

    public void remove(String key){
    	int index = hash(key);
    	while(this.tab[index]!=null&&(index+1)<=(this.tab.length)&&this.tab[index]!=key)
    		index++;
    	if (this.tab[index]==key) {
    		this.tab[index]=null;
    	}
    }
    public static void main (String... args){
        HashTable T = new HashTable(100);
        T.insert("Hello"); T.insert("World");
        System.out.printf("Test insert / check : vous renvoyez %b (true attendu) %b (false attendu) %b (false attendu) \n", T.check("Hello"), T.check("Wrold"), T.check("test"));
        T.insert("Wolrd"); T.insert("Hello");
        System.out.printf("Test insert / check avec collision : vous renvoyez %b (true attendu) %b (true attendu) %b (false attendu) \n", T.check("World"), T.check("Wolrd"), T.check("Wrold"));
        T.insert("test"); T.remove("Wolrd"); T.remove("Uh ?"); T.remove("Hello"); T.remove("test"); T.insert("Wolrd");
        System.out.printf("Test remove / check avec collision : vous renvoyez %b (false attendu) %b (true attendu) %b (false attendu) \n", T.check("test"), T.check("Wolrd"), T.check("Hello"));
    }

}
