package com.example.notes.repository;

import com.example.notes.api.UserAPI;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UserRepository_Factory implements Factory<UserRepository> {
  private final Provider<UserAPI> userAPIProvider;

  public UserRepository_Factory(Provider<UserAPI> userAPIProvider) {
    this.userAPIProvider = userAPIProvider;
  }

  @Override
  public UserRepository get() {
    return newInstance(userAPIProvider.get());
  }

  public static UserRepository_Factory create(Provider<UserAPI> userAPIProvider) {
    return new UserRepository_Factory(userAPIProvider);
  }

  public static UserRepository newInstance(UserAPI userAPI) {
    return new UserRepository(userAPI);
  }
}
