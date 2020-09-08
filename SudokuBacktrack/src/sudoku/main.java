package sudoku;
import static sudoku.Sudoku.IN_SUDOKU;

/**
 *
 * @author Daniel Torres
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Sudoku sudoku = new Sudoku(IN_SUDOKU);
		System.out.println("Sudoku a resolver");
		sudoku.display();
		
		// Solucionar Sudoku
		if (sudoku.solve()) {
			System.out.println("Sudoku solucionado");
			sudoku.display();
		} else {
			System.out.println("No tiene solucion");
		}
    }
    
}
