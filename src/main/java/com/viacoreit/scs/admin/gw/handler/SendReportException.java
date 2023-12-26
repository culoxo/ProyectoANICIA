package com.viacoreit.scs.admin.gw.handler;

/**
 * Excepción lanzada cuando el la respuesta del servicio web de envío de informes es errónea
 */
public class SendReportException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public SendReportException(String message) {
        super(message);
    }
}
