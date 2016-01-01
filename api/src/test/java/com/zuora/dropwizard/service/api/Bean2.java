package com.zuora.dropwizard.service.api;

import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

@AutoValue
public abstract class Bean2 implements Bean
{
    Bean2()
    {}

    @Override
    public abstract String getUserName();

    @Nullable
    @Override
    public abstract String getDisplayName();

    @Override
    public abstract Builder toBuilder();

    public static Builder builder()
    {
        return new AutoValue_Bean2.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder implements Bean.Builder<Bean2>
    {
        @Override
        public abstract Builder userName(String userName);

        @Override
        public abstract Builder displayName(String displayName);

        protected abstract String getUserName();

        protected abstract String getDisplayName();

        abstract Bean2 autoBuild();

        @Override
        public Bean2 build()
        {
            if (getDisplayName() == null) {
                displayName(getUserName());
            }

            return autoBuild();
        }
    }
}
