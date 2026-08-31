package controller;

import domain.model.Result.RequiredOperation;

public class FlowRouter {

    public static String RenderView(RequiredOperation requiredOperation) {
        return switch (requiredOperation) {
            case RequiredOperation.INPUT_EMAIL_OTP -> SmsOTP();
            case null, default -> throw new UnsupportedOperationException();
        };
    }

    public static String SmsOTP() {
        return "{render balblablabla}";
    }
}
