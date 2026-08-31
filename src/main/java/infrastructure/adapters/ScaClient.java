package infrastructure.adapters;

import domain.model.Result.RequiredOperation;
import domain.model.User;
import domain.ports.ScaPort;
import domain.model.Result.Result;

public class ScaClient implements ScaPort {

    public Result AuthRequest(User user) {
        return new Result(RequiredOperation.INPUT_EMAIL_OTP);
    }

    @Override
    public Result SmsOTP(User user) {
        return new Result(RequiredOperation.INPUT_SMS_OTP);
    }

    @Override
    public Result ValidateOTP(String value) {
        return new Result(null);
    }
}
