package domain.ports;

import domain.model.User;
import domain.model.Result.Result;

public interface ScaPort {

    public Result AuthRequest(User user);
    public Result SmsOTP(User user);

    public Result ValidateOTP(String value);
}

