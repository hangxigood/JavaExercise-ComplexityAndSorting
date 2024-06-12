package geometric_shape;

public class OctagonalPrism extends Shape {
	
	private double edgeLength;

    public OctagonalPrism(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

	@Override
	public double getBaseArea() {
		// TODO Auto-generated method stub
		return 2 * (1 + Math.sqrt(2)) * edgeLength * edgeLength;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return getBaseArea() * height;
	}

}
