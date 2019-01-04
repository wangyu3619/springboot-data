package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangyu
 * @date 2018/12/14 13:59
 */
@Data
public class BaseEntity implements Serializable {

    @TableId(value="id", type= IdType.AUTO)
    private long id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    @TableField(value = "delete_flag")
    @TableLogic
    private byte deleteFlag;
}