
package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context  = 
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        
        String[] beanNames = context.getBeanDefinitionNames();
        for(String bean : beanNames) {
            System.out.println("bean = " + bean);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);

        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1 가지고 있는 상품 : " + cart1.getItem());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2 가지고 있는 상품 : " + cart2.getItem());

        System.out.println("cart1 의 hashcode : " + cart1.hashCode());
        System.out.println("cart2 의 hashcode : " + cart2.hashCode());

    }
    
}
