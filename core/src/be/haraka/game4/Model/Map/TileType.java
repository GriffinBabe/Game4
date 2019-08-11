package be.haraka.game4.Model.Map;


/**
 * Tile type that will describe all the properties of a tile.
 *
 * @author GriffinBabe.
 */
public enum TileType {

    VOID(-1,"tile-void"),GRASS(0,"tile-grass"), WALL(1,"tile-wall"), WATER(2,"tile-water");

    public int typeID;
    public String objectName;

    TileType(int id, String objectName) {
        this.typeID = id;
        this.objectName = objectName;
    }

    /**
     * Returns the Tile Type from the ID. Used by map parsers from
     * JSON files, network?, ...
     *
     * @param id, integer ID value parsed from JSON (or network?)
     * @return {@link TileType } Tile type.
     */
    public static TileType getById(int id) {
        for(TileType e : values()) {
            if(e.typeID == id) return e;
        }
        return VOID;
    }
}
