package exercise;

// BEGIN
public class Segment {
    Point beginPoint;
    Point endPoint;

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        return new Point((beginPoint.x + endPoint.x) / 2, (beginPoint.y + endPoint.y) / 2);
    }

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }
}

// END
