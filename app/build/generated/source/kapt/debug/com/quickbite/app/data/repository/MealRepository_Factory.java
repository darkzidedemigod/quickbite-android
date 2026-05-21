package com.quickbite.app.data.repository;

import android.content.SharedPreferences;
import com.quickbite.app.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class MealRepository_Factory implements Factory<MealRepository> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<SharedPreferences> prefsProvider;

  private MealRepository_Factory(Provider<ApiService> apiServiceProvider,
      Provider<SharedPreferences> prefsProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.prefsProvider = prefsProvider;
  }

  @Override
  public MealRepository get() {
    return newInstance(apiServiceProvider.get(), prefsProvider.get());
  }

  public static MealRepository_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<SharedPreferences> prefsProvider) {
    return new MealRepository_Factory(apiServiceProvider, prefsProvider);
  }

  public static MealRepository newInstance(ApiService apiService, SharedPreferences prefs) {
    return new MealRepository(apiService, prefs);
  }
}
