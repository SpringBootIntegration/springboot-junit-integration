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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * JunitRestTemplateTest <br/>
 * 描述 : JunitRestTemplateTest <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-11 下午11:29 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@RunWith(SpringRunner.class)
// 参数一: 传递的是已经运行服务的入口类
// 参数二: 传递运行服务的基本环境
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JunitRestTemplateTest {

    @LocalServerPort
    private int port; // 本地服务的端口

    /**
     * 构建一个TestResttemplate测试服务
     */
    TestRestTemplate template = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void test() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = template.exchange(
                // 远程访问的地址
                createURLWithPort("/junit/info"),
                // 请求方式
                HttpMethod.GET,
                // 传递的实体对象
                entity,
                // 返回结果体类型
                String.class
        );
        System.out.println(response.getBody());
    }

    private String createURLWithPort(String uri) {
        System.out.println("port = " + port);
        return "http://localhost:" + port + uri;
    }

}