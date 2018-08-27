package labirinto;

public class LabirintoCaminho {
	
	private int row;
	
	private int column;
	
	private LabirintoCaminho anterior;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public LabirintoCaminho getAnterior() {
		return anterior;
	}

	public void setAnterior(LabirintoCaminho anterior) {
		this.anterior = anterior;
	}

}
