package edu.escuelaing.arep.httpserver;


import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface Process {
    /**
     * Metodo para obtener un valor dados, un path el req y el res
     * @param path direccion que se desea
     * @param req HttpRequest
     * @param res HttpResponse
     * @return String con valor deseado
     */
    public String handle (String path, HttpRequest req, HttpResponse res);
}