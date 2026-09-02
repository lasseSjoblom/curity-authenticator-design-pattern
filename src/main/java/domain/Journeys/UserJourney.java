package domain.Journeys;

import domain.useCases.UseCase;

public interface UserJourney {
    public UseCase HandleAction(String action);
}
