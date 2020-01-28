package JavaCoreLessons;

public class Main {
        public static final int HUMANS_QUANTITY = 15;
        public static final int CHAIRS_QUANTITY = 14;
        public static HumansChain humansChain;
        public static ChairsChain chairsChain;

        public static void main(String[] args) {
                chairsChain = new ChairsChain(CHAIRS_QUANTITY);
                humansChain = new HumansChain(HUMANS_QUANTITY);
                while(chairsChain.getSize()>0) {
                        humansChain.move();
                        humansChain.dropOut();
                        chairsChain.printChain();
                        chairsChain.removeChair();

                }
        }
}
