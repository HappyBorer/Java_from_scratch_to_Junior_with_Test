package map;

import collections_framework.array_list.Car;

import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap {
    private static final int INITIAL_CAPACITY = 16;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private static double LOAD_FACTOR = 0.75;
    private int size = 0;

    @Override
    public void put(CarOwner key, Car value) {
        int position = getPosition(key);
        if (array[position] == null) {
            array[position] = new Entry(key, value, null);
            size++;
        } else {
            Entry current = array[position];
            while (true) {
                if (current.getOwner().hashCode() == key.hashCode()) {
                    if (!current.getCar().equals(value)) {
                        current.setCar(value);
                    }
                    return;
                } else {
                    if (current.getNext() == null) {
                        current.setNext(new Entry(key, value, null));
                        return;
                    } else {
                        current = current.getNext();
                    }
                }
            }
        }
    }

    @Override
    public Car get(CarOwner key) {
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        return null;
    }

    @Override
    public List<Car> values() {
        return null;
    }

    @Override
    public boolean remove(CarOwner key) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int clear() {
        return 0;
    }

    private int getPosition(CarOwner key) {
        return key.hashCode() % array.length;
    }

    private class Entry {
        private CarOwner owner;
        private Car car;
        private Entry next;

        public Entry(CarOwner owner, Car car, Entry next) {
            this.owner = owner;
            this.car = car;
            this.next = next;
        }

        public CarOwner getOwner() {
            return owner;
        }

        public void setOwner(CarOwner owner) {
            this.owner = owner;
        }

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }
}
