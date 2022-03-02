package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece
{

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch)
	{

		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves()
	{

		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position newPosition = new Position(0, 0);
		if (getColor() == Color.WHITE)
		{
			// above
			newPosition.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			newPosition.setValues(position.getRow() - 2, position.getColumn());
			Position forwardPosition = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition) && getBoard().positionExists(forwardPosition) && !getBoard().thereIsAPiece(forwardPosition) && getMoveCount() == 0)
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			newPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			newPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			//Specialmove En Passant White
			if (position.getRow() == 3)
			{
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable())
				{
					matrix[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable())
				{
					matrix[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		}
		else
		{

			newPosition.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			newPosition.setValues(position.getRow() + 2, position.getColumn());
			Position forwardPosition = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition) && getBoard().positionExists(forwardPosition) && !getBoard().thereIsAPiece(forwardPosition) && getMoveCount() == 0)
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			newPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			newPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			//Specialmove En Passant Black
			if (position.getRow() == 4)
			{
				Position left = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable())
				{
					matrix[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable())
				{
					matrix[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		return matrix;

	}

	@Override
	public String toString()
	{

		return "P";
	}
}
