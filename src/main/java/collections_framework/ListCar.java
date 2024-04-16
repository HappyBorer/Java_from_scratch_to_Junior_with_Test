package collections_framework;

public interface ListCar {
    Car get(int index);
    void add(Car car);
    boolean remove(Car car);
    boolean removeAt(int index);
    int size();
    void clear();
}
