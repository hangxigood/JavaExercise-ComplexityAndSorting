package geometric_shape;

public class PentagonPrism extends Shape {

	private double edgeLength;

    public PentagonPrism(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }
    
	@Override
	public double getBaseArea() {
		// TODO Auto-generated method stub
		return (5 * edgeLength * edgeLength * Math.tan(Math.toRadians(54))) / 4.0;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return getBaseArea() * height;
	}

}
