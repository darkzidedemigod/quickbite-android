package com.quickbite.app.ui.favorites;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018BG\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\b2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/quickbite/app/ui/favorites/FavoritesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/quickbite/app/ui/favorites/FavoritesAdapter$FavoriteViewHolder;", "favorites", "", "Lcom/quickbite/app/data/models/Meal;", "onMealClick", "Lkotlin/Function1;", "", "onRemoveClick", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "submitList", "list", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "FavoriteViewHolder", "app_debug"})
public final class FavoritesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.quickbite.app.ui.favorites.FavoritesAdapter.FavoriteViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.quickbite.app.data.models.Meal> favorites = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.jvm.functions.Function1<com.quickbite.app.data.models.Meal, kotlin.Unit> onMealClick = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.jvm.functions.Function1<com.quickbite.app.data.models.Meal, kotlin.Unit> onRemoveClick = null;
    
    public FavoritesAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.data.models.Meal> favorites, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.quickbite.app.data.models.Meal, kotlin.Unit> onMealClick, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.quickbite.app.data.models.Meal, kotlin.Unit> onRemoveClick) {
        super();
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.data.models.Meal> list) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.quickbite.app.ui.favorites.FavoritesAdapter.FavoriteViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.ui.favorites.FavoritesAdapter.FavoriteViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public FavoritesAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/quickbite/app/ui/favorites/FavoritesAdapter$FavoriteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/quickbite/app/databinding/ItemFavoriteBinding;", "<init>", "(Lcom/quickbite/app/ui/favorites/FavoritesAdapter;Lcom/quickbite/app/databinding/ItemFavoriteBinding;)V", "bind", "", "meal", "Lcom/quickbite/app/data/models/Meal;", "app_debug"})
    public final class FavoriteViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.quickbite.app.databinding.ItemFavoriteBinding binding = null;
        
        public FavoriteViewHolder(@org.jetbrains.annotations.NotNull()
        com.quickbite.app.databinding.ItemFavoriteBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.quickbite.app.data.models.Meal meal) {
        }
    }
}