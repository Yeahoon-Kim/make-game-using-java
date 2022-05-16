package player;

import map.Location;

import java.awt.*;

public abstract class PlayUnit {
    protected Location currentLocation;
    protected int round;
    protected int money;

    public PlayUnit() {
        this.currentLocation = null;
        this.money = 10000;
        this.round = 0;
    }

    public void init(Location startLocation) {
        this.currentLocation = startLocation;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void IncreaseRound() {
        round++;
    }

    public int getRound() {
        return round;
    }

    public void go() {
        currentLocation = currentLocation.getNextLocation();
    }

    public int getMoney() {
        return money;
    }

    abstract public void payMoney();

    abstract public Shape getObject();
}
