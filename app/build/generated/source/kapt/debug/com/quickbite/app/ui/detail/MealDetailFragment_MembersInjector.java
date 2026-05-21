package com.quickbite.app.ui.detail;

import com.quickbite.app.di.ViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;

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
public final class MealDetailFragment_MembersInjector implements MembersInjector<MealDetailFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private MealDetailFragment_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  @Override
  public void injectMembers(MealDetailFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static MembersInjector<MealDetailFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new MealDetailFragment_MembersInjector(viewModelFactoryProvider);
  }

  @InjectedFieldSignature("com.quickbite.app.ui.detail.MealDetailFragment.viewModelFactory")
  public static void injectViewModelFactory(MealDetailFragment instance,
      ViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
