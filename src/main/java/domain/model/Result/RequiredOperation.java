package domain.model.Result;

public enum RequiredOperation {
    NO_NEXT(""),
    SEND_SMS_OTP("sms-request"),
    INPUT_SMS_OTP("sms-input"),
    VALIDATE_SMS_OTP(""),
    SEND_EMAIL_OTP(""),
    INPUT_EMAIL_OTP(""),
    VALIDATE_EMAIL_OTP(""),
    PASSCODE(""),
    PASSCODE_REQUEST("passcode-request"),
    PASSCODE_INPUT("passcode-input"),
    PASSCODE_MIGRATION("passcode-migration");
    public final String templateId;
    RequiredOperation(String templateId) {
        this.templateId = templateId;
    }

}
