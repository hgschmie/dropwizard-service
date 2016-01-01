package com.zuora.service.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * Represents an user in the system.
 */
@AutoValue
@JsonSerialize(as=User.class)
public abstract class User
{
    User() {}

    @JsonProperty
    public abstract UUID getId();

    @JsonProperty
    public abstract String getUserName();

    @Nullable
    @JsonProperty
    public abstract String getDisplayName();

    @JsonProperty
    public abstract String getEmail();

    @Nullable
    protected abstract String getNullableOrganization();

    @JsonProperty
    public Optional<String> getOrganization() {
        return Optional.ofNullable(getNullableOrganization());
    }

    @JsonProperty
    public abstract boolean isActivated();

    @JsonProperty
    public abstract boolean isEnabled();

    @Nullable
    @JsonProperty
    public abstract ZonedDateTime getCreated();

    @Nullable
    @JsonProperty
    public abstract ZonedDateTime getModified();

    public abstract Builder toBuilder();

    public static Builder builder()
    {
        return new AutoValue_User.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder
    {
        @JsonCreator
        public static Builder builder()
        {
            return User.builder();
        }

        public abstract Builder id(UUID id);

        @JsonProperty("userName")
        public abstract Builder userName(String userName);

        @JsonProperty("displayName")
        protected abstract Builder displayName(String displayName);

        @JsonProperty("email")
        public abstract Builder email(String email);

        @JsonProperty("organization")
        public abstract Builder nullableOrganization(String organization);

        public abstract Builder activated(boolean activated);

        @JsonProperty("enabled")
        public abstract Builder enabled(boolean enabled);

        public abstract Builder created(ZonedDateTime created);

        public abstract Builder modified(ZonedDateTime created);

        protected abstract String getUserName();

        protected abstract String getDisplayName();

        abstract User autoBuild();

        public User build() {
            if (getDisplayName() == null) {
                displayName(getUserName());
            }

            return autoBuild();
        }
    }
}
