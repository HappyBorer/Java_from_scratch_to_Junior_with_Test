package set;

import collections_framework.array_list.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {
    private CarSet ArrayCarSet;
    @BeforeEach
    void setUp() {
        ArrayCarSet = new CarSetList();
        for(int i = 0; i < 100; i++){
            Car car = new Car("Brand" + i, i);
            ArrayCarSet.add(car);
        }
    }

    @Test
    void whenAdd3SimilarObjectsThenSizeIncreaseBy1() {
        assertEquals(100, ArrayCarSet.size());
        Car car = new Car("BMW", 15);
        assertTrue(ArrayCarSet.add(car));
        assertFalse(ArrayCarSet.add(car));
        assertFalse(ArrayCarSet.add(car));
        assertEquals(101, ArrayCarSet.size());
    }

    @Test
    void elementIsInTheListAndTheElementIsRemoved() {
        Car car = new Car("Brand30", 30);
        assertTrue(ArrayCarSet.remove(car));
        assertEquals(99, ArrayCarSet.size());
        assertFalse(ArrayCarSet.remove(car));
        assertEquals(99, ArrayCarSet.size());
    }



    @Test
    void clear() {
        ArrayCarSet.clear();
        assertEquals(0, ArrayCarSet.size());
    }
    @Test
    void whenWeCheckTheExistenceOfAnObjectInAColumn(){
        Car carOne = new Car("Brand30", 30);
        Car carTwo = new Car("BMW", 1);
        assertTrue(ArrayCarSet.contains(carOne));
        assertFalse(ArrayCarSet.contains(carTwo));
    }
    @Test
    void testForeach(){
        int index = 0;
        for(Car car : ArrayCarSet){
            index++;
        }
        assertEquals(100, index);
    }
}