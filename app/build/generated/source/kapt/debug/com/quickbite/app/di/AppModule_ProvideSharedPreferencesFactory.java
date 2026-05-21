package com.quickbite.app.di;

import android.content.Context;
import android.content.SharedPreferences;
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
public final class AppModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  private AppModule_ProvideSharedPreferencesFactory(AppModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreferences(module, contextProvider.get());
  }

  public static AppModule_ProvideSharedPreferencesFactory create(AppModule module,
      Provider<Context> contextProvider) {
    return new AppModule_ProvideSharedPreferencesFactory(module, contextProvider);
  }

  public static SharedPreferences provideSharedPreferences(AppModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideSharedPreferences(context));
  }
}
