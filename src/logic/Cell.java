package logic;

public class Cell {

	public enum State {
		ALIVE,
		DEAD
	}

	private int pos_x;
	private int pos_y;

	private State state;

	public Cell() {
		this.state = State.DEAD;
	}

	public Cell(final int posx, final int posy) {
		this.state = State.DEAD;
		this.pos_x = posx;
		this.pos_y = posy;
	}

	public boolean isAlive() {

		return this.getState() == State.ALIVE ? true : false;
	}

	public State getState() {
		return this.state;
	}

	public void switchState() {
		if (this.getState() == State.ALIVE) this.state = State.DEAD;
		else
			this.state = State.ALIVE;
	}

	public int getPosx() {
		return pos_x;
	}

	public int getPosy() {
		return pos_y;
	}

}
