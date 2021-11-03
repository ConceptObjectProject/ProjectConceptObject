package org.isen.conceptObject.models;

import java.util.ArrayList;

public class Human extends Good {
    public Human(int posX, int posY) {
        super(posX, posY);
    }

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
					}
				}
			}
		}
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
		
	}
}
