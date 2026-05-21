package com.quickbite.app.ui.favorites;

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
public final class FavoritesFragment_MembersInjector implements MembersInjector<FavoritesFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private FavoritesFragment_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  @Override
  public void injectMembers(FavoritesFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static MembersInjector<FavoritesFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new FavoritesFragment_MembersInjector(viewModelFactoryProvider);
  }

  @InjectedFieldSignature("com.quickbite.app.ui.favorites.FavoritesFragment.viewModelFactory")
  public static void injectViewModelFactory(FavoritesFragment instance,
      ViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
