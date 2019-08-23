package be.haraka.game4.Model.Mob;

/**
 * Stat class, usefull as it can hold
 * any kind of stat. We can add & remove, additional,
 * multipliers of our stats, and the
 */
public class Stat {

    private float basicStat;

    /**
     * WIll simply add up to basicStat
     */
    private float additionalStats = 0.0f;

    /**
     * Will effect the class by multiplying (basicStat + additionalStats).
     */
    private float multipliers = 1.0f;

    private StatType type;

    public Stat(float basicStat, StatType type) {
        this.basicStat = basicStat;
        this.type = type;
    }

    public float value() {
        float value = (basicStat + additionalStats) * multipliers;
        switch (type) {
            case FLOAT:
                return value;
            case INTEGER_CEIL:
                return (float)Math.ceil(value);
            case INTEGER_ROUND:
                return (float)(int)(value+0.5f);
            case INTEGER_FLOOR:
                return (float)Math.floor(value);
        }
        return value;
    }

    public float bValue() {
        return basicStat;
    }

    /**
     * Increases {@link #additionalStats}
     * @param additionalStat, the increase.
     */
    void addAdditional(float additionalStat) {
        additionalStats += additionalStat;
    }

    /**
     * Increases the multiplier of our stat.
     * {@link #multipliers}.
     * @param multiplier, the increase of the multipliers.
     */
    void addMultiplier(float multiplier) {
        multipliers += multiplier;
    }

    /**
     * Decreases the multiplier of our stat.
     * {@link #multipliers}.
     * @param multiplier, the increase of the multipliers.
     */
    void removeMultiplier(float multiplier) {
        multipliers -= multiplier;
    }

    /**
     * Decreases {@link #additionalStats}
     * @param additionalStat, the decrease.
     */
    void removeAdditional(float additionalStat) {
        additionalStat -= additionalStats;
    }

    /**
     * Sees how the result get's rounded up.
     * Example, life is an integer.
     */
    enum StatType {

        INTEGER_FLOOR(0),
        INTEGER_CEIL(1),
        INTEGER_ROUND(2),
        FLOAT(3);

        private int typeId;

        StatType(int typeId) {
            this.typeId = typeId;
        }
    }
}
