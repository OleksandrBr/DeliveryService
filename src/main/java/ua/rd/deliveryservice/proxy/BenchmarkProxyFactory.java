/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.rd.deliveryservice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import ua.rd.deliveryservice.infrastructure.Benchmark;

/**
 *
 * @author obriukhovych
 */
public class BenchmarkProxyFactory {
    public static Object checkForBenchmarkAndGetProxy(Object o) {
        Method[] methods = o.getClass().getMethods();

        for (Method method: methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                return getBenchmarkProxy(o);
            }
        }

        return o;
    }

    public static Object getBenchmarkProxy(final Object o) {
        return  Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Method m = o.getClass().getMethod(method.getName(), method.getParameterTypes());
                if (m.isAnnotationPresent(Benchmark.class)) {
                    System.out.println("Method '" + method.getName() + "' have started working.");
                    long start = System.nanoTime();
                    Object result =  method.invoke(o, args);
                    System.out.println("Method '" + method.getName() + "' have finished working.\n" +
                            "Total time: " + (System.nanoTime() - start) + " nanoseconds") ;
                    return result;
                } else {
                    return method.invoke(o, args);
                }
            }
        });
    }
}
