package com.quickbite.app.ui.login;

import com.quickbite.app.viewmodels.LoginViewModel;
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
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
  private final Provider<LoginViewModel> loginViewModelProvider;

  private LoginActivity_MembersInjector(Provider<LoginViewModel> loginViewModelProvider) {
    this.loginViewModelProvider = loginViewModelProvider;
  }

  @Override
  public void injectMembers(LoginActivity instance) {
    injectLoginViewModel(instance, loginViewModelProvider.get());
  }

  public static MembersInjector<LoginActivity> create(
      Provider<LoginViewModel> loginViewModelProvider) {
    return new LoginActivity_MembersInjector(loginViewModelProvider);
  }

  @InjectedFieldSignature("com.quickbite.app.ui.login.LoginActivity.loginViewModel")
  public static void injectLoginViewModel(LoginActivity instance, LoginViewModel loginViewModel) {
    instance.loginViewModel = loginViewModel;
  }
}
