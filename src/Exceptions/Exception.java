package Exceptions;

public class Exception {
    public static class InvalidBoardException extends RuntimeException{

        public InvalidBoardException(String message){
            super(message);
        }

    }

    public static class BlockedCellException extends RuntimeException{
        public BlockedCellException(String message){
            super(message);
        }
    }
}
