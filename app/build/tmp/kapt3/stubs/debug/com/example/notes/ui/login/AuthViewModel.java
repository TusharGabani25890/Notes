package com.example.notes.ui.login;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/example/notes/ui/login/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/example/notes/repository/UserRepository;", "(Lcom/example/notes/repository/UserRepository;)V", "_userResponseMutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/notes/utils/NetworkResult;", "Lcom/example/notes/models/UserResponse;", "userResponseLiveData", "Landroidx/lifecycle/LiveData;", "getUserResponseLiveData", "()Landroidx/lifecycle/LiveData;", "loginUser", "", "userRequest", "Lcom/example/notes/models/UserRequest;", "registerUser", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.notes.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.example.notes.utils.NetworkResult<com.example.notes.models.UserResponse>> _userResponseMutableLiveData = null;
    
    @javax.inject.Inject
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.example.notes.repository.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.notes.utils.NetworkResult<com.example.notes.models.UserResponse>> getUserResponseLiveData() {
        return null;
    }
    
    public final void registerUser(@org.jetbrains.annotations.NotNull
    com.example.notes.models.UserRequest userRequest) {
    }
    
    public final void loginUser(@org.jetbrains.annotations.NotNull
    com.example.notes.models.UserRequest userRequest) {
    }
}