package set;

import collections_framework.array_list.Car;

import java.util.Iterator;

public class CarSetList implements CarSet {
    private static final int INITIAL_CAPACITY = 16;
    private static double LOAD_FACTOR = 0.75;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public boolean add(Car car) {
        if (size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean added = add(car, array);
        if (added) {
            size++;
        }
        return added;
    }

    private boolean add(Car car, Entry[] dst) {
        int position = findPosition(car, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(car, null);
            return true;
        } else {
            Entry expectedItem = dst[position];
            while (true) {
                if (expectedItem.value.equals(car)) {
                    return false;
                } else if (expectedItem.next == null) {
                    expectedItem.next = new Entry(car, null);
                    return true;
                } else {
                    expectedItem = expectedItem.next;
                }
            }
        }
    }

    @Override
    public boolean remove(Car car) {
        int position = findPosition(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.next;
        if (secondLast.value.equals(car)) {
            array[position] = last;
            size--;
            return true;
        }
        while (last != null) {
            if (last.value.equals(car)) {
                secondLast.next = last.next;
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(Car car) {
        int position = findPosition(car, array.length);
        if (array[position] == null) {
            return false;
        } else {
            if (array[position].value.equals(car)) {
                return true;
            }
            Entry current = array[position].next;
            while (current != null) {
                if (current.value.equals(car)) {
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }

    private void increaseArray() {
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry item : array) {
            Entry expectedItem = item;
            while (expectedItem != null) {
                add(expectedItem.value, newArray);
                expectedItem = expectedItem.next;
            }
        }
        array = newArray;
    }

    private int findPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode() % arrayLength);
    }

    private class Entry {
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            int index = 0;
            int nextElement = 0;
            Entry iteratorElement;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Car next() {
                Car car;
                while (array[nextElement] == null){
                    nextElement++;
                }
                if(iteratorElement == null) {
                    iteratorElement = array[nextElement];
                }
                car = iteratorElement.value;
                index++;
                iteratorElement = iteratorElement.next;
                if(iteratorElement == null){
                    nextElement++;
                }

                return car;
            }
        };
    }
}
