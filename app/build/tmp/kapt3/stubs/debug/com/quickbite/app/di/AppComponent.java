package com.quickbite.app.di;

@javax.inject.Singleton()
@dagger.Component(modules = {com.quickbite.app.di.NetworkModule.class, com.quickbite.app.di.AppModule.class, com.quickbite.app.di.FirebaseModule.class})
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001!J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001cH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001dH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001eH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020 H&\u00a8\u0006\"\u00c0\u0006\u0003"}, d2 = {"Lcom/quickbite/app/di/AppComponent;", "", "inject", "", "loginActivity", "Lcom/quickbite/app/ui/login/LoginActivity;", "registerActivity", "Lcom/quickbite/app/ui/register/RegisterActivity;", "mainActivity", "Lcom/quickbite/app/ui/main/MainActivity;", "homeFragment", "Lcom/quickbite/app/ui/home/HomeFragment;", "mealDetailFragment", "Lcom/quickbite/app/ui/detail/MealDetailFragment;", "favoritesFragment", "Lcom/quickbite/app/ui/favorites/FavoritesFragment;", "profileFragment", "Lcom/quickbite/app/ui/profile/ProfileFragment;", "getApiService", "Lcom/quickbite/app/data/remote/ApiService;", "getMealRepository", "Lcom/quickbite/app/data/repository/MealRepository;", "getAuthRepository", "Lcom/quickbite/app/data/repository/AuthRepository;", "getApplication", "Landroid/app/Application;", "viewModel", "Lcom/quickbite/app/viewmodels/LoginViewModel;", "Lcom/quickbite/app/viewmodels/RegisterViewModel;", "Lcom/quickbite/app/viewmodels/HomeViewModel;", "Lcom/quickbite/app/viewmodels/MealDetailViewModel;", "Lcom/quickbite/app/viewmodels/FavoritesViewModel;", "Lcom/quickbite/app/viewmodels/ProfileViewModel;", "Builder", "app_debug"})
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.ui.login.LoginActivity loginActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.ui.register.RegisterActivity registerActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.ui.main.MainActivity mainActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.ui.home.HomeFragment homeFragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.ui.detail.MealDetailFragment mealDetailFragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.ui.favorites.FavoritesFragment favoritesFragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.ui.profile.ProfileFragment profileFragment);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quickbite.app.data.remote.ApiService getApiService();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quickbite.app.data.repository.MealRepository getMealRepository();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quickbite.app.data.repository.AuthRepository getAuthRepository();
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.app.Application getApplication();
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.viewmodels.LoginViewModel viewModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.viewmodels.RegisterViewModel viewModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.viewmodels.HomeViewModel viewModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.viewmodels.MealDetailViewModel viewModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.viewmodels.FavoritesViewModel viewModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.viewmodels.ProfileViewModel viewModel);
    
    @dagger.Component.Builder()
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006\u00c0\u0006\u0003"}, d2 = {"Lcom/quickbite/app/di/AppComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lcom/quickbite/app/di/AppComponent;", "app_debug"})
    public static abstract interface Builder {
        
        @dagger.BindsInstance()
        @org.jetbrains.annotations.NotNull()
        public abstract com.quickbite.app.di.AppComponent.Builder application(@org.jetbrains.annotations.NotNull()
        android.app.Application application);
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.quickbite.app.di.AppComponent build();
    }
}