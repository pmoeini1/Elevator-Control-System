package sample;

import java.util.Stack;
import java.util.Random;

public class Elevator {
    Random r = new Random();
    private int currentFloor;
    public Stack<Integer> stack = new Stack<>();
    public Elevator(){
        currentFloor = 1;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public void floorRequest(int nextFloor) {
        stack.push(nextFloor);
        move();
        stack.push(r.nextInt(20));
        move();
    }
    private void goDown() {
        if (stack.isEmpty()) {
            return;
        }
        while (stack.peek() != currentFloor) {
            currentFloor--;
        }
        stack.pop();
    }
    private void goUp() {
        if (stack.isEmpty()) {
            return;
        }
        while (stack.peek() != currentFloor) {
            currentFloor++;
        }
        stack.pop();
    }
    private void move() {
        if (stack.isEmpty()) {
            return;
        } else if (stack.peek() == currentFloor) {
            stack.pop();
            return;
        }
        if (stack.peek() < currentFloor){
            goDown();
        } else {
            goUp();
        }
    }
}
