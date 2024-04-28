package collections_framework.array_list;

public interface CarCollection {

    boolean add(Car car);
    boolean remove(Car car);
    int size();
    void clear();

    boolean contains(Car car);
}
