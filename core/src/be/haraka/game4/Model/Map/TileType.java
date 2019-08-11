package be.haraka.game4.Model.Map;


/**
 * Tile type that will describe all the properties of a tile.
 *
 * @author GriffinBabe.
 */
public enum TileType {

    VOID(-1),GRASS(0), WALL(1), WATER(2);

    public int typeID;

    TileType(int id) {
        this.typeID = id;
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
