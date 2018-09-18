package logic;

public class Field {
	private static final int WIDTH = 10;
	private static final int HIGHT = 10;

	private final int[] x =
	{ -1, 0, 1, -1, 1, -1, 0, 1 };
	private final int[] y =
	{ 1, 1, 1, 0, 0, -1, -1, -1 };

	Cell c = new Cell();
	private final Cell[][] field;

	public Field() {
		field = new Cell[WIDTH][HIGHT];
		for (int i = 0; i < field.length; ++i) {
			for (int j = 0; j < field[i].length; ++j) {
				field[i][j] = c;
			}
		}

	}

	public int neighbors(
			final Cell cell) {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			if (field[cell.getPosx() + x[i]][cell.getPosy() + y[i]].isAlive()) count++;
		}

		return count;
	}

	public void checkLifeCondition(
			final Cell cell) {
		final int n = neighbors(cell);

		if (!cell.isAlive() && n == 3) cell.switchState();
		if (cell.isAlive() && n < 2) cell.switchState();
		if (cell.isAlive() && (n == 2 || n == 3)) {} ;
		if (cell.isAlive() && n > 3) cell.switchState();

	}

	public void buildField() {
		System.out.println("==================================================");
		for (final Cell[] element : field) {
			for (final Cell element2 : element) {
				if (element2.isAlive()) System.out.print(" 1 ");
				else
					System.out.print(" 0 ");
			}
			System.out.println("");
		}
		System.out.println("=====================================================");

	}

	public void update() {

		for (int i = 1; i < field.length - 1; ++i) {
			for (int j = 1; j < field[i].length - 1; ++j) {

				checkLifeCondition(field[i][j]);
			}
		}
	}

}
