package com.quickbite.app.components;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/quickbite/app/components/PrimaryButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "button", "Lcom/google/android/material/button/MaterialButton;", "progressIndicator", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "isLoading", "", "buttonText", "", "setText", "", "text", "setLoading", "loading", "setButtonEnabled", "enabled", "setOnButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnClickListener", "l", "app_debug"})
public final class PrimaryButton extends androidx.constraintlayout.widget.ConstraintLayout {
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.material.button.MaterialButton button = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.material.progressindicator.CircularProgressIndicator progressIndicator = null;
    private boolean isLoading = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String buttonText = "";
    
    @kotlin.jvm.JvmOverloads()
    public PrimaryButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public PrimaryButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public PrimaryButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public final void setText(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void setLoading(boolean loading) {
    }
    
    public final void setButtonEnabled(boolean enabled) {
    }
    
    public final void setOnButtonClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View.OnClickListener listener) {
    }
    
    @java.lang.Override()
    public void setOnClickListener(@org.jetbrains.annotations.Nullable()
    android.view.View.OnClickListener l) {
    }
}