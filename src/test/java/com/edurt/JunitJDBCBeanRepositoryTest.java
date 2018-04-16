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
import com.edurt.repository.JunitJDBCBeanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * JunitJDBCBeanRepositoryTest <br/>
 * 描述 : JunitJDBCBeanRepositoryTest <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-04 上午12:01 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitJDBCBeanRepositoryTest {

    @Autowired
    private JunitJDBCBeanRepository junitJDBCBeanRepository;

    @Test
    public void test1() {
        JunitJDBCBean bean = new JunitJDBCBean();
        bean.setTitle("我是用于测试JDBC的数据");
        System.out.println(junitJDBCBeanRepository.save(bean));
    }

    @Test
    public void test2() {
        junitJDBCBeanRepository.delete(2);
        System.out.println("删除成功");
    }

    @Test
    public void test3() {
        JunitJDBCBean bean = new JunitJDBCBean();
        bean.setId(3);
        bean.setTitle("我是用于测试JDBC的数据");
        System.out.println("更新成功");
    }

    @Test
    public void test4() {
        System.out.println(junitJDBCBeanRepository.info());
    }

}