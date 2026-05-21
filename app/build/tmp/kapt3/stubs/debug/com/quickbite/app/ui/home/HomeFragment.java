package com.quickbite.app.ui.home;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/quickbite/app/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/quickbite/app/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/quickbite/app/databinding/FragmentHomeBinding;", "viewModelFactory", "Lcom/quickbite/app/di/ViewModelFactory;", "getViewModelFactory", "()Lcom/quickbite/app/di/ViewModelFactory;", "setViewModelFactory", "(Lcom/quickbite/app/di/ViewModelFactory;)V", "homeViewModel", "Lcom/quickbite/app/viewmodels/HomeViewModel;", "categoryAdapter", "Lcom/quickbite/app/ui/home/CategoryAdapter;", "featuredAdapter", "Lcom/quickbite/app/ui/home/MealAdapter;", "searchResultsAdapter", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupRecyclerViews", "setupSearchBar", "setupSwipeRefresh", "setupObservers", "onDestroyView", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.quickbite.app.databinding.FragmentHomeBinding _binding;
    @javax.inject.Inject()
    public com.quickbite.app.di.ViewModelFactory viewModelFactory;
    private com.quickbite.app.viewmodels.HomeViewModel homeViewModel;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.ui.home.CategoryAdapter categoryAdapter = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.ui.home.MealAdapter featuredAdapter = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.ui.home.MealAdapter searchResultsAdapter = null;
    
    public HomeFragment() {
        super();
    }
    
    private final com.quickbite.app.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.di.ViewModelFactory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.di.ViewModelFactory p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerViews() {
    }
    
    private final void setupSearchBar() {
    }
    
    private final void setupSwipeRefresh() {
    }
    
    private final void setupObservers() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}