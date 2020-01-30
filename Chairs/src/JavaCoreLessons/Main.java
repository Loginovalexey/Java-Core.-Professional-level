package JavaCoreLessons;

public class Main {
        public static final int HUMANS_QUANTITY = 21;
        public static final int CHAIRS_QUANTITY = 20;
        public static HumansChain humansChain;
        public static ChairsChain chairsChain;

        public static void main(String[] args) {
                chairsChain = new ChairsChain(CHAIRS_QUANTITY);
                humansChain = new HumansChain(HUMANS_QUANTITY);
                humansChain.move();
                }
}
