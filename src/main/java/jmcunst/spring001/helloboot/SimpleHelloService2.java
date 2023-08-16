package jmcunst.spring001.helloboot;

public class SimpleHelloService2 implements HelloService{
    public String sayHello(String name){
        return "Hello " + name;
    }
}
