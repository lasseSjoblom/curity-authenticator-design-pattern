package domain.useCases.SmsOTP;

import domain.model.Result.Result;
import domain.ports.ScaPort;
import domain.useCases.UseCase;

public class ValidateSmSOTP implements UseCase {
    private final ScaPort scaPort;
    private final String otpInput;

    public ValidateSmSOTP(ScaPort scaPort, String otpInput) {
       this.scaPort = scaPort;
    }

    @Override
    public Result Execute() {
        scaPort.
        return null;
    }
}
