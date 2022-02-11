package com.taller.pds.tallerpds.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Verifique los datos que envía")
public class BadRequestException extends RuntimeException {}
