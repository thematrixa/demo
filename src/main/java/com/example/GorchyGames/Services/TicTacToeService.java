package com.example.GorchyGames.Services;

import org.springframework.stereotype.Service;

@Service
public class TicTacToeService {
	
	private int[][] test = new int[3][3];
	
	public int[][] getTest(){
		
		for(int i =0;i<3;i++){
			for(int j =0;j<3;j++){
				test[i][j] = 1;
			}
		}
		return test;
	}

}
