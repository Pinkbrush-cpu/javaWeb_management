package com.czy.service.power;

import com.czy.pojo.Power;

public interface PowerService {
    public Power loginVerify(int id);

    public boolean storagePowerService(Power power);
}
