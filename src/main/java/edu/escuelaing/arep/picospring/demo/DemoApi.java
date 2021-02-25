package edu.escuelaing.arep.picospring.demo;


import edu.escuelaing.arep.picospring.RequestMapping;

public class DemoApi{

    @RequestMapping("/index")
    public static String index() {
        return "index.html";
    }

    @RequestMapping("/azure")
    public static String azure() {
        return "Azure-Logo.jpg";
    }

    @RequestMapping("/help")
    public static String help() {
            return "Ayuda para el uso de la aplicacion ";
    }



}
