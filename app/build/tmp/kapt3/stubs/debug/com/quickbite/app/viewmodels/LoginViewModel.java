package com.quickbite.app.viewmodels;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0006\u0010\u001e\u001a\u00020\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/quickbite/app/viewmodels/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "disposables", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "_loginState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/quickbite/app/data/wrapper/Resource;", "Lcom/quickbite/app/data/models/User;", "loginState", "Landroidx/lifecycle/LiveData;", "getLoginState", "()Landroidx/lifecycle/LiveData;", "_emailError", "", "emailError", "getEmailError", "_passwordError", "passwordError", "getPasswordError", "login", "", "email", "password", "mockAuthentication", "Lio/reactivex/rxjava3/core/Single;", "isValidEmail", "", "isValidPassword", "clearErrors", "onCleared", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.rxjava3.disposables.CompositeDisposable disposables = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.quickbite.app.data.wrapper.Resource<com.quickbite.app.data.models.User>> _loginState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<com.quickbite.app.data.models.User>> loginState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _emailError = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> emailError = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _passwordError = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> passwordError = null;
    
    @javax.inject.Inject()
    public LoginViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<com.quickbite.app.data.models.User>> getLoginState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getEmailError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getPasswordError() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final io.reactivex.rxjava3.core.Single<com.quickbite.app.data.models.User> mockAuthentication(java.lang.String email, java.lang.String password) {
        return null;
    }
    
    private final boolean isValidEmail(java.lang.String email) {
        return false;
    }
    
    private final boolean isValidPassword(java.lang.String password) {
        return false;
    }
    
    public final void clearErrors() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}