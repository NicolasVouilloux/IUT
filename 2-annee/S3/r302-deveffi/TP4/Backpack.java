public class Backpack {

    public static int sum(List<Integer> objets){
        if (objets == null){
            return 0;
        }
        else{
            return objets.data() + sum(objets.tail());
        }
    }

    public static List<Integer> backPack(int contenance, List<Integer> objets){
//    	 Algo glouton qui prend le premier objet qu'il peut
//    	List<Integer> res = null;
//    	List<Integer> miniList = objets;
//    	while (miniList != null && miniList.data()!= null) {
//    		if(miniList.data()<=contenance) {
//    			res = new List<>(miniList.data());
//    			if(miniList.tail()!= null)
//    				res.setTail(backPack(contenance - miniList.data(),miniList.tail()));
//    			break;
//    		}
//    		else
//    			miniList = miniList.tail();
//    	}
//        return res;
      
//    	 aglo glouton qui prend le plus gros objet qu'il peut
    	List<Integer> res = null;
    	List<Integer> miniList = objets;
    	int maxData = 0;
    	while (miniList != null && miniList.data()!= null) {
			if (miniList.data()>maxData)
				maxData = miniList.data();
			miniList = miniList.tail();
    	}
    	if(maxData <contenance) {
    		res = new List<>(maxData);
    	}
    	return null;
    }

    public static void main (String... args){
        List<Integer> result = null;

        result = backPack(20, new List<>(3, 5, 13, 2));
        if (result != null) result.display();
        System.out.printf("Votre fonction choisit des objets de volume total %d, l'optimal est 20\n", sum(result));

        result = backPack(11, new List<>(3, 3, 3, 2, 2, 2, 2, 2));
        if (result != null) result.display();
        System.out.printf("Votre fonction choisit des objets de volume total %d, l'optimal est 10\n", sum(result));

    }
}
