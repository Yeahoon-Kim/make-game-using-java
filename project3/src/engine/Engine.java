package engine;

import manager.input.InputManager;
import manager.paint.PaintManager;
import manager.update.UpdateManager;
import state.GlobalState;

public class Engine {
    private static final Engine uniqueEngine = new Engine();
    public InputManager inputManager;
    public PaintManager paintManager;
    public UpdateManager updateManager;
    private GlobalState globalState;

    public Engine() {
        this.globalState = GlobalState.getInstance();
        this.inputManager = InputManager.getInstance();
        this.paintManager = PaintManager.getInstance();
        this.updateManager = UpdateManager.getInstance();

    }

    public static Engine getInstance() {
        return uniqueEngine;
    }

    private void init() {
        this.globalState.init();
        this.updateManager.init();
        this.inputManager.init(this.updateManager);
        this.paintManager.init(this.inputManager);
        //GlobalState.getInstance().getPlayer().init();
    }

    public void start() {
        this.init();
    }
}