package unionFind.Precolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation2 {
	
	// We will be having a top and bottom box, so that we donot need to check all elements in top and bottom grid
	// if they have same roots.
	// Here in this approach, we union the top row to TOP and bottom to BOTTOM. Hence we only need to check if
	// TOP and BOTTOM have same roots.

    private static final int TOP = 0;
    private final boolean[][] opened;
    private final int size;
    private final int bottom;
    private int openSites;
    private final WeightedQuickUnionUF qf;

    /**
     * Creating an N by N grid
     * Matrix Dimension => size x size
     * Virtual Box => 2
     * Initial Matrix => Blocked
     **/

    public Percolation2(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2); // Creates a parent array with S*S+2
        opened = new boolean[size][size];
        openSites = 0;
    }

    /**
     * Open box (row i and col j) if not opened
     * Box Opened if value => true
     * Box closed if value => false
     */

    public void open(int row, int col) {
        checkException(row, col);
        opened[row - 1][col - 1] = true; // Open the box
        ++openSites; // Incrementing the number of open sites

        // Edge Case => If any of the top row boxes are opened => Union(box, top)
        if (row == 1) {
            qf.union(getQuickFindIndex(row, col), TOP); // If Row and Col = 1, then index = 1, where Top = 0
            // Those 2 get connected like a tree with root value being 1 in this case. But generally, the root with 
            // highest rank
        }

        // Edge Case => If any of the bottom row boxes are opened => Union(box, bottom)
        if (row == size) {
            qf.union(getQuickFindIndex(row, col), bottom);
        }

        // If any of the boxes in the middle rows (except top and bottom) are opened then check for neighbouring unions
        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row - 1, col));
        }

        if (row < size && isOpen(row + 1, col)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row + 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col - 1));
        }

        if (col < size && isOpen(row, col + 1)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col + 1));
        }
    }

    /**
     * Checks Illegal Argument Exception
     */

    private void checkException(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Check if the selected box is open of now
     * Return Type => Boolean
     */

    public boolean isOpen(int row, int col) {
        checkException(row, col);
        return opened[row - 1][col - 1];
    }

    /**
     * Returns the total number of open sites
     */
    public int numberOfOpenSites() {
        return openSites;
    }

    /**
     * If the whole area is full
     * Return Type => Boolean
     */

    public boolean isFull(int row, int col) {
        if ((row > 0 && row <= size) && (col > 0 && col <= size)) {
            return qf.find(TOP) == qf.find(getQuickFindIndex(row, col));
        } else throw new IllegalArgumentException();
    }

    /**
     * Retrieves the index of the box from the matrix
     */

    private int getQuickFindIndex(int row, int col) {
        return size * (row - 1) + col;
    }

    /**
     * Does the system percolates
     * Return Type => Boolean
     */

    public boolean percolates() {
        return qf.find(TOP) == qf.find(bottom); // If top is connected to bottom, then system percolates
    }
    
  //Main function
    public static void main(String[] args) {
        
    }

}
