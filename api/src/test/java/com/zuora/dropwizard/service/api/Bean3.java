package com.zuora.dropwizard.service.api;

import com.google.auto.value.AutoValue;

import java.util.Optional;

@AutoValue
public abstract class Bean3 implements Bean
{
    Bean3()
    {}

    @Override
    public abstract String getUserName();

    protected abstract Optional<String> getInternalDisplayName();

    @Override
    public String getDisplayName()
    {
        return getInternalDisplayName().get();
    }

    @Override
    public abstract Builder toBuilder();

    public static Builder builder()
    {
        return new AutoValue_Bean3.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder implements Bean.Builder<Bean3>
    {
        @Override
        public abstract Builder userName(String userName);

        protected abstract Builder internalDisplayName(Optional<String> displayName);

        @Override
        public Builder displayName(String displayName)
        {
            return internalDisplayName(Optional.of(displayName));
        }

        protected abstract String getUserName();

        protected abstract Optional<String> getInternalDisplayName();

        abstract Bean3 autoBuild();

        @Override
        public Bean3 build()
        {
            if (!getInternalDisplayName().isPresent()) {
                displayName(getUserName());
            }

            return autoBuild();
        }
    }
}
