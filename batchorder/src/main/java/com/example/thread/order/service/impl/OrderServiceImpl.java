package com.example.thread.order.service.impl;

import com.example.thread.order.service.OrderService;
import com.example.thread.util.TheadPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insert() {
        TheadPoolUtil.poolSubmit().submit(()->{
            String sql ="";
            int[] ints = jdbcTemplate.batchUpdate(sql);
        });
    }


}
