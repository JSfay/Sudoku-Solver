public class Coordinate {

    private int x;
    private int y;
    private int value;

    public Coordinate(int x, int y, int value, boolean isLength) {
        if (isLength) {
            this.x = x - 1;
            this.y = y - 1;
            this.value = value;
        } else {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}