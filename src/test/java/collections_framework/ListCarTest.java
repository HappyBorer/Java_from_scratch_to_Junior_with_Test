package collections_framework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListCarTest {
    private ListCar arrayCar;
    @BeforeEach
    void setUp() {
        arrayCar = new CarArrayList();
        for(int i = 0; i < 100; i++){
            Car car = new Car("Brand" + i, i);
            arrayCar.add(car);
        }
    }
    @Test
    void whenAdded100ElementsThenSizeMustBe100(){
        assertEquals(100, arrayCar.size());
    }

    @Test
    void whenElementRemovedByIndexThenSizeMustBeDecreased(){
        assertTrue(arrayCar.removeAt(5));
        assertEquals(99, arrayCar.size());
    }

    @Test
    void whenElementRemovedThenSizeMustBeDecreased(){
        Car car = new Car("Toyota", 15);
        arrayCar.add(car);
        assertEquals(101, arrayCar.size());
        assertTrue(arrayCar.remove(car));
        assertEquals(100, arrayCar.size());
    }
    @Test
    void whenNonExistentElementRemovedThenReturnFalse(){
        Car car = new Car("Toyota", 15);
        assertFalse(arrayCar.remove(car));
        assertEquals(100, arrayCar.size());
    }

    @Test
    void whenListClearedThenSizeMustBe0(){
        arrayCar.clear();
        assertEquals(0, arrayCar.size());
    }

    @Test
    void whenIndexOutOfBoundsThenThrownException(){
        assertThrows(IndexOutOfBoundsException.class, () -> arrayCar.get(100));
    }

    @Test
    void methodGetReturnedRightValue(){
        Car car = arrayCar.get(0);
        assertEquals("Brand0", car.getBrand());
    }
}