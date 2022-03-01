package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece
{

	public Knight(Board board, Color color)
	{

		super(board, color);
	}
	private boolean canMove(Position position)
	{

		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves()
	{

		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position newPosition = new Position(0, 0);

		if (getColor() == Color.WHITE)
		{
			// above - right
			newPosition.setValues(position.getRow() - 2, position.getColumn() + 1);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// above - left
			newPosition.setValues(position.getRow() - 2, position.getColumn() - 1);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// left - below
			newPosition.setValues(position.getRow() - 1, position.getColumn() - 2);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// left - above
			newPosition.setValues(position.getRow() + 1, position.getColumn() - 2);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// right - above
			newPosition.setValues(position.getRow() + 1, position.getColumn() + 2);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// right - below
			newPosition.setValues(position.getRow() - 1, position.getColumn() + 2);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// below - right
			newPosition.setValues(position.getRow() + 2, position.getColumn() + 1);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// below - left
			newPosition.setValues(position.getRow() + 2, position.getColumn() - 1);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
		}
		else
		{
			// above - right
			newPosition.setValues(position.getRow() + 2, position.getColumn() - 1);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// above - left
			newPosition.setValues(position.getRow() + 2, position.getColumn() + 1);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// left - below
			newPosition.setValues(position.getRow() + 1, position.getColumn() + 2);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// left - above
			newPosition.setValues(position.getRow() - 1, position.getColumn() + 2);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// right - above
			newPosition.setValues(position.getRow() - 1, position.getColumn() - 2);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// right - below
			newPosition.setValues(position.getRow() + 1, position.getColumn() - 2);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// below - right
			newPosition.setValues(position.getRow() - 2, position.getColumn() - 1);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
			// below - left
			newPosition.setValues(position.getRow() - 2, position.getColumn() + 1);
			if (getBoard().positionExists(newPosition) && canMove(newPosition))
			{
				matrix[newPosition.getRow()][newPosition.getColumn()] = true;
			}
		}
		return matrix;
	}

	@Override
	public String toString()
	{

		return "N";
	}

}
