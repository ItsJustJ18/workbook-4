






public class Room {
    private int beds;
    private double price;
    private boolean occupied;
    private boolean dirty;
    private boolean available;


    public Room(double price, int beds, boolean occupied, boolean dirty, boolean available) {
        this.price = price;
        this.beds = beds;
        this.occupied = occupied;
        this.dirty = dirty;
        this.available = available;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
