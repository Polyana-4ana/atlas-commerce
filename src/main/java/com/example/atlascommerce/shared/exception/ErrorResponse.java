package com.example.atlascommerce.shared.exception;

import java.time.LocalDateTime;

public record ErrorResponse(

    int status,
    String message,
    String error,
    String path,
    LocalDateTime timestamp

    )
{

}

