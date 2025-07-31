import java.util.*;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 비교 기준: x 오름차순, x 같으면 y 오름차순
    @Override
    public int compareTo(Point other) {
        if (this.x != other.x)
            return this.x - other.x;
        return this.y - other.y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point other = (Point) o;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Point> shape = new ArrayList<>();
        shape.add(new Point(1, 1));
        shape.add(new Point(1, 0));
        shape.add(new Point(0, 1));

        // 정렬 적용
        Collections.sort(shape);

        System.out.println("정렬된 도형 좌표:");
        for (Point p : shape) {
            System.out.println(p);
        }
    }
}