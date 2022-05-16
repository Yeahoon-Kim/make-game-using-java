package map;

import player.Computer;
import player.Player;
import state.GlobalState;

import java.awt.*;

public class WorldMap extends Minimap {
    private static final WorldMap uniqueWorldMap = new WorldMap();
    private Location startLocation;


    public WorldMap() {
        this.setBackground(Color.white);
        startLocation = null;

    }

    public static WorldMap getInstance() {
        return uniqueWorldMap;
    }

    public void init() {
        startLocation = new Location(0, 0, true, null);
        Location tempLocation = startLocation;

        for(int i = 0; i < 9; i++) {
            tempLocation.setNextLocation(new Location(i + 1, 0, null));
            tempLocation = tempLocation.getNextLocation();
        }

        for(int i = 0; i < 9; i++) {
            tempLocation.setNextLocation(new Location(9, i + 1, null));
            tempLocation = tempLocation.getNextLocation();
        }

        for(int i = 0; i < 9; i++) {
            tempLocation.setNextLocation(new Location(8 - i, 9, null));
            tempLocation = tempLocation.getNextLocation();
        }

        for(int i = 0; i < 8; i++) {
            tempLocation.setNextLocation(new Location(0, 8 - i, null));
            tempLocation = tempLocation.getNextLocation();
        }

        tempLocation.setNextLocation(startLocation);

        GlobalState.getInstance().getPlayer().init(startLocation);
        GlobalState.getInstance().getComputer().init(startLocation);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.gray);
        g2d.fill(new Rectangle(250, 250, 20, 20));

        if(startLocation == null) this.init();

        Location tempLocation = startLocation;

        Shape tempShape = new Rectangle(25 + 50 * tempLocation.getX(), 25 + 50 * tempLocation.getY(), 50, 50);
        g2d.setColor(Color.BLUE);
        g2d.fill(tempShape);
        g2d.setColor(Color.BLACK);
        g2d.draw(tempShape);

        tempLocation = tempLocation.getNextLocation();

        while(tempLocation != startLocation) {
            tempShape = new Rectangle(25 + 50 * tempLocation.getX(), 25 + 50 * tempLocation.getY(), 50, 50);


            //
            if(tempLocation.getOwner() == null) g2d.setColor(Color.YELLOW);
            else if(tempLocation.getOwner() instanceof Player) g2d.setColor(Color.ORANGE);
            else if(tempLocation.getOwner() instanceof Computer) g2d.setColor(Color.PINK);
            else g2d.setColor(Color.BLACK);

            g2d.fill(tempShape);
            g2d.setColor(Color.BLACK);
            g2d.draw(tempShape);

            tempLocation = tempLocation.getNextLocation();
        }

        g2d.setColor(Color.RED);
        g2d.fill(GlobalState.getInstance().getPlayer().getObject());

        g2d.setColor(Color.GREEN);
        g2d.fill(GlobalState.getInstance().getComputer().getObject());
    }

    public Location getStartLocation() {
        return startLocation;
    }
}