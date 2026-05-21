package com.quickbite.app.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.quickbite.app.data.remote.ApiService;
import com.quickbite.app.data.repository.AuthRepository;
import com.quickbite.app.data.repository.MealRepository;
import com.quickbite.app.ui.detail.MealDetailFragment;
import com.quickbite.app.ui.detail.MealDetailFragment_MembersInjector;
import com.quickbite.app.ui.favorites.FavoritesFragment;
import com.quickbite.app.ui.favorites.FavoritesFragment_MembersInjector;
import com.quickbite.app.ui.home.HomeFragment;
import com.quickbite.app.ui.home.HomeFragment_MembersInjector;
import com.quickbite.app.ui.login.LoginActivity;
import com.quickbite.app.ui.login.LoginActivity_MembersInjector;
import com.quickbite.app.ui.main.MainActivity;
import com.quickbite.app.ui.main.MainActivity_MembersInjector;
import com.quickbite.app.ui.profile.ProfileFragment;
import com.quickbite.app.ui.profile.ProfileFragment_MembersInjector;
import com.quickbite.app.ui.register.RegisterActivity;
import com.quickbite.app.ui.register.RegisterActivity_MembersInjector;
import com.quickbite.app.viewmodels.FavoritesViewModel;
import com.quickbite.app.viewmodels.HomeViewModel;
import com.quickbite.app.viewmodels.LoginViewModel;
import com.quickbite.app.viewmodels.MealDetailViewModel;
import com.quickbite.app.viewmodels.ProfileViewModel;
import com.quickbite.app.viewmodels.RegisterViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class DaggerAppComponent {
  private DaggerAppComponent() {
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public AppComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new AppComponentImpl(new NetworkModule(), new AppModule(), new FirebaseModule(), application);
    }
  }

  private static final class AppComponentImpl implements AppComponent {
    private final Application application;

    private final AppComponentImpl appComponentImpl = this;

    Provider<FirebaseAuth> provideFirebaseAuthProvider;

    Provider<FirebaseFirestore> provideFirebaseFirestoreProvider;

    Provider<AuthRepository> provideAuthRepositoryProvider;

    Provider<OkHttpClient> provideOkHttpClientProvider;

    Provider<Retrofit> provideRetrofitProvider;

    Provider<ApiService> provideApiServiceProvider;

    Provider<Application> applicationProvider;

    Provider<Context> provideApplicationContextProvider;

    Provider<SharedPreferences> provideSharedPreferencesProvider;

    Provider<MealRepository> provideMealRepositoryProvider;

    AppComponentImpl(NetworkModule networkModuleParam, AppModule appModuleParam,
        FirebaseModule firebaseModuleParam, Application applicationParam) {
      this.application = applicationParam;
      initialize(networkModuleParam, appModuleParam, firebaseModuleParam, applicationParam);

    }

    LoginViewModel loginViewModel() {
      return new LoginViewModel(provideAuthRepositoryProvider.get());
    }

    ViewModelFactory viewModelFactory() {
      return new ViewModelFactory(provideMealRepositoryProvider.get(), provideAuthRepositoryProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final NetworkModule networkModuleParam, final AppModule appModuleParam,
        final FirebaseModule firebaseModuleParam, final Application applicationParam) {
      this.provideFirebaseAuthProvider = DoubleCheck.provider(FirebaseModule_ProvideFirebaseAuthFactory.create(firebaseModuleParam));
      this.provideFirebaseFirestoreProvider = DoubleCheck.provider(FirebaseModule_ProvideFirebaseFirestoreFactory.create(firebaseModuleParam));
      this.provideAuthRepositoryProvider = DoubleCheck.provider(AppModule_ProvideAuthRepositoryFactory.create(appModuleParam, provideFirebaseAuthProvider, provideFirebaseFirestoreProvider));
      this.provideOkHttpClientProvider = DoubleCheck.provider(NetworkModule_ProvideOkHttpClientFactory.create(networkModuleParam));
      this.provideRetrofitProvider = DoubleCheck.provider(NetworkModule_ProvideRetrofitFactory.create(networkModuleParam, provideOkHttpClientProvider));
      this.provideApiServiceProvider = DoubleCheck.provider(NetworkModule_ProvideApiServiceFactory.create(networkModuleParam, provideRetrofitProvider));
      this.applicationProvider = InstanceFactory.create(applicationParam);
      this.provideApplicationContextProvider = DoubleCheck.provider(AppModule_ProvideApplicationContextFactory.create(appModuleParam, applicationProvider));
      this.provideSharedPreferencesProvider = DoubleCheck.provider(AppModule_ProvideSharedPreferencesFactory.create(appModuleParam, provideApplicationContextProvider));
      this.provideMealRepositoryProvider = DoubleCheck.provider(AppModule_ProvideMealRepositoryFactory.create(appModuleParam, provideApiServiceProvider, provideSharedPreferencesProvider));
    }

    @Override
    public void inject(LoginActivity loginActivity) {
      injectLoginActivity(loginActivity);
    }

    @Override
    public void inject(RegisterActivity registerActivity) {
      injectRegisterActivity(registerActivity);
    }

    @Override
    public void inject(MainActivity mainActivity) {
      injectMainActivity(mainActivity);
    }

    @Override
    public void inject(HomeFragment homeFragment) {
      injectHomeFragment(homeFragment);
    }

    @Override
    public void inject(MealDetailFragment mealDetailFragment) {
      injectMealDetailFragment(mealDetailFragment);
    }

    @Override
    public void inject(FavoritesFragment favoritesFragment) {
      injectFavoritesFragment(favoritesFragment);
    }

    @Override
    public void inject(ProfileFragment profileFragment) {
      injectProfileFragment(profileFragment);
    }

    @Override
    public void inject(LoginViewModel viewModel) {
    }

    @Override
    public void inject(RegisterViewModel viewModel) {
    }

    @Override
    public void inject(HomeViewModel viewModel) {
    }

    @Override
    public void inject(MealDetailViewModel viewModel) {
    }

    @Override
    public void inject(FavoritesViewModel viewModel) {
    }

    @Override
    public void inject(ProfileViewModel viewModel) {
    }

    @Override
    public ApiService getApiService() {
      return provideApiServiceProvider.get();
    }

    @Override
    public MealRepository getMealRepository() {
      return provideMealRepositoryProvider.get();
    }

    @Override
    public AuthRepository getAuthRepository() {
      return provideAuthRepositoryProvider.get();
    }

    @Override
    public Application getApplication() {
      return application;
    }

    @CanIgnoreReturnValue
    private LoginActivity injectLoginActivity(LoginActivity instance) {
      LoginActivity_MembersInjector.injectLoginViewModel(instance, loginViewModel());
      return instance;
    }

    @CanIgnoreReturnValue
    private RegisterActivity injectRegisterActivity(RegisterActivity instance2) {
      RegisterActivity_MembersInjector.injectViewModelFactory(instance2, viewModelFactory());
      return instance2;
    }

    @CanIgnoreReturnValue
    private MainActivity injectMainActivity(MainActivity instance3) {
      MainActivity_MembersInjector.injectViewModelFactory(instance3, viewModelFactory());
      return instance3;
    }

    @CanIgnoreReturnValue
    private HomeFragment injectHomeFragment(HomeFragment instance4) {
      HomeFragment_MembersInjector.injectViewModelFactory(instance4, viewModelFactory());
      return instance4;
    }

    @CanIgnoreReturnValue
    private MealDetailFragment injectMealDetailFragment(MealDetailFragment instance5) {
      MealDetailFragment_MembersInjector.injectViewModelFactory(instance5, viewModelFactory());
      return instance5;
    }

    @CanIgnoreReturnValue
    private FavoritesFragment injectFavoritesFragment(FavoritesFragment instance6) {
      FavoritesFragment_MembersInjector.injectViewModelFactory(instance6, viewModelFactory());
      return instance6;
    }

    @CanIgnoreReturnValue
    private ProfileFragment injectProfileFragment(ProfileFragment instance7) {
      ProfileFragment_MembersInjector.injectViewModelFactory(instance7, viewModelFactory());
      return instance7;
    }
  }
}
