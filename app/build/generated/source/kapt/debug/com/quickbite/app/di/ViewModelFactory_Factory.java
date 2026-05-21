package com.quickbite.app.di;

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

  private ViewModelFactory_Factory(Provider<MealRepository> mealRepositoryProvider) {
    this.mealRepositoryProvider = mealRepositoryProvider;
  }

  @Override
  public ViewModelFactory get() {
    return newInstance(mealRepositoryProvider.get());
  }

  public static ViewModelFactory_Factory create(Provider<MealRepository> mealRepositoryProvider) {
    return new ViewModelFactory_Factory(mealRepositoryProvider);
  }

  public static ViewModelFactory newInstance(MealRepository mealRepository) {
    return new ViewModelFactory(mealRepository);
  }
}
