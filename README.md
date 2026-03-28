# GitHub Search App

AndroidアプリからGitHubのRepository Search APIを呼び出し、結果をリスト表示するサンプルアプリケーションです。

## 概要
- **機能**: 引数で渡されたクエリ（例: "Android"）に基づき、GitHub上のリポジトリを検索して表示。
- **UI**: Jetpack Composeを使用したモダンな宣言的UI。
- **アーキテクチャ**: MVVM (ViewModel) + Repositoryパターンを意識した構成。

## 技術スタック
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose (Material 3)
- **Networking**: Retrofit / OkHttp
- **JSON Parsing**: Gson
- **Async Processing**: Kotlin Coroutines
- **Lifecycle**: ViewModel, Fragment-KTX
