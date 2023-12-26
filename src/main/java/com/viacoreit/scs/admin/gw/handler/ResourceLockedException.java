package com.viacoreit.scs.admin.gw.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.LOCKED)
public class ResourceLockedException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -808900342754786264L;

    public ResourceLockedException(String message) {
        super(message);
    }
}
