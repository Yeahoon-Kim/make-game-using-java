package manager.paint;

import frame.MainFrame;
import manager.Manager;
import manager.input.InputManager;

import java.awt.*;

public class PaintManager extends Manager {
    private static final PaintManager uniqueManager = new PaintManager();
    private MainFrame mainFrame;

    public PaintManager() {
        this.mainFrame = MainFrame.getInstance();
    }

    public static PaintManager getInstance() {
        return uniqueManager;
    }

    public void init(InputManager inputManager) {
        this.mainFrame.addMouseListener(inputManager);
        this.mainFrame.addMouseMotionListener(inputManager);
        this.mainFrame.init();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
