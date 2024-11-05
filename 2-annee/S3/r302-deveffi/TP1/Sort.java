public class Sort {
    public static boolean isSorted(List<Double> list){
    	if (list.tail()== null)
    		return true;
    	if (list.data()<(list.tail()).data()&& isSorted(list.tail())) {
    		return true;
        }
    	return false;
    }

    public static List<Double> addInOrder(List<Double> list, Double in){
//    	if(list.data()>in) {
//    		List<Double> newTail = new List<>(in);
//			System.out.println("aaaaaaa");
//			return newTail;
//			
//    	}
    	if (list.tail()== null) {
    		list.setTail(new List<>(in));
    		return list;
    	}
    	if (list.data()<in && in<(list.tail()).data()) {
    		List<Double> newTail = new List<>(in);
    		newTail.setTail(list.tail());
    		list.setTail(newTail);
        }
    	else addInOrder(list.tail(),in);
    	return list;
    }

    public static void main(String... args){
        List<Double> l = new List<>(0.0,20.3, -6.3);
        l.display();
        System.out.printf("La réponse est false, votre programme répond %b\n", isSorted(l));

        
        List<Double> l2 = new List<>(-6.3,0.0,20.3);
        l2.display();
        System.out.printf("La réponse est true, votre programme répond %b\n", isSorted(l2));
        addInOrder(l2,6.4);
        addInOrder(l2,0.1);
        addInOrder(l2,2.0);
        addInOrder(l2,19.9);
        addInOrder(l2,1.4);
        addInOrder(l2,2.1);
        addInOrder(l2,-42.1);
        l2.display();
        
    }
}
