package com.jevons.service;

import com.jevons.pojo.DevUser;
import org.springframework.stereotype.Service;


public interface DevUserService {

    DevUser login(DevUser devUser);
}
