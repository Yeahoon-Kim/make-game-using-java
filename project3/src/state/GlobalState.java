package state;

import manager.paint.PaintManager;

import player.Computer;
import player.Player;
import map.WorldMap;
import map.Minimap;

public class GlobalState {
    private static final GlobalState uniqueState = new GlobalState();
    private Minimap currentMap;
    private Player player;
    private Computer computer;
    private WorldMap worldMap;

    public GlobalState() {
        this.currentMap = null;
        this.player = new Player();
        this.computer = new Computer();
        this.worldMap = WorldMap.getInstance();
    }

    public static GlobalState getInstance() {
        return uniqueState;
    }

    public void init() {
        currentMap = WorldMap.getInstance();

    }

    public Minimap getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Minimap currentMap) {
        PaintManager.getInstance().getMainFrame().remove(this.currentMap);
        this.currentMap = currentMap;

        PaintManager.getInstance().getMainFrame().add(this.currentMap);
        PaintManager.getInstance().getMainFrame().revalidate();
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }
}