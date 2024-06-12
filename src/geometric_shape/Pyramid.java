package geometric_shape;

public class Pyramid extends Shape {
	
	private double edgeLength;

    public Pyramid(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }
    
	@Override
	public double getBaseArea() {
		// TODO Auto-generated method stub
		return edgeLength * edgeLength;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return (1.0 / 3.0) * getBaseArea() * height;
	}

}
