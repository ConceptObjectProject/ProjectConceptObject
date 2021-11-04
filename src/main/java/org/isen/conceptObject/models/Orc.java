package org.isen.conceptObject.models;

import java.util.ArrayList;
<<<<<<< Updated upstream
=======
import java.util.Random;
>>>>>>> Stashed changes

public class Orc extends Bad{
    public Orc(int posX, int posY) {
        super(posX, posY);
        this.numbersLives=5;
        this.numberMessagesMax=7;
        this.chancetoWin= 0.75;
        this.race="Orc";
    }
<<<<<<< Updated upstream

	@Override
	void move() {
		ArrayList<int []> listOfCase= new ArrayList();
		for (int cote=-1; cote<1;cote++) {
			int[] possible = {0,0};
			for (int cote2=-1; cote2<1;cote2++) {
				if((posX+cote)>=0 && (posX+cote)<10 && (posY+cote2)>=0 && (posY+cote2)<10){
					Element element= new Element(posX+cote,posY+cote2);
					if(element.use==false) {
						possible[0]= posX+cote;
						possible[1]= posY+cote;
						listOfCase.add(possible);
=======
	@Override
	void move() {
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
>>>>>>> Stashed changes
					}
				}
			}
		}
<<<<<<< Updated upstream
		int random= (int) Math.floor(Math.random()*listOfCase.size());
		
		this.posX= listOfCase.get(random)[0];
		this.posY= listOfCase.get(random)[1];
		Element element2= new Element(posX,posY);
		element2.use=false;
	}

	@Override
	void meet(Alive alive) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void fight(Alive alive) {
		// TODO Auto-generated method stub
		
=======
		Random random = new Random();
		int usable;
		usable = random.nextInt(Usable.size());
		int prevX= this.posX;
		int prevY= this.posY;
		this.posX= Usable.get(usable)[0];
		this.posY= Usable.get(usable)[1];
		Element prevEl = new Element(prevX, prevY);
		prevEl.statut=false;
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
		else if (!alive.race.equals(this.race)&& alive.numbersLives!=0) {
			fight(this,alive);
		}
		else if(alive.getClass().equals(MasterOrc.class)) {
			alive.numberMessages+= this.numberMessages;
			this.numberMessages=0;
		}
	}
	@Override
	void fight(Alive alive1, Alive alive2) {
		// if !listCombat.contains([alive1,alive2])
		double winOrLose;
		winOrLose = Math.random();
		if(winOrLose<=0.75){
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
		else{
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
		 
>>>>>>> Stashed changes
	}
}
