package sem4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinTree tree = new BinTree();
        Random random = new Random();


        for (Integer i = 0; i < 10; i++) {
            tree.add(random.nextInt(100));
        }
    }
}