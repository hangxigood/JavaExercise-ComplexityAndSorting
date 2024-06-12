package geometric_shape;

public class Cone extends Shape {
	
	private double radius;

    public Cone(double height, double radius) {
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
		return (1.0 / 3.0) * getBaseArea() * height;
	}

}
