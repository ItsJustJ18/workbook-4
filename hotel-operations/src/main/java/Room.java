






public class Room {
    private int beds;
    double price;
    private boolean isOccupied;
    private boolean dirty;
    boolean isAvailable;


    public Room(double price, int beds, boolean isOccupied, boolean dirty, boolean isAvailable) {
        this.price = price;
        this.beds = beds;
        this.isOccupied = isOccupied;
        this.dirty = dirty;
        this.isAvailable = isAvailable;
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
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
