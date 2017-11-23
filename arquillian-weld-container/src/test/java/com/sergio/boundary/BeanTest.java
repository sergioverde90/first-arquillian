package com.sergio.boundary;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class BeanTest {

    @Inject
    Bean bean;

    @Deployment
    public static WebArchive createJavaTestArchive() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage("com.sergio.boundary")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void convertToCelsius() {
        String salute = bean.sayHello();
        assertEquals("hello", salute);
    }
}