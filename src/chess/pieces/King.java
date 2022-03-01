package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece
{

	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch)
	{

		super(board, color);
		this.chessMatch = chessMatch;
	}

	private boolean canMove(Position position)
	{

		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}

	@Override
	public String toString()
	{

		return "K";
	}

	private boolean testRookCastling(Position position)
	{

		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves()
	{

		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position newPosition = new Position(0, 0);

		// above
		newPosition.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(newPosition) && canMove(newPosition))
		{
			matrix[newPosition.getRow()][newPosition.getColumn()] = true;
		}
		// left
		newPosition.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(newPosition) && canMove(newPosition))
		{
			matrix[newPosition.getRow()][newPosition.getColumn()] = true;
		}
		// right
		newPosition.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(newPosition) && canMove(newPosition))
		{
			matrix[newPosition.getRow()][newPosition.getColumn()] = true;
		}
		// below
		newPosition.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(newPosition) && canMove(newPosition))
		{
			matrix[newPosition.getRow()][newPosition.getColumn()] = true;
		}
		// nw
		newPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(newPosition) && canMove(newPosition))
		{
			matrix[newPosition.getRow()][newPosition.getColumn()] = true;
		}
		// ne
		newPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(newPosition) && canMove(newPosition))
		{
			matrix[newPosition.getRow()][newPosition.getColumn()] = true;
		}
		// sw
		newPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(newPosition) && canMove(newPosition))
		{
			matrix[newPosition.getRow()][newPosition.getColumn()] = true;
		}
		// se
		newPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(newPosition) && canMove(newPosition))
		{
			matrix[newPosition.getRow()][newPosition.getColumn()] = true;
		}
		//#Specialmove Castling
		if (getMoveCount() == 0 && !chessMatch.getCheckMate())
		{
			//specialmove Castling kingside rook
			Position rightRook = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(rightRook))
			{
				Position firstPositionToRight = new Position(position.getRow(), position.getColumn() + 1);
				Position secondPostionToRight = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(firstPositionToRight) == null && getBoard().piece(secondPostionToRight) == null)
				{
					matrix[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			//specialmove Castling kingside rook
			Position leftRook = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(leftRook))
			{
				Position firstPositionToLeft = new Position(position.getRow(), position.getColumn() - 1);
				Position secondPostionToLeft = new Position(position.getRow(), position.getColumn() - 2);
				Position thirdPositionToLeft = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(firstPositionToLeft) == null && getBoard().piece(secondPostionToLeft) == null && getBoard().piece(thirdPositionToLeft) == null)
				{
					matrix[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}

		return matrix;
	}

}
