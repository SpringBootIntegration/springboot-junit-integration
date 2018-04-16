/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.edurt;

import com.edurt.bean.JunitJDBCBean;
import com.edurt.service.JunitJDBCBeanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * JunitJDBCBeanServiceTest <br/>
 * 描述 : JunitJDBCBeanServiceTest <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-09 下午10:30 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitJDBCBeanServiceTest {

    @Autowired
    private JunitJDBCBeanService service;

    @Test
    public void test1() {
        JunitJDBCBean bean = new JunitJDBCBean();
        bean.setTitle("测试Service功能");
        System.out.println(service.save(bean));
    }

    @Test
    public void test2() {
        System.out.println(service.delete(3));
    }

    @Test
    public void test3() {
        JunitJDBCBean bean = new JunitJDBCBean();
        bean.setId(4);
        bean.setTitle("测试Service功能, 我被修改过");
        System.out.println(service.modfiy(bean));
    }

    @Test
    public void test4() {
        System.out.println(service.info());
    }

}