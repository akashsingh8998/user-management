package com.sapient.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

 

import com.sapient.user_management.UserManagementApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes=UserManagementApplication.class)
public class BatchCategoryTests {
    
    
    @Test
    public void checkAllArgsConstructor() {
        BatchCategory batch = new BatchCategory(1, null, null);
        Integer num=1;
        Assert.assertEquals(num, batch.getBatchCategoryId());
        Assert.assertEquals(null,batch.getBatch());
        Assert.assertEquals(null,batch.getCategory());
        
    }
    
    @Test
    public void noAllArgsConstructor() {
        BatchCategory batch = new BatchCategory();
        Assert.assertEquals(null, batch.getBatchCategoryId());
        Assert.assertEquals(null,batch.getBatch());
        Assert.assertEquals(null,batch.getCategory());
        
    }
    
    
        @Test
        public void checkSetter() {
            BatchCategory batch = new BatchCategory();
            batch.setBatchCategoryId(1);
            batch.setBatch(null);
            batch.setCategory(null);
            Integer num=1;
            Assert.assertEquals(num, batch.getBatchCategoryId());
            Assert.assertEquals(null,batch.getCategory());
            Assert.assertEquals(null,batch.getBatch());
            
        }
}