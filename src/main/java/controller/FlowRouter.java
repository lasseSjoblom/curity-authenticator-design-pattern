package controller;

import domain.model.Result.RequiredOperation;
import se.curity.identityserver.sdk.web.Response;

import java.util.Map;

import static se.curity.identityserver.sdk.web.ResponseModel.templateResponseModel;

import static se.curity.identityserver.sdk.web.Response.ResponseModelScope.ANY;
public class FlowRouter {

    public static void RenderView(RequiredOperation requiredOperation, Response response) {
        switch (requiredOperation) {
            case RequiredOperation.VALIDATE_SMS_OTP -> forwardToSmsOtp(response, null);
            case null, default -> throw new UnsupportedOperationException();
        };
    }
    private static void forwardToSmsOtp(Response response, Map<String, Object> model) {
        response.setResponseModel(templateResponseModel(model, "SMS_OTP"), ANY);
    }
}