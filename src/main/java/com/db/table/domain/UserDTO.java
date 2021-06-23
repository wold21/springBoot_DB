package com.db.table.domain;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
@Mapper
public class UserDTO {
    private String id;
    private String nick;
    private String name;
}
