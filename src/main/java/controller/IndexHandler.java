package controller;

import controller.Model.IndexHandlerRequest;
import domain.Journeys.UkJourney;
import domain.model.Result.Result;
import domain.ports.ScaPort;
import domain.ports.UserPort;
import infrastructure.adapters.ScaClient;
import infrastructure.adapters.UserRepository;
import se.curity.identityserver.sdk.authentication.AuthenticationResult;
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler;
import se.curity.identityserver.sdk.web.Request;
import se.curity.identityserver.sdk.web.Response;

import java.util.Optional;

public class IndexHandler implements AuthenticatorRequestHandler<IndexHandlerRequest> {

    private final ScaPort scaClient = new ScaClient();
    private final UserPort userRepository = new UserRepository();

    public IndexHandler() {

    }

    @Override
    public Optional<AuthenticationResult> get(IndexHandlerRequest request, Response response) {
        return Optional.empty();
    }

    @Override
    public Optional<AuthenticationResult> post(IndexHandlerRequest request, Response response) {
        var userJourney = switch (request.ClientId) {
            case "UK-CC" -> new UkJourney(scaClient, userRepository, request.UserId);
            default -> throw new IllegalStateException("Unexpected value: " + request.ClientId);
        };

        var step = userJourney.HandleAction(request.action);
        Result result = step.Execute();
        FlowRouter.RenderView(result.reqOp, response);
        return Optional.empty();
    }
    @Override
    public IndexHandlerRequest preProcess(Request request, Response response) {

        return null;
    }
}
