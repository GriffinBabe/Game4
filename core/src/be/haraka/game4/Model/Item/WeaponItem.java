package be.haraka.game4.Model.Item;

public class WeaponItem extends EquipmentItem {

    private static Slot SLOT = Slot.WEAPON;

    private WeaponType type;

    public WeaponItem(String objectName, Rarity rarity, WeaponType type) {
        super(objectName,rarity,SLOT);
        this.type = type;
    }

    public WeaponItem(float x, float y, Rarity rarity, String objectName, WeaponType type) {
        super(x,y,rarity,objectName,SLOT);
        this.type = type;
    }

    public enum WeaponType {
        SWORD(0),
        BOW(1),
        WAND(2);

        public int id;

        WeaponType(int id) {
            this.id = id;
        }
    }
}
