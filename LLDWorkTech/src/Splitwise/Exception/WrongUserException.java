package Splitwise.Exception;

import Splitwise.Model.User;

public class WrongUserException extends Exception{
    public WrongUserException(String message) {
        super(message);
    }
}
