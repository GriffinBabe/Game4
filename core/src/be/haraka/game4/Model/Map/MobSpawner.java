package be.haraka.game4.Model.Map;


import be.haraka.game4.Model.Mob.Mob;
import be.haraka.game4.Model.Mob.MobList;

/**
 * Mob spawner, implementation of the prototype pattern.
 *
 */
public class MobSpawner {

    public MobSpawner() {
    }

    /**
     * Clones a mob from our mob list and returns it.
     * The mob name is NOT the name of the gameobject.
     * The name of the GameObject is used for graphics,
     * while the mob name is used to differ
     * @param mobName
     * @return
     */
    public Mob spawnMob(String mobName) {
        // Reference to the mob we want to clone
        Mob oldMob = MobList.getInstance().getMob(mobName);
        return (Mob) oldMob.clone();
    }
}
