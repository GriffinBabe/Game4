package be.haraka.game4.Model;

import be.haraka.game4.Model.Mob.Mob;

public class Player {

    private String username;
    private Mob mob;

    public Player(String username, Mob mob) {
        this.username = username;
        this.mob = mob;
    }


    public Mob getMob() {return mob;}
}
