package teslafactory.model;


import teslafactory.model.details.CarAccessories;
import teslafactory.model.details.CarBody;
import teslafactory.model.details.CarEngine;
import teslafactory.model.details.Numerable;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Numerable {

	private static final AtomicInteger serialNumberGenerator = new AtomicInteger(0);

	private final int ID = serialNumberGenerator.incrementAndGet();

	private final CarEngine engine;
	private final CarBody body;
	private final CarAccessories accessories;
	
	public Car(CarBody body, CarEngine engine, CarAccessories accessories) {
		this.body = body;
		this.engine = engine;
		this.accessories = accessories;
	}

	@Override
	public int getId() { return ID; }

	@Override
	public String toString() {
		return "Car{" +
				"ID=" + ID +
				", engine=" + engine +
				", body=" + body +
				", accessories=" + accessories +
				'}';
	}
}
