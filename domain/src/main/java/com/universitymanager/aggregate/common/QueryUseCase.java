package com.universitymanager.aggregate.common;

public interface QueryUseCase<Query,SUCCESS_RESULT> {
    public abstract Result<SUCCESS_RESULT> execute(Query query);
}
