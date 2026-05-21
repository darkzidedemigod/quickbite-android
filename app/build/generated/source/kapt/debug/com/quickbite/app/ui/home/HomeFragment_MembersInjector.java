package com.quickbite.app.ui.home;

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
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private HomeFragment_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  @Override
  public void injectMembers(HomeFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static MembersInjector<HomeFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new HomeFragment_MembersInjector(viewModelFactoryProvider);
  }

  @InjectedFieldSignature("com.quickbite.app.ui.home.HomeFragment.viewModelFactory")
  public static void injectViewModelFactory(HomeFragment instance,
      ViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
