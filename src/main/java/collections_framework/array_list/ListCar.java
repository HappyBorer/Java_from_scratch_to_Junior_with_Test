package collections_framework.array_list;

public interface ListCar extends CarCollection{
    Car get(int index);
    boolean add(Car car);
    boolean add(Car car, int index);
    boolean removeAt(int index);

}
