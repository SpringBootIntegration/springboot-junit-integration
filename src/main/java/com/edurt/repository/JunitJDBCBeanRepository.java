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
package com.edurt.repository;

import com.edurt.bean.JunitJDBCBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JunitJDBCBeanRepository <br/>
 * 描述 : JunitJDBCBeanRepository <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-04-03 下午11:54 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@Component
public class JunitJDBCBeanRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(JunitJDBCBean bean) {
        return jdbcTemplate.update("insert into junit_jdbc(title) values(?)", bean.getTitle());
    }

    public int delete(Integer id) {
        return jdbcTemplate.update("delete from junit_jdbc where id = ?", id);
    }

    public int modfiy(JunitJDBCBean bean) {
        return jdbcTemplate.update("update junit_jdbc set title = ? where id = ?", bean.getTitle(), bean.getId());
    }

    public JunitJDBCBean info() {
        return jdbcTemplate.queryForObject("select id, title from junit_jdbc", new RowMapper<JunitJDBCBean>() {
            @Override
            public JunitJDBCBean mapRow(ResultSet resultSet, int i) throws SQLException {
                JunitJDBCBean jdbcBean = new JunitJDBCBean();
                jdbcBean.setId(resultSet.getInt("id"));
                jdbcBean.setTitle(resultSet.getString("title"));
                return jdbcBean;
            }
        });
    }

}