package sample;

public class ElevatorSystem {
    private Elevator a = new Elevator();
    private Elevator b = new Elevator();
    private Elevator c = new Elevator();

    public ElevatorSystem () {}

    public void request(int nextFloor) {
        boolean selected = false;
        Elevator sel = a;
        if (a.stack.isEmpty()) {
            selected = true;
            a.floorRequest(nextFloor);
        } else if (b.stack.isEmpty()) {
            selected = true;
            sel = b;
            b.floorRequest(nextFloor);
        } else if (c.stack.isEmpty()) {
            selected = true;
            sel = c;
            c.floorRequest(nextFloor);
        }
        if (!selected) {
            int min = Math.abs(a.getCurrentFloor() - nextFloor);
            if (Math.abs(b.getCurrentFloor() - nextFloor) < min){
                min = Math.abs(b.getCurrentFloor() - nextFloor);
                sel = b;
            }
            if (Math.abs(c.getCurrentFloor() - nextFloor) < min) {
                min = Math.abs(c.getCurrentFloor() - nextFloor);
                sel = c;
            }
        }
        sel.floorRequest(nextFloor);
    }
}
