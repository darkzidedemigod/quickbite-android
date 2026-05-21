package com.quickbite.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\rJ \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u000bJ\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000e0\r2\u0006\u0010\u0015\u001a\u00020\u000bJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u000bJ\u0016\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/quickbite/app/data/repository/MealRepository;", "", "apiService", "Lcom/quickbite/app/data/remote/ApiService;", "prefs", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/quickbite/app/data/remote/ApiService;Landroid/content/SharedPreferences;)V", "gson", "Lcom/google/gson/Gson;", "favoritesKey", "", "fetchCategories", "Lio/reactivex/rxjava3/core/Single;", "Lcom/quickbite/app/data/wrapper/Resource;", "", "Lcom/quickbite/app/data/models/Category;", "searchMeals", "Lcom/quickbite/app/data/models/Meal;", "query", "getMealById", "id", "getFavorites", "isFavorite", "", "mealId", "toggleFavorite", "meal", "removeFavorite", "", "saveFavorites", "favorites", "app_debug"})
public final class MealRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.data.remote.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String favoritesKey = "favorites";
    
    @javax.inject.Inject()
    public MealRepository(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.rxjava3.core.Single<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Category>>> fetchCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.rxjava3.core.Single<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> searchMeals(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.rxjava3.core.Single<com.quickbite.app.data.wrapper.Resource<com.quickbite.app.data.models.Meal>> getMealById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.data.models.Meal> getFavorites() {
        return null;
    }
    
    public final boolean isFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String mealId) {
        return false;
    }
    
    public final boolean toggleFavorite(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.models.Meal meal) {
        return false;
    }
    
    public final void removeFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String mealId) {
    }
    
    private final void saveFavorites(java.util.List<com.quickbite.app.data.models.Meal> favorites) {
    }
}