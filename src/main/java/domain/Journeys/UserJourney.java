package domain.Journeys;

import domain.useCases.UseCase;

import java.util.Optional;

public interface UserJourney {
    public Optional<UseCase> HandleAction(String action);
}
