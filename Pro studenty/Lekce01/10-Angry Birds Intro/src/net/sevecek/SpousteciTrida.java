package net.sevecek;

import net.sevecek.angrybirds.engine.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        AngryBird cervenyPtak;

        cervenyPtak = new AngryBird(BirdType.RED);
        cervenyPtak.move();
        cervenyPtak.move();
        cervenyPtak.move();
    }

}
