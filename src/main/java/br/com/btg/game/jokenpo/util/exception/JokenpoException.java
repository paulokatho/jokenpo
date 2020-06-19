package br.com.btg.game.jokenpo.util.exception;

import org.springframework.http.HttpStatus;

import br.com.btg.game.jokenpo.enumeration.EnumException;

@SuppressWarnings("serial")
public class JokenpoException extends Exception {

    public JokenpoException(EnumException enumException, HttpStatus badRequest){
        super(enumException.getCode() + " - " + enumException.getMessage());
    }

    public JokenpoException(String errorMessage){
        super(errorMessage);
    }
}
