package org.isen.conceptObject.models;

public abstract class Bad extends Alive {
<<<<<<< Updated upstream
	public Bad(int posX, int posY) {
        super(posX,posY);
=======
    public Bad(int posX, int posY) {
        super(posX, posY);
        this.goodOrBad = false;
>>>>>>> Stashed changes
    }
    @Override
	void Isgood() {
		this.good= true;
	}
}
