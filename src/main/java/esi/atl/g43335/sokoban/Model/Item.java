package esi.atl.g43335.sokoban.Model;

/**
 *
 * @author franc
 */
public class Item {
    private ItemType type;
    private boolean Moveable;
    private boolean Crosseable;

    public Item(ItemType type, boolean isMoveable, boolean isCrosseable) {
        this.type = type;
        this.Moveable = isMoveable;
        this.Crosseable = isCrosseable;
    }

    public ItemType getType() {
        return type;
    }

    public boolean isMoveable() {
        return Moveable;
    }

    public boolean isCrosseable() {
        return Crosseable;
    }
}
