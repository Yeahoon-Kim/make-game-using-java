package map;

import javafx.scene.shape.Ellipse;
import state.GlobalState;

import javax.swing.*;
import java.awt.*;

public abstract class Minimap extends JPanel {
    protected WorldMap worldMap;

    public Minimap() {
        this.worldMap = WorldMap.getInstance();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        this.draw(g);
    }

    abstract public void init();
    abstract public void draw(Graphics g);
}