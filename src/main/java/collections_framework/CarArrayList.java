package collections_framework;

import java.util.Arrays;

public class CarArrayList implements ListCar{
    Car[] array = new Car[10];
    int size = 0;
    @Override
    public Car get(int index) {
        checkArray(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        if(size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++){
            if(array[i].equals(car)){
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkArray(index);
        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    private void checkArray(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}
