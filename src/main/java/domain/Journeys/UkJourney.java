package domain.Journeys;
import domain.ports.ScaPort;
import domain.ports.UserPort;
import domain.useCases.SmsOTP.SendSmsOTP;
import domain.useCases.UseCase;

import java.util.Optional;

public class UkJourney implements UserJourney {
    private final ScaPort scaPort;
    private final UserPort userPort;
    private final String userId;

    public UkJourney(ScaPort scaPort, UserPort userPort, String userId){
        this.scaPort = scaPort;
        this.userPort = userPort;
        this.userId = userId;
    }

    public Optional<UseCase> HandleAction(String action) {
        return switch (action) {
            case "STEP_UP" ->  Optional.of(new SendSmsOTP(userPort,scaPort, userId));
            case null, default -> Optional.empty();
        };
    }
}
