package teslafactory;

@FunctionalInterface
public interface Observable {

    void subscribe(Observer observer);

}

