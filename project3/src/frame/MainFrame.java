package frame;

import state.GlobalState;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final MainFrame uniqueFrame = new MainFrame();

    public MainFrame() {

    }

    public static MainFrame getInstance() {
        return uniqueFrame;
    }

    public void init() {
        this.setTitle("Project 2"); // defined in JFrame
        this.setSize(new Dimension(600, 600)); // set size of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set 'x' button makes program finished

        this.add(GlobalState.getInstance().getCurrentMap());

        this.setVisible(true); // set window visible
    }
}