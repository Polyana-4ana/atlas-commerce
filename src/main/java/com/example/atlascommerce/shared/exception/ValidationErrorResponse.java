package com.example.atlascommerce.shared.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorResponse(
        int status,
        String error,
        List<ValidationError> errors,
        LocalDateTime timestamp
) {}
