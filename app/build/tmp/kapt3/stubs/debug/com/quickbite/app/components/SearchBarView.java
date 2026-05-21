package com.quickbite.app.components;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001a\u001a\u00020\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u000e\u001a\u0015\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f\u00a2\u0006\u0002\b\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/quickbite/app/components/SearchBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "searchInput", "Lcom/google/android/material/textfield/TextInputEditText;", "searchLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "searchSubject", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "getSearchObservable", "Lio/reactivex/rxjava3/core/Observable;", "setHint", "", "hint", "hintResId", "getText", "clear", "app_debug"})
public final class SearchBarView extends androidx.constraintlayout.widget.ConstraintLayout {
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.material.textfield.TextInputEditText searchInput = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.material.textfield.TextInputLayout searchLayout = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.rxjava3.subjects.PublishSubject<java.lang.String> searchSubject = null;
    
    @kotlin.jvm.JvmOverloads()
    public SearchBarView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public SearchBarView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public SearchBarView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.rxjava3.core.Observable<java.lang.String> getSearchObservable() {
        return null;
    }
    
    public final void setHint(@org.jetbrains.annotations.NotNull()
    java.lang.String hint) {
    }
    
    public final void setHint(@androidx.annotation.StringRes()
    int hintResId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getText() {
        return null;
    }
    
    public final void clear() {
    }
}