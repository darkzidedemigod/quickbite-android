package com.quickbite.app.data.remote;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\t\u00c0\u0006\u0003"}, d2 = {"Lcom/quickbite/app/data/remote/ApiService;", "", "getCategories", "Lio/reactivex/rxjava3/core/Single;", "Lcom/quickbite/app/data/models/CategoryResponse;", "searchMeals", "Lcom/quickbite/app/data/models/MealResponse;", "query", "", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "categories.php")
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.rxjava3.core.Single<com.quickbite.app.data.models.CategoryResponse> getCategories();
    
    @retrofit2.http.GET(value = "search.php")
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.rxjava3.core.Single<com.quickbite.app.data.models.MealResponse> searchMeals(@retrofit2.http.Query(value = "s")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query);
}