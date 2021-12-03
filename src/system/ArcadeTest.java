package system;

import games.*;
import people.*;
import screen.*;

public class ArcadeTest {
	public static void main(String[] args) {
		//Boot arcade
		Arcade arc = new Arcade();
		
		//Create profile
		Player p1 = new Player("Jason");
		arc.addUser(p1);
		Player p2 = new Player("Haseeb");
		arc.addUser(p2);
		Player p3 = new Player("Patrick");
		arc.addUser(p3);
		
		//Create guest
		Guest g1 = new Guest();
		arc.addUser(g1);
		
		// Game library
		LibraryScreen libscr = new LibraryScreen();
		LeaderboardScreen leadscr = new LeaderboardScreen();
		
		//Add games to library
		TicTacToe ttt = new TicTacToe();
		ttt.setName("TicTacToe");
		libscr.addGame(ttt);
		
		//Play tictactoe game
		libscr.playGame(ttt, p1, leadscr);
		
		
		
		
	}
}
