package domain.useCases.SmsOTP;

import domain.model.Result.Result;
import domain.ports.ScaPort;
import domain.ports.UserPort;
import domain.useCases.UseCase;

public class SendSmsOTP implements UseCase {

    private final UserPort userPort;
    private final ScaPort scaPort;
    private final String id;

    public SendSmsOTP(UserPort userPort, ScaPort scaPort, String Id) {
        this.userPort = userPort;
        this.scaPort = scaPort;
        this.id = Id;
    }

    @Override
    public Result Execute() {
        var user = userPort.GetUser(id);
        return scaPort.SmsOTP(user);
    }
}
