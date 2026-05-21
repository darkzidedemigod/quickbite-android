package com.quickbite.app.di;

import android.app.Application;
import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class AppModule_ProvideApplicationContextFactory implements Factory<Context> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  private AppModule_ProvideApplicationContextFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Context get() {
    return provideApplicationContext(module, applicationProvider.get());
  }

  public static AppModule_ProvideApplicationContextFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvideApplicationContextFactory(module, applicationProvider);
  }

  public static Context provideApplicationContext(AppModule instance, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideApplicationContext(application));
  }
}
