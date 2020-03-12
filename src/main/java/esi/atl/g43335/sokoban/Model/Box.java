package esi.atl.g43335.sokoban.Model;

/**
 *
 * @author franc
 */
public class Box extends Moveable {

    public Box(Position position) {
        super(position);
    }

    public void move(Direction direction) {
        getPosition().next(direction);
    }
}
