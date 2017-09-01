package com.xpediantsolutions;

public class ShapeImpl implements Shape {
	private int size;
	private char borderChar;
	private char centerChar;
	private char[][] charArr = null;

	public void draw() {
		initialize();
		//printArr();
		trim();
		//printArr();
		postprocess();
		printArr();
		
		drawRing( 1 , 'X');
		
	}

	private void printArr(){
		for (int i=0;i<charArr.length;i++) {
			for (int j=0;j<charArr[i].length; j++) 
				System.out.print(charArr[i][j]);
			System.out.println();
		}
	}

	private void trim() {
		int temp = size - 1,tempV = 1;
		for (int i = 0; i < size * 2 + 1; i++) {
			if (i < size) {
				for (int j = 0; j < (size - i); j++) 
					charArr[i][j] = ' ';
				for (int k = size + 1 + i; k < size * 2 + 1; k++) 
					charArr[i][k] = ' ';
			} else if (i > size) {
				for (int j = 0; j < size - temp; j++) 
					charArr[i][j] = ' ';
				for (int k = size * 2; k > size * 2 - tempV; k--) 
					charArr[i][k] = ' ';				
				temp--;
				tempV++;
			}
		}
	}

	
	private void postprocess() {
		int specialIter = 0;
		char prvChar=' ',nxtChar=' ';
		
		for (int i=0;i<size*2 + 1; i++) {
			if (i == 0) continue;
			for (int j=0;j<size*2+1;j++) {
					if (charArr[i][j] == borderChar)
						specialIter++;
					if (specialIter%2 == 0) {
						charArr[i][j] = ' ';
					}					
					if(i>1){
						if(charArr[i][j] == borderChar || charArr[i][j] == centerChar)  {
							prvChar = charArr[i][j];
						}
						if(j+1<=size*2 && (charArr[i][j] == borderChar || charArr[i][j] == centerChar) ){ 
							nxtChar = charArr[i][j+1];
						}
						System.out.print("["+prvChar+"]-["+nxtChar+"]");
					}
				}
			System.out.println();
			specialIter = 0;
		}
	}

	private void initialize() {
		charArr = new char[size * 2 + 1][size * 2 + 1];
		for (int i = 0; i < size * 2 + 1; i++) {
			for (int j = 0; j < size * 2 + 1; j++) {
				charArr[i][j] = borderChar;
			}
		}
	}
	
	public ShapeImpl(int size, char borderChar, char centerChar) {
		this.size = size;
		this.borderChar = borderChar;
		this.centerChar = centerChar;
	}
	
	private void drawRing(int size,char drawChar){
		for(int i=0;i<size*2+1;i++){
			for(int j=0;j<size*2+1;j++)
				System.out.print("A");
			System.out.println();
		}
		
		char[][] charArr = new char[size*2+1][size*2+1];
		
		int temp = size - 1,tempV = 1;
		for (int i = 0; i < size * 2 + 1; i++) {
			if (i<size) {
				for (int j = 0; j<(size-i); j++) 
					charArr[i][j] = ' ';
				for (int k = size + 1 + i;k<size * 2 + 1; k++) 
					charArr[i][k] = ' ';
			} 
			else if (i>size) {
				for (int j=0;j<size-temp;j++) 
					charArr[i][j] = ' ';
				for (int k=size*2;k>size*2-tempV; k--) 
					charArr[i][k] = ' ';				
				temp--;
				tempV++;
			}
		}
	}
}
