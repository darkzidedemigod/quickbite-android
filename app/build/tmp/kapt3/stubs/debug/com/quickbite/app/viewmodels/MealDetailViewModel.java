package com.quickbite.app.viewmodels;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/quickbite/app/viewmodels/MealDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/quickbite/app/data/repository/MealRepository;", "<init>", "(Lcom/quickbite/app/data/repository/MealRepository;)V", "disposables", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "_mealState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/quickbite/app/data/wrapper/Resource;", "Lcom/quickbite/app/data/models/Meal;", "mealState", "Landroidx/lifecycle/LiveData;", "getMealState", "()Landroidx/lifecycle/LiveData;", "_isFavorite", "", "isFavorite", "loadMeal", "", "mealId", "", "toggleFavorite", "meal", "loadFavoriteStatus", "onCleared", "app_debug"})
public final class MealDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.data.repository.MealRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.rxjava3.disposables.CompositeDisposable disposables = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.quickbite.app.data.wrapper.Resource<com.quickbite.app.data.models.Meal>> _mealState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<com.quickbite.app.data.models.Meal>> mealState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isFavorite = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isFavorite = null;
    
    @javax.inject.Inject()
    public MealDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.repository.MealRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<com.quickbite.app.data.models.Meal>> getMealState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isFavorite() {
        return null;
    }
    
    public final void loadMeal(@org.jetbrains.annotations.NotNull()
    java.lang.String mealId) {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.models.Meal meal) {
    }
    
    public final void loadFavoriteStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String mealId) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}