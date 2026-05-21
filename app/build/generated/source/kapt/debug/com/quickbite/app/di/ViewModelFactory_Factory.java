package com.quickbite.app.di;

import com.quickbite.app.data.repository.AuthRepository;
import com.quickbite.app.data.repository.MealRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class ViewModelFactory_Factory implements Factory<ViewModelFactory> {
  private final Provider<MealRepository> mealRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  private ViewModelFactory_Factory(Provider<MealRepository> mealRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.mealRepositoryProvider = mealRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public ViewModelFactory get() {
    return newInstance(mealRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static ViewModelFactory_Factory create(Provider<MealRepository> mealRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new ViewModelFactory_Factory(mealRepositoryProvider, authRepositoryProvider);
  }

  public static ViewModelFactory newInstance(MealRepository mealRepository,
      AuthRepository authRepository) {
    return new ViewModelFactory(mealRepository, authRepository);
  }
}
