package com.quickbite.app.viewmodels;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0019J\b\u0010 \u001a\u00020\u001bH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\n0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R \u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\n0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/quickbite/app/viewmodels/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/quickbite/app/data/repository/MealRepository;", "<init>", "(Lcom/quickbite/app/data/repository/MealRepository;)V", "disposables", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "_categoriesState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/quickbite/app/data/wrapper/Resource;", "", "Lcom/quickbite/app/data/models/Category;", "categoriesState", "Landroidx/lifecycle/LiveData;", "getCategoriesState", "()Landroidx/lifecycle/LiveData;", "_searchResults", "Lcom/quickbite/app/data/models/Meal;", "searchResults", "getSearchResults", "_featuredMeals", "featuredMeals", "getFeaturedMeals", "_searchQuery", "", "loadCategories", "", "loadFeaturedMeals", "searchMeals", "query", "onSearchQueryChanged", "onCleared", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.data.repository.MealRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.rxjava3.disposables.CompositeDisposable disposables = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Category>>> _categoriesState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Category>>> categoriesState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> _searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> _featuredMeals = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> featuredMeals = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _searchQuery = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.repository.MealRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Category>>> getCategoriesState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> getSearchResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.quickbite.app.data.wrapper.Resource<java.util.List<com.quickbite.app.data.models.Meal>>> getFeaturedMeals() {
        return null;
    }
    
    public final void loadCategories() {
    }
    
    public final void loadFeaturedMeals() {
    }
    
    public final void searchMeals(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void onSearchQueryChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}