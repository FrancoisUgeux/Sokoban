package esi.atl.g43335.sokoban.Model;

/**
 *
 * @author franc
 */
public abstract class Moveable {

    private Position position;

    public Moveable(Position position) {
        this.position = position;
    }

    protected void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
