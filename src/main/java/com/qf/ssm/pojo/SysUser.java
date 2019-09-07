package com.qf.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sys_user")
public class SysUser {
    @Id
    private Integer id;

    private String nickname;

    private String password;

    private String salt;

    private String role;
}
