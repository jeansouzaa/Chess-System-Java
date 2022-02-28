package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program
{

	public static void main(String[] args)
	{

		ChessMatch chessMatch = new ChessMatch();
		Scanner scanner = new Scanner(System.in);

		while (true)
		{
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(scanner);
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(scanner);
	
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch(ChessException chessException) {
				System.out.println(chessException.getMessage());
				scanner.nextLine();
			}
			catch(InputMismatchException inputMismatchException) {
				System.out.println(inputMismatchException.getMessage());
				scanner.nextLine();
			}
		}
	}

}
