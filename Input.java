import java.util.Scanner;

public class Input {

    private Constraint constraint;

    public Input(Constraint constraint) {
        this.constraint = constraint;
    }

    public void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 9 numbers, use '0' for blanks!");

        for (int i = 0; i < 9; i++) {
            boolean flag = true;
            while (flag) {
                System.out.println();
                System.out.println("\nPlease enter your numbers for row " + (i + 1));
                String data = scanner.next();

                if (data.length() != 9) {
                    System.out.println("Enter 9 numbers! Your length of number is " + data.length() + " .");
                } else if (data.equals("000000000")) {
                    flag = false;
                } else {
                    try {
                        for (int j = 0; j < 9; j++) {
                            int num = Integer.valueOf(String.valueOf(data.charAt(j)));
                            if (num != 0) {
                                flag = !constraint.updateBoard(new Coordinate(i, j, num, false));
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Numbers only");
                        flag = true;
                    }
                }
                if (flag) {
                    System.out.println("Conflict in row/column/box");
                    System.out.println("Please re-enter your number");
                }
            }
            constraint.display();
        }
        scanner.close();
    }


}