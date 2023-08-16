package com.example.notes.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0002J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/notes/repository/UserRepository;", "", "userAPI", "Lcom/example/notes/api/UserAPI;", "(Lcom/example/notes/api/UserAPI;)V", "handleResponse", "Lcom/example/notes/utils/NetworkResult;", "Lcom/example/notes/models/UserResponse;", "response", "Lretrofit2/Response;", "loginUser", "userRequest", "Lcom/example/notes/models/UserRequest;", "(Lcom/example/notes/models/UserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUser", "app_debug"})
public final class UserRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.notes.api.UserAPI userAPI = null;
    
    @javax.inject.Inject
    public UserRepository(@org.jetbrains.annotations.NotNull
    com.example.notes.api.UserAPI userAPI) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object registerUser(@org.jetbrains.annotations.NotNull
    com.example.notes.models.UserRequest userRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.notes.utils.NetworkResult<com.example.notes.models.UserResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object loginUser(@org.jetbrains.annotations.NotNull
    com.example.notes.models.UserRequest userRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.notes.utils.NetworkResult<com.example.notes.models.UserResponse>> $completion) {
        return null;
    }
    
    private final com.example.notes.utils.NetworkResult<com.example.notes.models.UserResponse> handleResponse(retrofit2.Response<com.example.notes.models.UserResponse> response) {
        return null;
    }
}