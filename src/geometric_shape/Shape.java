package geometric_shape;

public abstract class Shape implements Comparable<Shape> {
	
    protected double height;

    public abstract double getBaseArea();
    public abstract double getVolume();

    @Override
    public int compareTo(Shape other) {
        return Double.compare(other.height, this.height);
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + 
            "\n Height: " + height + 
            " BaseArea: " + String.format("%,.2f", getBaseArea()) + 
            " Volume: " + String.format("%,.2f", getVolume());
    }
}