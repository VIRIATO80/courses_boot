package com.viriato.courses.errorhandling;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class BadRequestExceptionMapper implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(prepareMessage(exception))
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
 
    private ErrorMessage prepareMessage(ConstraintViolationException exception) {
        ErrorMessage message = new ErrorMessage();
        message.setStatus(Status.BAD_REQUEST.getStatusCode());
        String violations="";
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            violations +=  cv.getMessage() + ". ";
        }
        message.setMessage(violations);
        return message;
    }
}
