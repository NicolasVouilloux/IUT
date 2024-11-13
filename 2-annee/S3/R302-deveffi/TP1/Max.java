public class Max{

    public static int max(BTree<Integer> t){
        return 0;
    }

    public static void main(String[] args){


        BTree<Integer> root = new BTree<>(0, new BTree<>(1,
                                                        new BTree<>(2, new BTree<>(3, new BTree<>(4))),
                                                        new BTree<>(2)),
                                                new BTree<>(1, new BTree<>(2,
                                                                        new BTree<>(3,
                                                                                new BTree<>(4,
                                                                                        new BTree<>(5 ,new BTree<>(6))),
                                                                                new BTree<>(4)),
                                                                        new BTree<>(3))));


        root.display();
        System.out.printf("Votre fonction renvoie %d, résultat attendu %d\n", max(root), 7);


        BTree<Integer> treeneg = new BTree<>(-2, new BTree<>(-1,
                                                        new BTree<>(-1, new BTree<>(-3, new BTree<>(-12))),
                                                        new BTree<>(-2)),
                                                new BTree<>(-4, new BTree<>(-9,
                                                                        new BTree<>(-54,
                                                                                new BTree<>(-3,
                                                                                        new BTree<>(-5)),
                                                                                new BTree<>(-4))
                                                                        )
                                                )
        );


        negtree.display();
        System.out.printf("Votre fonction renvoie %d, résultat attendu %d", max(treeneg), -1);

    }
}