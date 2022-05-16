package manager.input;

import constant.Constant;
import manager.Manager;
import manager.update.UpdateManager;
import player.Computer;
import player.Player;
import state.GlobalState;
import utility.Dice;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class InputManager extends Manager implements MouseInputListener {
    private static final InputManager uniqueManager = new InputManager();
    private UpdateManager updateManager;
    private Scanner scanner;

    public InputManager() {
        this.updateManager = null;
        this.scanner = new Scanner(System.in);
    }

    public static InputManager getInstance() {
        return uniqueManager;
    }

    public void init(UpdateManager updateManager) {
        this.updateManager = updateManager;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(button(new Point(e.getX(), e.getY()))) {
            Player player = GlobalState.getInstance().getPlayer();
            Computer computer = GlobalState.getInstance().getComputer();
            updateManager.updatePlayerPosition(Dice.roll());
            if(player.getCurrentLocation().getOwner() == null) {
                System.out.print(Constant.QUESTION_BUY_GROUND);
                String input = scanner.next();
                switch (input) {
                    case "yes":
                    case "Yes":
                    case "Y":
                    case "y":
                        player.getCurrentLocation().setOwner(player);
                        player.payMoney();
                        break;
                    case "no":
                    case "No":
                    case "N":
                    case "n":
                        break;
                    default:
                        System.out.println(Constant.ERR_WRONG_INPUT);
                        System.exit(1);
                }
            }

            updateManager.updateComputerPosition(Dice.roll());
            if(GlobalState.getInstance().getComputer().getCurrentLocation().getOwner() == null) {
                System.out.print(Constant.QUESTION_BUY_GROUND);
                if(computer.randomBoolean()) {
                    System.out.println(Constant.INFO_COMPUTER_BUY_GROUND);
                    computer.getCurrentLocation().setOwner(computer);
                    computer.payMoney();
                }
                else System.out.println(Constant.INFO_COMPUTER_NOT_BUY_GROUND);
            }

            System.out.println(player.toString());
            System.out.println(computer.toString());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private boolean button(Point p) {
        if((200 < p.x) && (p.x < 300)) {
            if((200 < p.y) && (p.y < 300)) {
                return true;
            }
        }

        return false;
    }
}
