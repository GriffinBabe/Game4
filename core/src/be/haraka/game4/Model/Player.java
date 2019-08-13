package be.haraka.game4.Model;

import be.haraka.game4.Model.Mob.Character;

public class Player {

    private String username;
    private Character character;

    public Player(String username, Character character) {
        this.username = username;
        this.character = character;
    }


    public Character getCharacter() {return character;}
}
