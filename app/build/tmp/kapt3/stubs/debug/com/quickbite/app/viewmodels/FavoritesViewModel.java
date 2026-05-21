package com.quickbite.app.viewmodels;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/quickbite/app/viewmodels/FavoritesViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/quickbite/app/data/repository/MealRepository;", "<init>", "(Lcom/quickbite/app/data/repository/MealRepository;)V", "_favoritesState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/quickbite/app/data/wrapper/Resource;", "", "Lcom/quickbite/app/data/models/Meal;", "favoritesState", "Landroidx/lifecycle/LiveData;", "getFavoritesState", "()Landroidx/lifecycle/LiveData;", "loadFavorites", "", "removeFavorite", "mealId", "", "app_debug"})
public final class FavoritesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.data.repository.MealRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> _favoritesState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> favoritesState = null;
    
    @javax.inject.Inject()
    public FavoritesViewModel(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.repository.MealRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> getFavoritesState() {
        return null;
    }
    
    public final void loadFavorites() {
    }
    
    public final void removeFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String mealId) {
    }
}