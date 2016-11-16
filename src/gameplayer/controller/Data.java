package gameplayer.controller;

import java.util.Observable;

public class Data extends Observable{
	private double gold;
	private double life;
	private int level;
	private int cols, rows;


	public Data() {
	}


	double getGold() {
		return gold;
	}


	void setGold(double gold) {
		setChanged();
		notifyObservers();
		this.gold = gold;
	}


	double getLife() {
		return life;
	}


	void setLife(double life) {
		setChanged();
		notifyObservers();
		this.life = life;
	}


	int getLevel() {
		return level;
	}


	void setLevel(int level) {
		setChanged();
		notifyObservers();
		this.level = level;
	}


	int getCols() {
		return cols;
	}


	void setCols(int cols) {
		this.cols = cols;
	}


	int getRows() {
		return rows;
	}


	void setRows(int rows) {
		this.rows = rows;
	}

}
