package be.haraka.game4.Model.Mob;

public class StatModifier {

    float mutliplier;
    float additional;

    public StatModifier(float mulitplier, float additional) {
        this.mutliplier = mulitplier;
        this.additional = additional;
    }

    public float getMutliplier() {
        return mutliplier;
    }

    public float getAdditional() {
        return additional;
    }
}
