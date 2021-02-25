package edu.escuelaing.arep.picospring;

import edu.escuelaing.arep.httpserver.HttpServer;
import edu.escuelaing.arep.httpserver.Process;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class PicoSpringBoot implements Process {
    private static PicoSpringBoot _instace = new PicoSpringBoot();
    private Map<String, Method> requesProcessors = new HashMap<>();
    private HttpServer hserver;

    private PicoSpringBoot(){

    }

    public static PicoSpringBoot getInstance(){
        return _instace;
    }

    public void loadCompoents(String[] componentsList) throws ClassNotFoundException {
        for(String componentName: componentsList){
           loadComponent(componentName);
        }
    }

    private void loadComponent(String componentName) throws ClassNotFoundException {
        Class componentClass = Class.forName(componentName);
        Method[] ComponentMethods = componentClass.getDeclaredMethods();
        for(Method m: ComponentMethods){
            if(m.isAnnotationPresent(RequestMapping.class)){
                requesProcessors.put(m.getAnnotation(RequestMapping.class).value(),m);
            }
        }
    }

    @Override
    public String handle(String path, HttpRequest req, HttpResponse res) {
        String resp="";
        if(requesProcessors.containsKey(path)){
            try {
                resp=requesProcessors.get(path).invoke(null,null).toString();
                System.out.println(resp);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return resp;
    }

    public void startServer() throws IOException {
        hserver = new HttpServer();
        hserver.regiserProcess("/springapp",this);
        hserver.startServer(8080);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] l1=new String[1];
        l1[0]="edu.escuelaing.arep.picospring.demo.DemoApi";

        PicoSpringBoot.getInstance().loadCompoents(l1);
        PicoSpringBoot.getInstance().startServer();
    }
}
