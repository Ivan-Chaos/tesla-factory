package teslafactory.model.details;

import java.util.concurrent.atomic.AtomicInteger;

public class CarBody extends Detail {

    protected static final AtomicInteger serialNumberGenerator = new AtomicInteger(0);
    private final int ID = serialNumberGenerator.incrementAndGet();

    @Override
    public int getId() { return ID; }

    @Override
    public String getName() {
        return "Body";
    }
}

