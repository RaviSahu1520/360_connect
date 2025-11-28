package com.company.app.data.remote.llm;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0096@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/company/app/data/remote/llm/AnthropicLLMEngine;", "Lcom/company/app/data/remote/llm/LLMEngine;", "baseUrl", "", "apiKey", "client", "Lokhttp3/OkHttpClient;", "gson", "Lcom/google/gson/Gson;", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/OkHttpClient;Lcom/google/gson/Gson;)V", "mediaType", "Lokhttp3/MediaType;", "generateResponse", "prompt", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnthropicContent", "AnthropicMessage", "AnthropicRequest", "AnthropicResponse", "app_debug"})
public final class AnthropicLLMEngine implements com.company.app.data.remote.llm.LLMEngine {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = null;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.MediaType mediaType = null;
    
    public AnthropicLLMEngine(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object generateResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String prompt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/company/app/data/remote/llm/AnthropicLLMEngine$AnthropicContent;", "", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class AnthropicContent {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String text = null;
        
        public AnthropicContent(@org.jetbrains.annotations.Nullable()
        java.lang.String text) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getText() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicContent copy(@org.jetbrains.annotations.Nullable()
        java.lang.String text) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/company/app/data/remote/llm/AnthropicLLMEngine$AnthropicMessage;", "", "role", "", "content", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getRole", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class AnthropicMessage {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String role = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String content = null;
        
        public AnthropicMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String role, @org.jetbrains.annotations.NotNull()
        java.lang.String content) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getRole() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getContent() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicMessage copy(@org.jetbrains.annotations.NotNull()
        java.lang.String role, @org.jetbrains.annotations.NotNull()
        java.lang.String content) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/company/app/data/remote/llm/AnthropicLLMEngine$AnthropicRequest;", "", "model", "", "maxTokens", "", "messages", "", "Lcom/company/app/data/remote/llm/AnthropicLLMEngine$AnthropicMessage;", "(Ljava/lang/String;ILjava/util/List;)V", "getMaxTokens", "()I", "getMessages", "()Ljava/util/List;", "getModel", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    static final class AnthropicRequest {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String model = null;
        @com.google.gson.annotations.SerializedName(value = "max_tokens")
        private final int maxTokens = 0;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicMessage> messages = null;
        
        public AnthropicRequest(@org.jetbrains.annotations.NotNull()
        java.lang.String model, int maxTokens, @org.jetbrains.annotations.NotNull()
        java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicMessage> messages) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getModel() {
            return null;
        }
        
        public final int getMaxTokens() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicMessage> getMessages() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicMessage> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicRequest copy(@org.jetbrains.annotations.NotNull()
        java.lang.String model, int maxTokens, @org.jetbrains.annotations.NotNull()
        java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicMessage> messages) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/company/app/data/remote/llm/AnthropicLLMEngine$AnthropicResponse;", "", "content", "", "Lcom/company/app/data/remote/llm/AnthropicLLMEngine$AnthropicContent;", "(Ljava/util/List;)V", "getContent", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    static final class AnthropicResponse {
        @org.jetbrains.annotations.Nullable()
        private final java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicContent> content = null;
        
        public AnthropicResponse(@org.jetbrains.annotations.Nullable()
        java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicContent> content) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicContent> getContent() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicContent> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicResponse copy(@org.jetbrains.annotations.Nullable()
        java.util.List<com.company.app.data.remote.llm.AnthropicLLMEngine.AnthropicContent> content) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}