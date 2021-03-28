package gt.edu.url.implementation;

import gt.edu.url.adapter.Board;
import gt.edu.url.adapter.Piece;

import java.util.Random;

public class Minimax {
    // Encuentra la mejor utilidad para el jugador originalPlayer
    public static <Move> double minimax(Board<Move> board, boolean maximizing, Piece originalPlayer, int maxDepth) {
        var legalMoves = board.getLegalMoves();

        //Condiciones de salida
        if (board.isWin()) {
            return board.evaluate(originalPlayer);
        }
        if(board.isDraw()){
            return 0;
        }
        if(maxDepth <= 0){
            return 0;
        }
        if(legalMoves.size() == 0){
            return 0;
        }
        //Maximizando
        if (maximizing) {
            double bestVal = Double.NEGATIVE_INFINITY;
            for (var move : legalMoves) {
                double result =
                        minimax(board.move(move), false, originalPlayer, maxDepth - 1);
                bestVal = Math.max(result, bestVal);
            }
            return bestVal;
        }
        //Minimizando
        else {
            double bestVal = Double.POSITIVE_INFINITY;
            for (var move : legalMoves) {
                double result =
                        minimax(board.move(move), true, originalPlayer, maxDepth - 1);
                bestVal = Math.min(result, bestVal);
            }
            return bestVal;
        }
    }

    public static <Move> Move findBestMove(Board<Move> board, int maxDepth) {
        double bestEval = Double.NEGATIVE_INFINITY;
        Move bestMove = null; // won't stay null for sure
        for (Move move : board.getLegalMoves()) {
            double result = minimax(board.move(move), false, board.getTurn(),
                    maxDepth);
            if (result > bestEval) {
                bestEval = result;
                bestMove = move;
            }
        }
        return bestMove;
    }
}
