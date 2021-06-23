package com.db.table.service;

import com.db.table.domain.UserDTO;
import com.db.table.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getUserList() {
        List<UserDTO> userList = Collections.emptyList();
        userList = userMapper.selectUserList();

        return userList;
    }
}
