package com.xpediantsolutions;

public class ShapeImpl implements Shape {
	private int size;
	private char borderChar;
	private char centerChar;

	public void draw() {
		char[][] charArr = new char[size * 2 + 1][size * 2 + 1];
		for (int i = size==0?1:size, j = 0; i > 0; i = i - 2) {
			drawChild(charArr, i, size, j%2==0?borderChar : centerChar, j++);
		}
		if(size%2==0)
			massageCharArray(charArr,size,size,-1,(size%4==0)?borderChar:centerChar);
		
		printArr(charArr);
	}

	private void drawChild(char[][] charArr, int runningSize, int size, char charToFill, int ringPos) {
		int rowNum = 0, posFirst = 0, posSecond = 0;
		for (int i = ringPos * 2, j = 0; i < size * 2 + 1 - ringPos * 2; i++, j++) {
			if (j == 0 || j == runningSize * 2) {
				rowNum = i;
				posFirst = size;
				posSecond = -1;
			} else {
				if (j < runningSize) {
					rowNum = i;
					posFirst = size - j;
					posSecond = runningSize + i;
				} else if (j > runningSize) {
					rowNum = i;
					posFirst = runningSize + (i - 2 * runningSize);
					posSecond = size - (j - 2 * runningSize);					
				} else if (j == runningSize) {
					rowNum = i;
					posFirst = size - j;
					posSecond = size + j;
				}
			}
			massageCharArray(charArr, rowNum, posFirst, posSecond, charToFill);
		}
	}

	private void massageCharArray(char[][] charArr, int rowNum, int posFirst, int posSecond, char outChar) {
		if (posSecond >= 0) {
			charArr[rowNum][posFirst] = outChar;
			charArr[rowNum][posSecond] = outChar;
		} else
			charArr[rowNum][posFirst] = outChar;

	}

	private void printArr(char[][] charArr) {
		for (int i = 0; i < charArr.length; i++) {
			for (int j = 0; j < charArr[i].length; j++)
				System.out.print(charArr[i][j]);
			System.out.println();
		}
	}

	public ShapeImpl(int size, char borderChar, char centerChar) {
		this.size = size;
		this.borderChar = borderChar;
		this.centerChar = centerChar;
	}
}
