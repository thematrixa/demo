package com.example.GorchyGames.Controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GorchyGames.Services.TicTacToeService;
@RestController
public class TicTacToeController {
	
	
	/*to do
	 * 
	 * somehow to store games.
	 * somehow to remember people
	 * somehow to recognize new people from connected ones
	 * 
	 * 
	 * */
	
	@Autowired
	private TicTacToeService ticTacToeService;
	
	@RequestMapping("/games/newGame/tictactoe")
	public int[][] getTest(){
		return ticTacToeService.getTest();
	}
	
	@RequestMapping("/games/newGame/tictactoe/connect")
	public void initGame(){
		
		while(true){
			ServerSocket ss = null;
			try {
				ss = new ServerSocket(1251);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        Socket clientSocket = null;
	        try {
	            clientSocket = ss.accept();
	        } catch (IOException e) {
	            {
	                System.out.println("Server Stopped.") ;
	                return;
	            }
	        }
	        	        
	    }
		
	}
	
	@RequestMapping("/games/newGame/tictactoe/play")
	public void play(){
		
	}
	
}
