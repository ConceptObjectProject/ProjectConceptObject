package org.isen.conceptObject.models;

import java.util.ArrayList;
<<<<<<< Updated upstream
=======
import java.util.Random;

>>>>>>> Stashed changes

public class Elve extends Good{
    public Elve(int posX, int posY, boolean isGood) {
        super(posX, posY);
        this.numbersLives=5;
<<<<<<< Updated upstream
        this.numberMessages=1;
        this.numberMaxMessages=7;
        this.chancetowin=1/2;
        this.race="Elfe";
    }

	@Override
	void move() {
		int doublemove=0;
		while(doublemove<=1) {
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
        this.numberMessagesMax=7;
        this.chancetoWin=0.5;
        this.race="Elf";
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
			doublemove+=1;
		}
	}

	@Override
	void meet(Alive alive) {
		if (alive.inAlliance==true) {
			alive.numberMessages+= Math.ceil(this.numberMessages/2);
			this.numberMessages+= Math.ceil(alive.numberMessages/2);
			if (alive.numberMessages>alive.numberMaxMessages) {
				alive.numberMessages=alive.numberMaxMessages;
			}
			if (this.numberMessages>this.numberMaxMessages) {
				this.numberMessages=this.numberMaxMessages;
			}
		}
		else {
			if(alive.good==this.good && this.race!= alive.race) {
				double rand = Math.random();
				if(rand<=0.5) {
					alive.numberMessages+= Math.ceil(this.numberMessages/2);
					this.numberMessages+= Math.ceil(alive.numberMessages/2);
					if (alive.numberMessages>alive.numberMaxMessages) {
						alive.numberMessages=alive.numberMaxMessages;
					}
					if (this.numberMessages>this.numberMaxMessages) {
						this.numberMessages=this.numberMaxMessages;
					}
					alive.inAlliance=true;
					this.inAlliance=true;
				}
				else {
					fight(alive);
				}
			}
			else if(this.race!= alive.race) {
				fight(alive);
			}
		}
	}

	@Override
	void fight(Alive alive) {
		double rand=Math.random();
		if(alive.chancetowin>this.chancetowin) {
			//rajouter une liste de combats effectué pour pas les refaires et penser à aller chercher la liste des éléments
			if(rand<=0.75) {
				this.numbersLives-=1;
				alive.numberMessages+= Math.ceil(this.numberMessages/2);
				if(this.numberMessages==0) {
					alive.numberMessages+=1;
				}
				if (alive.numberMessages>alive.numberMaxMessages) {
					alive.numberMessages=alive.numberMaxMessages;
				}
				this.numberMessages= (int) Math.floor(this.numberMessages/2);
				if (this.numbersLives==0) {
					this.inLife=false;
				}
			}
			else {
				alive.numbersLives-=1;
				this.numberMessages+= Math.ceil(alive.numberMessages/2);
				if(alive.numberMessages==0) {
					this.numberMessages+=1;
				}
				if (this.numberMessages>this.numberMaxMessages) {
					this.numberMessages=this.numberMaxMessages;
				}
				alive.numberMessages= (int) Math.floor(alive.numberMessages/2);
				if (alive.numbersLives==0) {
					alive.inLife=false;
				}
			}
		}
		else {
			if(rand<=0.5) {
				this.numbersLives-=1;
				alive.numberMessages+= Math.ceil(this.numberMessages/2);
				if(this.numberMessages==0) {
					alive.numberMessages+=1;
				}
				if (alive.numberMessages>alive.numberMaxMessages) {
					alive.numberMessages=alive.numberMaxMessages;
				}
				this.numberMessages= (int) Math.floor(this.numberMessages/2);
				if (this.numbersLives==0) {
					this.inLife=false;
				}
			}
			else {
				alive.numbersLives-=1;
				this.numberMessages+= Math.ceil(alive.numberMessages/2);
				if(alive.numberMessages==0) {
					this.numberMessages+=1;
				}
				if (this.numberMessages>this.numberMaxMessages) {
					this.numberMessages=this.numberMaxMessages;
				}
				alive.numberMessages= (int) Math.floor(alive.numberMessages/2);
				if (alive.numbersLives==0) {
					alive.inLife=false;
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
	
=======
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
>>>>>>> Stashed changes
}
