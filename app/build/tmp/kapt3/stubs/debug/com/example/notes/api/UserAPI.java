package com.example.notes.api;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/example/notes/api/UserAPI;", "", "signin", "Lretrofit2/Response;", "Lcom/example/notes/models/UserResponse;", "userRequest", "Lcom/example/notes/models/UserRequest;", "(Lcom/example/notes/models/UserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signup", "app_debug"})
public abstract interface UserAPI {
    
    @retrofit2.http.POST(value = "/users/signup")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signup(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.notes.models.UserRequest userRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.notes.models.UserResponse>> $completion);
    
    @retrofit2.http.POST(value = "/users/signin")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signin(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.notes.models.UserRequest userRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.notes.models.UserResponse>> $completion);
}