package sample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Elevator {
    Random r = new Random();
    // holds current floor
    private int currentFloor;
    // holds requests for floors
    public Queue<Integer> floors = new LinkedList<>();
    // constructor
    public Elevator(){
        currentFloor = 1;
    }
    // return current floor
    public int getCurrentFloor() {
        return currentFloor;
    }
    // request a floor and go to that floor
    // then, request a random floor from passenger
    public void floorRequest(int nextFloor) {
        floors.add(nextFloor);
        move();
        floors.add(r.nextInt(20));
        move();
    }
    // move elevator down
    private void goDown() {
        if (floors.isEmpty()) {
            return;
        }
        while (floors.peek() != currentFloor) {
            currentFloor--;
        }
        floors.remove();
    }
    // move elevator up
    private void goUp() {
        if (floors.isEmpty()) {
            return;
        }
        while (floors.peek() != currentFloor) {
            currentFloor++;
        }
        floors.remove();
    }
    // elevator moves in order of requested floors
    private void move() {
        if (floors.isEmpty()) {
            return;
        }
        if (floors.peek() < currentFloor){
            goDown();
        } else  if (floors.peek() > currentFloor){
            goUp();
        }
        else {
            floors.remove();
        }
        if (!floors.isEmpty()) {
            move();
        }
    }
}
