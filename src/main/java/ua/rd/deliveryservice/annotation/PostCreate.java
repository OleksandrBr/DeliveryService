/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.rd.deliveryservice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author obriukhovych
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PostCreate { 
    //String info() default "";
}


    // атрибут у аннотации info
    // example @PostCreate(info = "Vasya") - using
    // processing:
    //PostCreate var = method.getAnnotation(PostCreate.class);
    //String info = var.info();  