package com.universitymanager.aggregate.common;

public interface CommandUseCase<COMMAND, SUCCESS_RESULT> {
    public abstract Result<SUCCESS_RESULT> execute(COMMAND command);
}
