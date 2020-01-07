package com.eastfair.bztapi.entity;

import com.eastfair.bztapi.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 消息推送
* </p>
*
* @author lhl
* @since 2019-12-31
*/
@Data
    @EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("AppPushInfo")
@ApiModel(value="AppPushInfoEntity对象", description="消息推送")
public class AppPushInfoEntity extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键Id,自增")
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "展会Id")
    @TableField("ExhId")
    private Integer exhId;

    @ApiModelProperty(value = "用户名Id")
    @TableField("StfID")
    private Integer stfID;

    @ApiModelProperty(value = "用户名称")
    @TableField("StfFullName")
    private String stfFullName;

    @ApiModelProperty(value = "设备唯一标识Id")
    @TableField("RegistrationId")
    private String registrationId;

    @ApiModelProperty(value = "需要联系展商数量")
    @TableField("NeedLinkCount")
    private Integer needLinkCount;

    @ApiModelProperty(value = "推送返回的sendno")
    private String sendno;

    @ApiModelProperty(value = "推送返回的msg_id")
    private String msgId;

    @ApiModelProperty(value = "创建时间")
    @TableField("CreatTime")
    private Date creatTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("ModifyTime")
    private Date modifyTime;

    @ApiModelProperty(value = "那一天的数据")
    @TableField("SendDay")
    private Date sendDay;

    @ApiModelProperty(value = "数据类型：1：今天待联系  2：明天待联系  3：催款")
    @TableField("DataType")
    private Integer dataType;


}
