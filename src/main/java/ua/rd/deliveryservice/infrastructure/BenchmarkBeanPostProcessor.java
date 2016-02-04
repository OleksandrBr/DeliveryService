/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.rd.deliveryservice.infrastructure;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * @author obriukhovych
 */
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return BenchmarkProxyFactory.checkForBenchmarkAndGetProxy(o);
    }
}
