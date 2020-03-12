package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.Floor;

/**
 *
 * @author franc
 */
public class Cell {

    private Item item;

    public Cell(Item item) {
        this.item = item;
    }
    
    public Cell(){
        this.item = new Floor();
    }

    public Item getItem() {
        return item;
    }
    
    public boolean isFree(){
        return item == new Floor();
    }
    
    public void put(Item item){
        if(!this.item.isCrosseable()){
            throw new IllegalStateException("Must be a crosseable item(goal,floor)");
        }
        this.item = item;
    }
    
    public void remove(){
        item = new Floor();
    }
}
