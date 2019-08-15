package be.haraka.game4.Math;

import com.badlogic.gdx.math.Vector2;

public class Vec2i {

    public int x, y;

    public Vec2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2i() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2 toGdxVector2() {
        return new Vector2(this.x, this.y);
    }
}
