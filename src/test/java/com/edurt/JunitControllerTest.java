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

import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * JunitControllerTest <br/>
 * 描述 : JunitControllerTest <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-10 下午11:22 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitControllerTest {

    private MockMvc mockMvc; //通过MockMvcBuilders.webAppContextSetup(this.context).build();初始化一个mock测试器

    @Autowired
    private WebApplicationContext context; // 容器上下文

    @Before
    public void step() {
        // 初始化mock测试器
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testSave() throws Exception {
        // 创建传递的参数数据
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        map.put("title", "我是RestAPI的测试数据");

        // 接收发送请求后的返回结果
        MvcResult result = mockMvc.perform(
                // 设置post请求
                MockMvcRequestBuilders.post("/junit/save")
                        // 设置消息数据类型
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        // 设置发送的数据
                        .content(JSONObject.toJSONString(map))
        )
                // 开始模拟发送post请求
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 设置返回类型为json
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                // 抽取返回结果
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testDelete() throws Exception {
        // 构建了一个delete的请求方式
        RequestBuilder request = MockMvcRequestBuilders.delete("/junit/delete?id=4");
        MvcResult result = mockMvc.perform(request)
                // 打印执行过程
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("1")))
                .andReturn();
    }

    @Test
    public void testModfiy() throws Exception {
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        map.put("id", "5");
        map.put("title", "我是RestAPI的测试数据,我被修改了");
        // 构建一个put请求
        RequestBuilder request = MockMvcRequestBuilders.put("/junit/modfiy")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSONObject.toJSONString(map))
                // 另一种数据传递方式
//                .param("id", "5")
//                .param("title", "我是RestAPI的测试数据,我被修改了")
                ;
        MvcResult result = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testInfo() throws Exception {
        // 构建一个get请求
        RequestBuilder request = MockMvcRequestBuilders.get("/junit/info");
        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}