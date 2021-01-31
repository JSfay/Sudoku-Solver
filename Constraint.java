public class Constraint {

    private int[][] board;

    public Constraint() {
        board = new int[9][9];
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean updateBoard(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int value = coordinate.getValue();
        if (value < 0 || value > 9) {
            return false;
        }
        for (int i = 0; i < board[x].length; i++) {
            if (value == board[x][i]) {
                return false;
            }
        }
        for (int i = 0; i < board[y].length; i++) {
            if (value == board[i][y]) {
                return false;
            }
        }

        int[] numbers = new int[9];
        for (int i = 1; i <= 3; i++) {
            int endX = i * 3 - 1;
            int startX = endX - 2;
            for (int j = 1; j <= 3; j++) {
                int endY = j * 3 - 1;
                int startY = endY - 2;
                if (x >= startX && x <= endX && y >= startY && y <= endY) {
                    int position = 0;
                    for (int k = startX; k <= endX; k++) {
                        for (int l = startY; l < endY; l++) {
                            numbers[position++] = board[k][l];
                        }
                    }
                }
            }
        }
        for (int number : numbers) {
            if (coordinate.getValue() == number) {
                return false;
            }
        }

        board[x][y] = value;
        return true;
    }

    public void display() {
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
                if (j == 2 || j == 5) {
                    System.out.print("|\t");
                }
            }
            if (i == 2 || i == 5) {
                System.out.print("\n---------------------------------------------------------------------------------");
            }
        }
    }

}
