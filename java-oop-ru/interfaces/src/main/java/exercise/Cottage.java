package exercise;

// BEGIN
public class Cottage implements Home {
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(exercise.Home another) {
        return Double.compare(another.getArea(), this.getArea());
    }
}

// END
