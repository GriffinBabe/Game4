package be.haraka.game4.Model;

import be.haraka.game4.Model.Mob.Character;

public class Player {

    private String username;
    private Character mob;

    public Player(String username, Character mob) {
        this.username = username;
        this.mob = mob;
    }


    public Character getCharacter() {return mob;}
}
