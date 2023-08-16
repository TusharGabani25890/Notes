package com.example.notes.di;

import com.example.notes.api.UserAPI;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NetworkModule_ProvidesUserAPIFactory implements Factory<UserAPI> {
  private final NetworkModule module;

  private final Provider<Retrofit.Builder> retrofitBuilderProvider;

  public NetworkModule_ProvidesUserAPIFactory(NetworkModule module,
      Provider<Retrofit.Builder> retrofitBuilderProvider) {
    this.module = module;
    this.retrofitBuilderProvider = retrofitBuilderProvider;
  }

  @Override
  public UserAPI get() {
    return providesUserAPI(module, retrofitBuilderProvider.get());
  }

  public static NetworkModule_ProvidesUserAPIFactory create(NetworkModule module,
      Provider<Retrofit.Builder> retrofitBuilderProvider) {
    return new NetworkModule_ProvidesUserAPIFactory(module, retrofitBuilderProvider);
  }

  public static UserAPI providesUserAPI(NetworkModule instance, Retrofit.Builder retrofitBuilder) {
    return Preconditions.checkNotNullFromProvides(instance.providesUserAPI(retrofitBuilder));
  }
}
