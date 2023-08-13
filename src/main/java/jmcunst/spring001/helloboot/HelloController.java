package jmcunst.spring001.helloboot;

public class HelloController {
    public String hello(String name){
        return "Hello " + name;
    }
}