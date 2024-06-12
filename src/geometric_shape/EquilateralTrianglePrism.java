package geometric_shape;

public class EquilateralTrianglePrism extends Shape {
	
	private double edgeLength;

    public EquilateralTrianglePrism(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }
    
	@Override
	public double getBaseArea() {
		// TODO Auto-generated method stub
		return (Math.sqrt(3) / 4.0) * edgeLength * edgeLength;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return getBaseArea() * height;
	}

}
