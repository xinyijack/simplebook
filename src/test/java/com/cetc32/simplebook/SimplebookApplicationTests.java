package com.cetc32.simplebook;

import org.junit.jupiter.api.Test;
import com.cetc32.simplebook.beans.StoreProperties;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SimplebookApplicationTests {

    @Autowired
    StoreProperties store;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void contextloads(){
        System.out.println(store);
    }

}
