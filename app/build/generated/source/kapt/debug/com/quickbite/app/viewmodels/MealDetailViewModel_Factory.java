package com.quickbite.app.viewmodels;

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
public final class MealDetailViewModel_Factory implements Factory<MealDetailViewModel> {
  private final Provider<MealRepository> repositoryProvider;

  private MealDetailViewModel_Factory(Provider<MealRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MealDetailViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static MealDetailViewModel_Factory create(Provider<MealRepository> repositoryProvider) {
    return new MealDetailViewModel_Factory(repositoryProvider);
  }

  public static MealDetailViewModel newInstance(MealRepository repository) {
    return new MealDetailViewModel(repository);
  }
}
