package be.haraka.game4.Model;

import be.haraka.game4.Model.Mob.Mob;

public class Player {

    private PlayerRole player;
    private String username;
    private Mob mob = null;
    private int score = 0;

    public Player(String username) {
        this.username = username;
    }

    public Player(String username, Mob mob) {
        this.username = username;
        this.mob = mob;
    }

    public void setMob(Mob mob) { this.mob = mob; }
    public Mob getMob() {return mob;}
}
