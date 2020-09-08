package sudoku;

/**
 *
 * @author Daniel Torres
 */
public class Sudoku {

    // Array a resolver
    public static int[][] IN_SUDOKU = {
        {9, 0, 0, 1, 0, 0, 0, 0, 5},
        {0, 0, 5, 0, 9, 0, 2, 0, 1},
        {8, 0, 0, 0, 4, 0, 0, 0, 0},
        {0, 0, 0, 0, 8, 0, 0, 0, 0},
        {0, 0, 0, 7, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 6, 0, 0, 9},
        {2, 0, 0, 3, 0, 0, 0, 0, 6},
        {0, 0, 0, 2, 0, 0, 9, 0, 0},
        {0, 0, 1, 9, 0, 4, 5, 7, 0},};

    private int[][] board;
    public static final int EMPTY = 0; // Celda vacía
    public static final int SIZE = 9; // Tamaño del sudoku

    public Sudoku(int[][] board) {
        this.board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    // Combina metodos para validar el numero puesto en una casilla
    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
    }
    
    // Revisa si existe el numero en la fila
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    // Revisa si existe el numero en la columna
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    // Revisa si existe el numero en la caja 3x3
    private boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
    * Metodo de BackTracking y Recursividad
    * Prueba un numero en una casilla, si retorna Ok, se llama a si mismo para
    * buscar el siguiente numero, cuando no encuentra un numero posible se 
    * devuelve y prueba con el siguiente numero.
    */
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // Busca una celda vacia
                if (board[row][col] == EMPTY) {
                    // Prueba posibles numeros
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOk(row, col, number)) {
                            // Si el numero es correcto lo pone en la celda
                            board[row][col] = number;
                            if (solve()) { // Empieza Backtraking Recursivo
                                return true;
                            } else { // Si no hay una solición vacía la celda y continua.
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false; 
                }
            }
        }
        return true; // Sudoku resuelto
    }
    
    //Metodo para imprimir en consola
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
