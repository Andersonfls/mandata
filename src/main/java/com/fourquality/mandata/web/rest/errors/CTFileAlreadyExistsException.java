package com.fourquality.mandata.web.rest.errors;

public class CTFileAlreadyExistsException extends BadRequestAlertException {

    public CTFileAlreadyExistsException(){
        super(ErrorConstants.DEFAULT_TYPE, "File already exists", "arquivo", "fileexists");
    }
}
