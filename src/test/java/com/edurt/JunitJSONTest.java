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
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * JunitJSONTest <br/>
 * 描述 : JunitJSONTest <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-11 下午11:43 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@RunWith(SpringRunner.class)
@JsonTest
public class JunitJSONTest {

    @Autowired
//    GsonTester
    private JacksonTester<JunitJDBCBean> json;

    @Test
    public void testSerialize() throws Exception {
        JunitJDBCBean bean = new JunitJDBCBean();
        bean.setId(1);
        bean.setTitle("我是测试JSON的数据");
        // 抽取json数据的属性
        System.out.println(this.json.write(bean).getJson());
//        Assertions.assertThat(this.json.write(bean)).hasJsonPathStringValue("@.id");
        Assertions.assertThat(this.json.write(bean)).extractingJsonPathStringValue("@.title")
                .isEqualTo("我是测试JSON的数据");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"id\" : \"2\", \"title\": \"我是测试反序列化的JSON数据\"}";

        JunitJDBCBean bean = new JunitJDBCBean();
        bean.setId(2);
        bean.setTitle("我是测试反序列化的JSON数据");

        Assertions.assertThat(this.json.parse(content)).isEqualTo(bean);
        Assertions.assertThat(this.json.parseObject(content).getId()).isEqualTo("2");
    }

}