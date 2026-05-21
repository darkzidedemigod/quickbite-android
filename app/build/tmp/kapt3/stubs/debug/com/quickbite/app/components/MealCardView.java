package com.quickbite.app.components;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/quickbite/app/components/MealCardView;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mealImage", "Landroid/widget/ImageView;", "mealTitle", "Landroid/widget/TextView;", "mealCategory", "mealArea", "currentMeal", "Lcom/quickbite/app/data/models/Meal;", "clickListener", "Lcom/quickbite/app/components/MealCardView$OnMealClickListener;", "bind", "", "meal", "setOnMealClickListener", "listener", "OnMealClickListener", "app_debug"})
public final class MealCardView extends androidx.cardview.widget.CardView {
    @org.jetbrains.annotations.NotNull()
    private final android.widget.ImageView mealImage = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.TextView mealTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.TextView mealCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.TextView mealArea = null;
    @org.jetbrains.annotations.Nullable()
    private com.quickbite.app.data.models.Meal currentMeal;
    @org.jetbrains.annotations.Nullable()
    private com.quickbite.app.components.MealCardView.OnMealClickListener clickListener;
    
    @kotlin.jvm.JvmOverloads()
    public MealCardView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public MealCardView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public MealCardView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public final void bind(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.models.Meal meal) {
    }
    
    public final void setOnMealClickListener(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.components.MealCardView.OnMealClickListener listener) {
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006\u00c0\u0006\u0003"}, d2 = {"Lcom/quickbite/app/components/MealCardView$OnMealClickListener;", "", "onMealClick", "", "meal", "Lcom/quickbite/app/data/models/Meal;", "app_debug"})
    public static abstract interface OnMealClickListener {
        
        public abstract void onMealClick(@org.jetbrains.annotations.NotNull()
        com.quickbite.app.data.models.Meal meal);
    }
}