package com.taller.pds.tallerpds.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No se encontró el recurso por el cual se realizó la peticion")
public class NotFoundException extends RuntimeException {}
