package org.isen.conceptObject.models;

import java.util.ArrayList;
import java.util.Random;

import org.isen.conceptObject.models.master.MasterElve;


public class Elve extends Good{
    public Elve(int posX, int posY) {
        super(posX, posY);
        this.numbersLives=5;
        this.numberMessages=1;
        this.numberMessagesMax=7;
        this.chancetoWin=1/2;
        this.race="Elfe";
    }

	@Override
	void move() {
		int twomove=2;
		while (twomove>0) {
			Integer[] Coord = {0,0};
			ArrayList<Integer[]> Usable= new ArrayList<>();
			for (int xAlent=-1; xAlent<2; xAlent++) {
				for (int yAlent=-1; yAlent<2; yAlent++) {
					if((0<=posX+xAlent) && (posX+xAlent<10)&& (0<=posY+yAlent) && (posY+yAlent<10)) {
						Element el= new Element(posX+xAlent,posY+yAlent);
						if (el.statut==true){
							Coord[0]= xAlent;
							Coord[1]= yAlent;
							Usable.add(Coord);
						}
					}
				}
			}

			Random random = new Random();
			int usable;
			usable = random.nextInt(Usable.size());
			int prevX= this.posX;
			int prevY= this.posY;
			this.posX= Usable.get(usable)[0];
			this.posY= Usable.get(usable)[1];
			twomove-=1;
			Element prevEl = new Element(prevX, prevY);
			prevEl.statut=false;
		}
	}
	@Override
	void meet(Alive alive) {
		if (alive.goodOrBad == this.goodOrBad && !alive.race.equals(this.race) && alive.numbersLives!=0) {
			if(this.inAlliance==true) {
				this.numberMessages+= alive.numberMessages;
				if (this.numberMessages>this.numberMessagesMax) {
					this.numberMessages=this.numberMessagesMax;
				}
			}
			else {
				this.inAlliance=false;
				Random random = new Random();
				int alliesOrEnnemies;
				alliesOrEnnemies = random.nextInt(2);
				if(alliesOrEnnemies==0) {
					this.inAlliance=true;
					this.numberMessages+= alive.numberMessages;
					if (this.numberMessages>this.numberMessagesMax) {
						this.numberMessages=this.numberMessagesMax;
					}
				}
				else {
					fight(this, alive);
				}
			}
		}
		else if (!alive.race.equals(this.race) && alive.numbersLives!=0){
			fight(this,alive);
			
		}
		else if(alive.getClass().equals(MasterElve.class)) {
			alive.numberMessages+= this.numberMessages;
			this.numberMessages=0;
		}
	}
	@Override
	void fight(Alive alive1, Alive alive2) {
		// if !listCombat.contains([alive1,alive2])
		double winOrLose;
		winOrLose = Math.random();
		// cas ou alive 2 est un Orc et alive 1 non
		if(alive2.chancetoWin>alive1.chancetoWin) {
			if(winOrLose<=0.75){
				if(alive1.numberMessages==0) {
					alive2.numberMessages+=1;
				}
				else {
					alive2.numberMessages+= Math.floor(alive1.numberMessages/2);
				}
				if (alive2.numberMessages>alive2.numberMessagesMax) {
					alive2.numberMessages=alive2.numberMessagesMax;
				}
				alive1.numberMessages = (int) Math.ceil(alive1.numberMessages/2);
				alive1.numbersLives-=1;
				if(alive1.numbersLives==0) {
					alive1.statut=false;
				}
			}
			else {
				if(alive2.numberMessages==0) {
					alive1.numberMessages+=1;
				}
				else {
					alive1.numberMessages+= Math.floor(alive2.numberMessages/2);
				}
				if (alive1.numberMessages>alive1.numberMessagesMax) {
					alive1.numberMessages=alive1.numberMessagesMax;
				}
				alive2.numberMessages = (int) Math.ceil(alive2.numberMessages/2);
				alive2.numbersLives-=1;
				if(alive2.numbersLives==0) {
					alive2.statut=false;
				}
				
			}
		}
		//cas sans orc
		else {
			if(winOrLose<=0.5) {
				alive1.numberMessages+= Math.floor(alive2.numberMessages/2);
				if (alive1.numberMessages>alive1.numberMessagesMax) {
					alive1.numberMessages=alive1.numberMessagesMax;
				}
				alive2.numberMessages = (int) Math.ceil(alive2.numberMessages/2);
				alive2.numbersLives-=1;
				if(alive2.numbersLives==0) {
					alive2.statut=false;
				}
				
			}
			else{
				alive2.numberMessages+= Math.floor(alive1.numberMessages/2);
				if (alive2.numberMessages>alive2.numberMessagesMax) {
					alive2.numberMessages=alive2.numberMessagesMax;
				}
				alive1.numberMessages = (int) Math.ceil(alive1.numberMessages/2);
				alive1.numbersLives-=1;
				if(alive1.numbersLives==0) {
					alive1.statut=false;
				}
			}
		}
		//sinon on ne fait rien
	}
}
