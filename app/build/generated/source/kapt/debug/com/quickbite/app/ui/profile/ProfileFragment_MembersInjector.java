package com.quickbite.app.ui.profile;

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
public final class ProfileFragment_MembersInjector implements MembersInjector<ProfileFragment> {
  private final Provider<ViewModelFactory> viewModelFactoryProvider;

  private ProfileFragment_MembersInjector(Provider<ViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  @Override
  public void injectMembers(ProfileFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  public static MembersInjector<ProfileFragment> create(
      Provider<ViewModelFactory> viewModelFactoryProvider) {
    return new ProfileFragment_MembersInjector(viewModelFactoryProvider);
  }

  @InjectedFieldSignature("com.quickbite.app.ui.profile.ProfileFragment.viewModelFactory")
  public static void injectViewModelFactory(ProfileFragment instance,
      ViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
