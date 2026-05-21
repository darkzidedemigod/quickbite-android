package com.quickbite.app.ui.detail;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u0017\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJ\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/quickbite/app/ui/detail/IngredientAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/quickbite/app/ui/detail/IngredientAdapter$IngredientViewHolder;", "ingredients", "", "Lcom/quickbite/app/data/models/Ingredient;", "<init>", "(Ljava/util/List;)V", "submitList", "", "list", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "IngredientViewHolder", "app_debug"})
public final class IngredientAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.quickbite.app.ui.detail.IngredientAdapter.IngredientViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.quickbite.app.data.models.Ingredient> ingredients = null;
    
    public IngredientAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.data.models.Ingredient> ingredients) {
        super();
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.data.models.Ingredient> list) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.quickbite.app.ui.detail.IngredientAdapter.IngredientViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.ui.detail.IngredientAdapter.IngredientViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public IngredientAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/quickbite/app/ui/detail/IngredientAdapter$IngredientViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/quickbite/app/databinding/ItemIngredientBinding;", "<init>", "(Lcom/quickbite/app/ui/detail/IngredientAdapter;Lcom/quickbite/app/databinding/ItemIngredientBinding;)V", "bind", "", "ingredient", "Lcom/quickbite/app/data/models/Ingredient;", "app_debug"})
    public final class IngredientViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.quickbite.app.databinding.ItemIngredientBinding binding = null;
        
        public IngredientViewHolder(@org.jetbrains.annotations.NotNull()
        com.quickbite.app.databinding.ItemIngredientBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.quickbite.app.data.models.Ingredient ingredient) {
        }
    }
}