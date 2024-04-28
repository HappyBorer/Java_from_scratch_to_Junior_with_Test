package linked_list;

import collections_framework.array_list.Car;
import collections_framework.array_list.ListCar;

public class CarLinkedList implements ListCar {
    private Node first;
    private Node last;
    private int size = 0;
    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(Car car) {
        if(size == 0){
            first = new Node(null, car, null);
            last = first;
        }else{
            Node secondNode = last;
            last = new Node(secondNode, car, null);
            secondNode.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(Car car, int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(size == index){
            return add(car);
        }
        Node nextNode = getNode(index);
        Node previousNode = nextNode.previous;
        Node newNode = new Node(previousNode, car, nextNode);
        if(previousNode != null){
            previousNode.next = newNode;
        }else {
            first = newNode;
        }
        nextNode.previous = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for(int i = 0; i < size; i++){
            if(node.value.equals(car)){
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node deletNode = getNode(index);
        Node previousDel = deletNode.previous;
        Node nextDel = deletNode.next;
        if(previousDel != null) {
            previousDel.next = nextDel;
        }else{
            first = nextDel;
        }
        if(nextDel != null) {
            nextDel.previous = previousDel;
        }else {
            last = previousDel;
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
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(Car car) {
        Node node = first;
        for(int i = 0; i < size; i++){
            if(node.value.equals(car)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private Node getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    private static class Node{
        private Node  previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
