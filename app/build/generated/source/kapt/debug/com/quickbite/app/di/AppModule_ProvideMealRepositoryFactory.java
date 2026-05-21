package com.quickbite.app.di;

import android.content.SharedPreferences;
import com.quickbite.app.data.remote.ApiService;
import com.quickbite.app.data.repository.MealRepository;
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
public final class AppModule_ProvideMealRepositoryFactory implements Factory<MealRepository> {
  private final AppModule module;

  private final Provider<ApiService> apiServiceProvider;

  private final Provider<SharedPreferences> prefsProvider;

  private AppModule_ProvideMealRepositoryFactory(AppModule module,
      Provider<ApiService> apiServiceProvider, Provider<SharedPreferences> prefsProvider) {
    this.module = module;
    this.apiServiceProvider = apiServiceProvider;
    this.prefsProvider = prefsProvider;
  }

  @Override
  public MealRepository get() {
    return provideMealRepository(module, apiServiceProvider.get(), prefsProvider.get());
  }

  public static AppModule_ProvideMealRepositoryFactory create(AppModule module,
      Provider<ApiService> apiServiceProvider, Provider<SharedPreferences> prefsProvider) {
    return new AppModule_ProvideMealRepositoryFactory(module, apiServiceProvider, prefsProvider);
  }

  public static MealRepository provideMealRepository(AppModule instance, ApiService apiService,
      SharedPreferences prefs) {
    return Preconditions.checkNotNullFromProvides(instance.provideMealRepository(apiService, prefs));
  }
}
