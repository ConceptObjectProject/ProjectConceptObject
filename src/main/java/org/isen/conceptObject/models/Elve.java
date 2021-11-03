package org.isen.conceptObject.models;

import java.util.ArrayList;

public class Elve extends Good{
    public Elve(int posX, int posY, boolean isGood) {
        super(posX, posY);
        this.numbersLives=5;
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
						}
					}
				}
			}
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
		if (alive.inAlliance=true) {
			alive.numberMessages+= Math.ceil(this.numberMessages/2);
			this.numberMessages+= Math.ceil(alive.numberMessages/2);
			if (alive.numberMessages>alive.numberMaxMessages) {
				alive.numberMessages=alive.numberMaxMessages;
			}
			if (this.numberMessages>this.numberMaxMessages) {
				this.numberMessages=this.numberMaxMessages;
			}
		}
	}

	@Override
	void fight(Alive alive) {
		double rand=Math.random();
		if(alive.chancetowin>this.chancetowin) {
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
	
}
