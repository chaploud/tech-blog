# chaploud Dev Notes

GitHub Pages 技術ブログ

## 技術スタック

- [Clerk](https://github.com/nextjournal/clerk) - Clojureの実行可能ノートブック生成ライブラリ
- GitHub Pages - 静的サイトホスティング
- GitHub Actions - 自動デプロイ

## 内容

- Clojure/ClojureScript/ClojureDartの知識
- Clojureのライブラリやツールの紹介
- 一般的な技術記事

## 特徴

- 静的ページの生成
- 開発環境では実際にコードを動かせる
- GitHub Actionsによる自動デプロイ

## 開発環境のセットアップ

### 必要な環境
- Java 17以上
- Clojure CLI

### 開発サーバーの起動

```bash
# 開発サーバーを起動（ブラウザで自動的に開く）
clojure -M:dev

# または、REPLで手動起動
clojure -M:dev
# REPLで: (require 'user) (user/start-dev)
```

開発サーバーが起動すると、`notebooks/`ディレクトリ内のファイルの変更を監視し、リアルタイムでプレビューが更新されます。

#### WSL2でのアクセス方法

**Windows側のブラウザからアクセスする場合**:

1. **localhost経由** (通常はこれで動作): http://localhost:7777
2. **WSL2のIPアドレス経由**:
   ```bash
   # WSL2のIPアドレスを確認
   ip addr show eth0 | grep "inet\b" | awk '{print $2}' | cut -d/ -f1
   ```
   表示されたIPアドレスを使用: http://[WSL2のIP]:7777

3. **Windowsのホスト名経由**:
   ```bash
   # PowerShellで確認
   # wsl --list --verbose
   # そして http://[コンピューター名].local:7777
   ```

### 静的サイトのビルド

```bash
# 静的サイトをpublicディレクトリに生成
clojure -M:static
```

## 記事の投稿方法

### 1. 新しい記事の作成

`notebooks/` ディレクトリに新しいファイルを作成します：

- **Clojureファイル (.clj)**: インタラクティブなコードと説明を含む記事
- **Markdownファイル (.md)**: 主に文章中心の記事（コードブロック内でClojureコードも実行可能）

### 2. Clojureファイルの例

```clojure
^{:nextjournal.clerk/visibility :hide-ns}
(ns notebooks.my-article
  (:require [nextjournal.clerk :as clerk]))

;; # 記事タイトル
;;
;; 記事の説明文

;; ## セクション1

(+ 1 2 3)

;; ## データ可視化

(clerk/plotly
  {:data [{:x (range 10)
           :y (map #(* % %) (range 10))
           :type "scatter"}]
   :layout {:title "Sample Plot"}})
```

### 3. Markdownファイルの例

```markdown
# 記事タイトル

記事の説明文

## セクション1

```clojure
(+ 1 2 3)
```

このMarkdown内のClojureコードも実行されます。
```

### 4. 記事の公開手順

1. `notebooks/` に新しい記事ファイルを作成
2. ローカルで開発サーバーを起動して内容を確認
3. Git コミット・プッシュ
4. GitHub Actions が自動的に静的サイトをビルドしてGitHub Pagesにデプロイ

### 5. ディレクトリ構造

```
tech-blog/
├── notebooks/           # 記事ファイル
│   ├── hello-world.clj
│   └── intro-to-clojure.md
├── dev/
│   └── user.clj         # 開発環境設定
├── .github/
│   └── workflows/
│       └── deploy.yml   # GitHub Actions設定
├── deps.edn            # Clojure依存関係
└── README.md
```

## GitHub Pages設定

1. リポジトリの Settings > Pages
2. Source を "GitHub Actions" に設定
3. mainブランチにプッシュすると自動的にデプロイが実行されます

## トラブルシューティング

### よくある問題

- **namespaceエラー**: Clojureファイルのnamespaceはファイルパスと一致させてください
  - 例: `notebooks/my-article.clj` → `(ns notebooks.my-article)`

- **依存関係エラー**: 新しいライブラリを使用する場合は `deps.edn` に追加してください

- **デプロイエラー**: GitHub Actions のログを確認し、ビルドエラーを修正してください