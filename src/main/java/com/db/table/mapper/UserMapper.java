package com.db.table.mapper;

import com.db.table.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<UserDTO> selectUserList();
}
