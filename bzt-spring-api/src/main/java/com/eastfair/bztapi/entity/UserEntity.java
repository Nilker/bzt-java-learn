package com.eastfair.bztapi.entity;

import com.eastfair.bztapi.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* Users and global privileges
* </p>
*
* @author lhl
* @since 2019-12-31
*/
@Data
    @EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="UserEntity对象", description="Users and global privileges")
public class UserEntity extends BaseEntity {

private static final long serialVersionUID = 1L;

    @TableId("Host")
    private String host;

    @TableField("User")
    private String user;

    @TableField("Select_priv")
    private String selectPriv;

    @TableField("Insert_priv")
    private String insertPriv;

    @TableField("Update_priv")
    private String updatePriv;

    @TableField("Delete_priv")
    private String deletePriv;

    @TableField("Create_priv")
    private String createPriv;

    @TableField("Drop_priv")
    private String dropPriv;

    @TableField("Reload_priv")
    private String reloadPriv;

    @TableField("Shutdown_priv")
    private String shutdownPriv;

    @TableField("Process_priv")
    private String processPriv;

    @TableField("File_priv")
    private String filePriv;

    @TableField("Grant_priv")
    private String grantPriv;

    @TableField("References_priv")
    private String referencesPriv;

    @TableField("Index_priv")
    private String indexPriv;

    @TableField("Alter_priv")
    private String alterPriv;

    @TableField("Show_db_priv")
    private String showDbPriv;

    @TableField("Super_priv")
    private String superPriv;

    @TableField("Create_tmp_table_priv")
    private String createTmpTablePriv;

    @TableField("Lock_tables_priv")
    private String lockTablesPriv;

    @TableField("Execute_priv")
    private String executePriv;

    @TableField("Repl_slave_priv")
    private String replSlavePriv;

    @TableField("Repl_client_priv")
    private String replClientPriv;

    @TableField("Create_view_priv")
    private String createViewPriv;

    @TableField("Show_view_priv")
    private String showViewPriv;

    @TableField("Create_routine_priv")
    private String createRoutinePriv;

    @TableField("Alter_routine_priv")
    private String alterRoutinePriv;

    @TableField("Create_user_priv")
    private String createUserPriv;

    @TableField("Event_priv")
    private String eventPriv;

    @TableField("Trigger_priv")
    private String triggerPriv;

    @TableField("Create_tablespace_priv")
    private String createTablespacePriv;

    private String sslType;

    private Blob sslCipher;

    private Blob x509Issuer;

    private Blob x509Subject;

    private Integer maxQuestions;

    private Integer maxUpdates;

    private Integer maxConnections;

    private Integer maxUserConnections;

    private String plugin;

    private String authenticationString;

    private String passwordExpired;

    private Date passwordLastChanged;

    private Integer passwordLifetime;

    private String accountLocked;


}
