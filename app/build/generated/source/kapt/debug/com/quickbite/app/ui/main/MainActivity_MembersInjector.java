package com.quickbite.app.ui.main;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private MainActivity_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static MembersInjector<MainActivity> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new MainActivity_MembersInjector(viewModelFactoryProvider);
  }

  @InjectedFieldSignature("com.quickbite.app.ui.main.MainActivity.viewModelFactory")
  public static void injectViewModelFactory(MainActivity instance,
      ViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
