package com.zuora.dropwizard.service.api;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Bean1 implements Bean
{
    Bean1()
    {}

    @Override
    public abstract String getUserName();

    @Override
    public abstract String getDisplayName();

    @Override
    public abstract Builder toBuilder();

    public static Builder builder()
    {
        return new AutoValue_Bean1.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder implements Bean.Builder<Bean1>
    {
        @Override
        public abstract Builder userName(String userName);

        @Override
        public abstract Builder displayName(String displayName);

        abstract String getUserName();

        abstract String getDisplayName();

        abstract Bean1 autoBuild();

        @Override
        public Bean1 build()
        {
            if (getDisplayName() == null) {
                displayName(getUserName());
            }

            return autoBuild();
        }
    }
}
