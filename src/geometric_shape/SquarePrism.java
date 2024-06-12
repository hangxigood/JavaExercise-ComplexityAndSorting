package geometric_shape;

public class SquarePrism extends Shape {
	
	private double edgeLength;

    public SquarePrism(double height, double edgeLength) {
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
		return getBaseArea() * height;
	}

}
