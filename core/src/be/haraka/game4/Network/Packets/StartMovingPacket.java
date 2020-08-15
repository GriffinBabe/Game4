package be.haraka.game4.Network.Packets;

import be.haraka.game4.Model.GameObject;

public class StartMovingPacket extends Packet {

    float startX, startY;
    GameObject.Direction direction;

}
