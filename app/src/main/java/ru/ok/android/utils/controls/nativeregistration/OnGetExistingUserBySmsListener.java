package ru.ok.android.utils.controls.nativeregistration;

import android.support.annotation.NonNull;
import ru.ok.android.model.UserWithLogin;
import ru.ok.android.services.processors.base.CommandProcessor.ErrorType;

public interface OnGetExistingUserBySmsListener {
    void onGetExistingUserError(String str, @NonNull ErrorType errorType);

    void onGetExistingUserSuccessful(UserWithLogin userWithLogin);
}
