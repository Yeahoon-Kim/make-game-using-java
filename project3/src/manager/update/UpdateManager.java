package manager.update;

import constant.Constant;
import manager.Manager;

import player.Computer;
import player.Player;
import state.GlobalState;

public class UpdateManager extends Manager {
    private static final UpdateManager uniqueManager = new UpdateManager();

    public UpdateManager() {

    }

    public static UpdateManager getInstance() {
        return uniqueManager;
    }

    public void init() {

    }

    public void updatePlayerPosition(int diceEye) {
        Player player = GlobalState.getInstance().getPlayer();
        System.out.println(Constant.INFO_PLAYER_ROLL + diceEye);

        for(int i = 0; i < diceEye; i++) {
            player.go();

            if(player.getCurrentLocation().isFlag()) {
                player.IncreaseRound();

                if(player.getRound() == 2) {
                    System.out.println(Constant.INFO_PLAYER_WIN);
                    System.exit(0);
                }
            }
        }

        GlobalState.getInstance().getCurrentMap().repaint();
    }

    public void updateComputerPosition(int diceEye) {
        System.out.println(Constant.INFO_COMPUTER_ROLL + diceEye);
        Computer computer = GlobalState.getInstance().getComputer();

        for(int i = 0; i < diceEye; i++) {
            computer.go();

            if(computer.getCurrentLocation().isFlag()) {
                computer.IncreaseRound();

                if(computer.getRound() == 2) {
                    System.out.println(Constant.INFO_COMPUTER_WIN);
                    System.exit(0);
                }
            }
        }

        GlobalState.getInstance().getCurrentMap().repaint();
    }



}
