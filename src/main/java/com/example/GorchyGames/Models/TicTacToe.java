package com.example.GorchyGames.Models;


public class TicTacToe {
	
	private Boolean[][] game = new Boolean[3][3];
	private Boolean winner = null;
	
	
	public void setTile(Boolean value, int x, int y) {
		game[x][y] = value;
	}
	
	public Boolean getTile(int x, int y) {
		return game[x][y];
	}
	
	public Boolean isGameFinished() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(game[i][j].equals(true) || game[i][j].equals(false)) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public Boolean checkForWinner(Boolean value) {
		
		Boolean firstValue = null;
		Boolean secondValue = null;
		Boolean thirdValue = null;
		
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				if(firstValue == null) {
					firstValue = game[x][y];
					continue;
				}
				if(secondValue == null) {
					secondValue = game[x][y];
					continue;
				}
				if(thirdValue == null) {
					thirdValue = game[x][y];
				}
				if(firstValue.equals(secondValue) && secondValue.equals(thirdValue)) {
					winner = firstValue;
					return true;
				}
				else {
					firstValue = null;
					secondValue = null;
					thirdValue = null;
				}
				
			}
		}
		
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				if(firstValue == null) {
					firstValue = game[y][x];
					continue;
				}
				if(secondValue == null) {
					secondValue = game[y][x];
					continue;
				}
				if(thirdValue == null) {
					thirdValue = game[y][x];
				}
				if(firstValue.equals(secondValue) && secondValue.equals(thirdValue)) {
					winner = firstValue;
					return true;
				}
				else {
					firstValue = null;
					secondValue = null;
					thirdValue = null;
				}
			}
		}
		
		if(game[1][1].equals(game[0][0]) && game[1][1].equals(game[2][2])){
			winner = game[1][1]; 
			return true;
		}
		if(game[1][1].equals(game[0][2]) && game[1][1].equals(game[2][0])){
			winner = game[1][1];
			return true;
		}
		
		return false;
		
	}
	
	public Boolean getWinner() {
		return winner;
	}
}
