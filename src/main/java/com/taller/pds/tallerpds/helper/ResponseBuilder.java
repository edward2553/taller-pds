package com.taller.pds.tallerpds.helper;

import com.taller.pds.tallerpds.model.Response;
import static org.springframework.http.HttpStatus.*;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    public Response success(){
        return Response.builder()
                .code(OK.value())
                .data(OK.value())
                .build();
    }

    public Response success(Object data){
        return Response.builder()
                .code(OK.value())
                .data(data)
                .build();
    }

    public Response successCeated(Object data){
        return Response.builder()
                .code(CREATED.value())
                .data(data)
                .build();
    }

    public Response failed(Object data){
        return Response.builder()
                .code(BAD_REQUEST.value())
                .data(data)
                .build();
    }

}
