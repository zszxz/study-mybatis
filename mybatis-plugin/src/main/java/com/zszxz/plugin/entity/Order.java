package com.zszxz.plugin.entity;

import java.time.LocalDateTime;

/**
 * @Author lsc
 * <p> </p>
 */
public class Order {

    // 主键
    private Long id;
    // 订单名称
    private String order_name;
    // 创建时间
    private LocalDateTime create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }
}
