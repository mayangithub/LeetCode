package edu.pitt.hashtable;

/**
 * Valid Sudoku #36
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need 
 * to be validated. 
 * 
 * @author yanma
 * @since 2015-03-06
 * @version 2014-03-06
 */
public class ValidSudoku_36 {
	
	/**
	 * Thoughts:
	 * 1. go through all rows and columns 
	 * 2. create a hashtable for each row or column
	 * 3. key is from 0 to 8, default value is false
	 * 4. for each element, not '.', find the key and change the value to true
	 * 5. if the element is not '.' and the value in the hashtable is already true, return false directly
	 * 6. go after each row and column, test each 3*3 block
	 * 7. column and row from 0-2, increment is 3 each time
	 * 
	 * **
	 * 1. not an integer in the board
	 * 2. the integer is out of bound
	 * 3. board[row][col] is a char
	 * 4. char to int, Character.getNumericValue(char)
	 */
	
	
	/**
	 * Method using hashtable
	 * @param board
	 * @return
	 * 
	 * Accepted 539ms
	 */
	public static boolean isValidSudoku(char[][] board) {
        if (board == null) {
        	return false;
        }
        
        java.util.Hashtable<Integer, Boolean> hashtable = new java.util.Hashtable<Integer, Boolean>();
        
        for (int row = 0; row < 9; row++) {
        	Integer index;
            Boolean falsebBoolean = Boolean.valueOf(false);
            for (int i = 1; i <= 9; i++) {
            	index = Integer.valueOf(i);
            	hashtable.put(index, falsebBoolean);
            }
            
        	for (int col = 0; col < 9; col++) {

        		if (board[row][col] != '.' && Character.getNumericValue(board[row][col]) >= 1 
        				&& Character.getNumericValue(board[row][col]) <= 9) {
        			Integer keyInteger = Integer.valueOf(Character.getNumericValue(board[row][col]));
        			System.out.println("row:" + row + " col: "+ col );
        			if (hashtable.get(keyInteger).booleanValue() == true) {
        				return false;
        			} else {
						hashtable.put(keyInteger, Boolean.valueOf(true));
					}
        		} else if (board[row][col] != '.' && (Character.getNumericValue(board[row][col]) < 1 
        				|| Character.getNumericValue(board[row][col]) > 9)) {
        			return false;
        		} 
        	}
        } // end row for loop
		
        for (int col = 0; col < 9; col++) {
        	Integer index;
            Boolean falsebBoolean = Boolean.valueOf(false);
            for (int i = 1; i <= 9; i++) {
            	index = Integer.valueOf(i);
            	hashtable.put(index, falsebBoolean);
            }
            
        	for (int row = 0; row < 9; row++) {
        		if (board[row][col] != '.'  && Character.getNumericValue(board[row][col]) >= 1 
        				&& Character.getNumericValue(board[row][col]) <= 9) {
        			Integer keyInteger = Integer.valueOf(Character.getNumericValue(board[row][col]));
        			if (hashtable.get(keyInteger).booleanValue() == true) {
        				return false;
        			} else {
						hashtable.put(keyInteger, Boolean.valueOf(true));
					}
        		} else if (board[row][col] != '.' && (Character.getNumericValue(board[row][col]) < 1 
        				|| Character.getNumericValue(board[row][col]) > 9)) {
        			return false;
        		}
        	}
        } // end col for loop
        
    	for (int row = 0; row < 9; row = row + 3) {
        	for (int col = 0; col < 9; col = col + 3) {
        		Integer index;
		        Boolean falsebBoolean = Boolean.valueOf(false);
		        for (int k = 1; k <= 9; k++) {
		        	index = Integer.valueOf(k);
		        	hashtable.put(index, falsebBoolean);
		        } // initial hashtable
		        
		        for (int i = row; i < row + 3; i++) {
		        	for (int j = col; j < col + 3; j++) {
		        		 if (board[i][j] != '.'  && Character.getNumericValue(board[i][j]) >= 1 
		        				&& Character.getNumericValue(board[i][j]) <= 9) {
		        			Integer keyInteger = Integer.valueOf(Character.getNumericValue(board[i][j]));
		        			if (hashtable.get(keyInteger).booleanValue() == true) {
		        				return false;
		        			} else {
								hashtable.put(keyInteger, Boolean.valueOf(true));
							}
		        		} else if (board[i][j] != '.' && (Character.getNumericValue(board[i][j]) < 1 
		        				|| Character.getNumericValue(board[i][j]) > 9)) {
		        			return false;
		        		}
		        	}
		        } // end each 3*3 block
		        
        	} // end 3*3 block for loop - col
        } // end 3*3 block for loop - row
    	
        return true;
		
    }
	
	public static void initialHashTable(java.util.Hashtable<Integer, Boolean> hashtable) {
		Integer index;
        Boolean falsebBoolean = Boolean.valueOf(false);
        for (int i = 1; i <= 9; i++) {
        	index = Integer.valueOf(i);
        	hashtable.put(index, falsebBoolean);
        }
	}
	
	/**
	 * Method using hash table and 
	 * calling another function to initial hash table
	 * @param board
	 * @return
	 * 
	 * Accepted 535ms
	 */
	public static boolean isValidSudoku1(char[][] board) {
        if (board == null) {
        	return false;
        }
        
        java.util.Hashtable<Integer, Boolean> hashtable = new java.util.Hashtable<Integer, Boolean>();
        
        for (int row = 0; row < 9; row++) {
        	initialHashTable(hashtable);
            
        	for (int col = 0; col < 9; col++) {

        		if (board[row][col] != '.' && Character.getNumericValue(board[row][col]) >= 1 
        				&& Character.getNumericValue(board[row][col]) <= 9) {
        			Integer keyInteger = Integer.valueOf(Character.getNumericValue(board[row][col]));
        			System.out.println("row:" + row + " col: "+ col );
        			if (hashtable.get(keyInteger).booleanValue() == true) {
        				return false;
        			} else {
						hashtable.put(keyInteger, Boolean.valueOf(true));
					}
        		} else if (board[row][col] != '.' && (Character.getNumericValue(board[row][col]) < 1 
        				|| Character.getNumericValue(board[row][col]) > 9)) {
        			return false;
        		} 
        	}
        } // end row for loop
		
        for (int col = 0; col < 9; col++) {
        	initialHashTable(hashtable);
            
        	for (int row = 0; row < 9; row++) {
        		if (board[row][col] != '.'  && Character.getNumericValue(board[row][col]) >= 1 
        				&& Character.getNumericValue(board[row][col]) <= 9) {
        			Integer keyInteger = Integer.valueOf(Character.getNumericValue(board[row][col]));
        			if (hashtable.get(keyInteger).booleanValue() == true) {
        				return false;
        			} else {
						hashtable.put(keyInteger, Boolean.valueOf(true));
					}
        		} else if (board[row][col] != '.' && (Character.getNumericValue(board[row][col]) < 1 
        				|| Character.getNumericValue(board[row][col]) > 9)) {
        			return false;
        		}
        	}
        } // end col for loop
        
    	for (int row = 0; row < 9; row = row + 3) {
        	for (int col = 0; col < 9; col = col + 3) {
        		initialHashTable(hashtable);
		        
		        for (int i = row; i < row + 3; i++) {
		        	for (int j = col; j < col + 3; j++) {
		        		 if (board[i][j] != '.'  && Character.getNumericValue(board[i][j]) >= 1 
		        				&& Character.getNumericValue(board[i][j]) <= 9) {
		        			Integer keyInteger = Integer.valueOf(Character.getNumericValue(board[i][j]));
		        			if (hashtable.get(keyInteger).booleanValue() == true) {
		        				return false;
		        			} else {
								hashtable.put(keyInteger, Boolean.valueOf(true));
							}
		        		} else if (board[i][j] != '.' && (Character.getNumericValue(board[i][j]) < 1 
		        				|| Character.getNumericValue(board[i][j]) > 9)) {
		        			return false;
		        		}
		        	}
		        } // end each 3*3 block
		        
        	} // end 3*3 block for loop - col
        } // end 3*3 block for loop - row
    	
        return true;
		
    }
	
	/**
	 * Method using boolean array
	 * @param board
	 * @return
	 * 
	 * Note: boolean array index 0 to 8
	 * so, Sudoku number should minus 1 first, then compare with boolean array
	 * 
	 * Accepted -- 353ms
	 */
	public static boolean isValidSudoku2(char[][] board) {
        if (board == null) {
        	return false;
        }
        
        boolean[] booleanArray = new boolean[9];
        
        for (int row = 0; row < 9; row++) {
        	java.util.Arrays.fill(booleanArray, false);
        	for (int col = 0; col < 9; col++) {
        		if (board[row][col] != '.' && Character.getNumericValue(board[row][col]) >= 1 
        				&& Character.getNumericValue(board[row][col]) <= 9) {
        			int key = Character.getNumericValue(board[row][col]) - 1;
        			if (booleanArray[key] == true) {
        				return false;
        			} else {
        				booleanArray[key] = true;
					}
        		} else if (board[row][col] != '.' && (Character.getNumericValue(board[row][col]) < 1 
        				|| Character.getNumericValue(board[row][col]) > 9)) {
        			return false;
        		} 
        	}
        } // end row for loop
		
        for (int col = 0; col < 9; col++) {
        	java.util.Arrays.fill(booleanArray, false);
        	for (int row = 0; row < 9; row++) {
        		if (board[row][col] != '.'  && Character.getNumericValue(board[row][col]) >= 1 
        				&& Character.getNumericValue(board[row][col]) <= 9) {
        			int key = Character.getNumericValue(board[row][col]) - 1;
        			if (booleanArray[key] == true) {
        				return false;
        			} else {
        				booleanArray[key] = true;
					}
        		} else if (board[row][col] != '.' && (Character.getNumericValue(board[row][col]) < 1 
        				|| Character.getNumericValue(board[row][col]) > 9)) {
        			return false;
        		}
        	}
        } // end col for loop
        
    	for (int row = 0; row < 9; row = row + 3) {
        	for (int col = 0; col < 9; col = col + 3) {
        		java.util.Arrays.fill(booleanArray, false);
		        
		        for (int i = row; i < row + 3; i++) {
		        	for (int j = col; j < col + 3; j++) {
		        		 if (board[i][j] != '.'  && Character.getNumericValue(board[i][j]) >= 1 
		        				&& Character.getNumericValue(board[i][j]) <= 9) {
		        			int key = Character.getNumericValue(board[i][j]) - 1;
		        			if (booleanArray[key] == true) {
		        				return false;
		        			} else {
		        				booleanArray[key] = true;
							}
		        		} else if (board[i][j] != '.' && (Character.getNumericValue(board[i][j]) < 1 
		        				|| Character.getNumericValue(board[i][j]) > 9)) {
		        			return false;
		        		}
		        	}
		        } // end each 3*3 block
		        
        	} // end 3*3 block for loop - col
        } // end 3*3 block for loop - row
    	
        return true;
		
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] sudukuString1 = {"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
		char[][] board = new char[9][9];
		for (int j = 0; j < 9; j++) {
			for (int index = 0; index < 9; index++) {
				board[j][index] = sudukuString1[j].charAt(index);
			}
		}
		
		String[] sudukuString = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char[][] board1 = new char[9][9];
		for (int j = 0; j < 9; j++) {
			for (int index = 0; index < 9; index++) {
				board1[j][index] = sudukuString[j].charAt(index);
			}
		}
		
		String[] sudukuStrings = {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
		char[][] board2 = new char[9][9];
		for (int j = 0; j < 9; j++) {
			for (int index = 0; index < 9; index++) {
				board2[j][index] = sudukuStrings[j].charAt(index);
			}
		}
		
		
		
		
		System.out.println("result: " + isValidSudoku2(board));
		
	}

}
