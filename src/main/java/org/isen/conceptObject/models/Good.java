package org.isen.conceptObject.models;

public abstract class Good extends Alive{
    public Good(int posX, int posY) {
        super(posX,posY);
        this.goodOrBad=true;
    }
    @Override
	void Isgood() {
		this.good= true;
	}
}
