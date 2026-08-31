package controller;

import domain.ports.ScaPort;
import domain.ports.UserPort;
import domain.useCases.SmsOTP.SendSmsOTP;
import infrastructure.adapters.ScaClient;
import infrastructure.adapters.UserRepository;

import java.util.Optional;

public class IndexHandler {

    private final ScaPort scaClient = new ScaClient();
    private final UserPort userRepository = new UserRepository();

    public IndexHandler() {

    }
    public Optional<String> Index(String ClientId, String action, String userId) {
        switch (action) {
            case "STEP_UP" -> {
                var result = switch (ClientId) {
                    case "DE-CC" -> new SendSmsOTP(userRepository, scaClient, userId).Execute();
                    case "UK-CC" -> new SendSmsOTP(userRepository, scaClient, userId).Execute();
                    case "SE-CC" -> new SendSmsOTP(userRepository, scaClient, userId).Execute();
                    case null, default -> throw new UnsupportedOperationException();
                };
               FlowRouter.RenderView(result.reqOp);
               return Optional.empty();
            }
            case null, default -> throw new UnsupportedOperationException();
        }
    }

}
