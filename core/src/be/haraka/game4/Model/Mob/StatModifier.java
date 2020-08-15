package be.haraka.game4.Model.Mob;

public class StatModifier {

    float multiplier;
    float additional;

    public StatModifier(float multiplier, float additional) {
        this.multiplier = multiplier;
        this.additional = additional;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public float getAdditional() {
        return additional;
    }
}
