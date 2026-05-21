package com.quickbite.app.data.remote;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/quickbite/app/data/remote/ApiEndpoints;", "", "<init>", "()V", "BASE_URL", "", "CATEGORIES", "SEARCH", "app_debug"})
public final class ApiEndpoints {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CATEGORIES = "categories.php";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SEARCH = "search.php";
    @org.jetbrains.annotations.NotNull()
    public static final com.quickbite.app.data.remote.ApiEndpoints INSTANCE = null;
    
    private ApiEndpoints() {
        super();
    }
}