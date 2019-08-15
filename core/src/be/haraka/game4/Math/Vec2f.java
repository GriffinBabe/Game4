package be.haraka.game4.Math;

import com.badlogic.gdx.math.Vector2;

public class Vec2f {

    public float x, y;

    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vec2f() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Vector2 toGdxVector2() {
        return new Vector2(this.x, this.y);
    }
}
