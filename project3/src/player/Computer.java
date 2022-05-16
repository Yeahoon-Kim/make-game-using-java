package player;

import constant.Constant;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Computer extends PlayUnit {

    public Computer() {
        super();
    }

    @Override
    public void payMoney() {
        if(this.money < 500) {
            System.out.println(Constant.INFO_COMPUTER_BANKRUPT);
            System.out.println(Constant.INFO_PLAYER_WIN);
            System.exit(0);
        }
        this.money -= 500;
    }

    public Shape getObject() {
        return new Ellipse2D.Double(45 + 50 * this.currentLocation.getX(), 55 + 50 * this.getCurrentLocation().getY(), 10, 10);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "money=" + money +
                '}';
    }

    public boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
