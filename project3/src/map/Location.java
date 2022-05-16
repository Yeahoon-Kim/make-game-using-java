package map;

import player.PlayUnit;

public class Location {
    private int x;
    private int y;
    private boolean flag;
    private Location nextLocation;
    private PlayUnit owner;

    public Location(int x, int y, boolean flag, Location nextLocation) {
        this.x = x;
        this.y = y;
        this.flag = flag;
        this.nextLocation = nextLocation;
        this.owner = null;
    }

    public Location(int x, int y, Location nextLocation) {
        this(x, y, false, nextLocation);
    }

    public void setOwner(PlayUnit playUnit) {
        this.owner = playUnit;
    }

    public PlayUnit getOwner() {
        return owner;
    }

    public void setNextLocation(Location nextLocation) {
        this.nextLocation = nextLocation;
    }

    public Location getNextLocation() {
        return nextLocation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isFlag() {
        return flag;
    }
}
