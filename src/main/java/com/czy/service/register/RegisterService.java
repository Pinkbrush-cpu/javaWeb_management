package com.czy.service.register;

import com.czy.pojo.User;

import java.sql.Connection;

public interface RegisterService {
    public boolean findByUsername(String username);

    public boolean storageService(User user);

    public int getUseridService(String username);
}
