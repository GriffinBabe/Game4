package be.haraka.game4.Network.Packets;

public class MovePacket extends ObjectPacket {

    /** Starting position when the MobWalkState has been called. */
    public float startX, startY;

    /** Direction for the new mob walk state.
     * See {@link be.haraka.game4.Model.GameObject.Direction} class
     */
    public char dirC;
}
