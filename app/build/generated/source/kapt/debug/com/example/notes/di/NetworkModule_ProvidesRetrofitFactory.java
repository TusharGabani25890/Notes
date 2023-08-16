package com.example.notes.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
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
public final class NetworkModule_ProvidesRetrofitFactory implements Factory<Retrofit.Builder> {
  private final NetworkModule module;

  public NetworkModule_ProvidesRetrofitFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public Retrofit.Builder get() {
    return providesRetrofit(module);
  }

  public static NetworkModule_ProvidesRetrofitFactory create(NetworkModule module) {
    return new NetworkModule_ProvidesRetrofitFactory(module);
  }

  public static Retrofit.Builder providesRetrofit(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesRetrofit());
  }
}
