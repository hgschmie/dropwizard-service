package com.zuora.dropwizard.service.api;

public interface Bean
{
    String getUserName();

    String getDisplayName();

    Builder<? extends Bean> toBuilder();

    public interface Builder<T extends Bean>
    {
        Builder<T> userName(String userName);

        Builder<T> displayName(String displayName);

        Bean build();
    }
}
