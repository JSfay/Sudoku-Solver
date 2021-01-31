public class Run  {

    private Constraint constraint;

    private int[][] array;

    private int count;

    Run(Constraint constraint) {
        this.constraint = constraint;
        array = constraint.getBoard();
        count = 0;
    }

    public void recur(int x, int y) {
        count++;
        if (x >= 9) {
            constraint.display();
            System.out.println("count = " + count);
            return;
        }
        if (y >= 9) {
            recur(x + 1, 0);
            return;
        }

        if (array[x][y] == 0) {
            for (int i = 1; i < 10; i++) {
                if (constraint.updateBoard(new Coordinate(x, y, i,false))) {
                    recur(x, y + 1);
                    array[x][y] = 0;
                }
            }
        } else {
            recur(x, y + 1);
        }
    }

}