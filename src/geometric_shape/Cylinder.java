package geometric_shape;

public class Cylinder extends Shape {
	
	private double radius;

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

	@Override
	public double getBaseArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return getBaseArea() * height;
	}

}
