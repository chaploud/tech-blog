# Clojure入門ガイド

Clojureは関数型プログラミング言語で、JVM上で動作します。

## 基本的なデータ型

```clojure
;; 数値
42
3.14

;; 文字列
"Hello, World!"

;; キーワード
:name
:age

;; ベクター（配列）
[1 2 3 4 5]

;; マップ（辞書）
{:name "太郎" :age 30}

;; リスト
'(1 2 3 4 5)
```

## 関数の定義と使用

```clojure
;; 関数の定義
(defn greet [name]
  (str "Hello, " name "!"))

;; 関数の呼び出し
(greet "世界")
```

## データ操作

```clojure
;; map関数を使った変換
(map inc [1 2 3 4 5])

;; filter関数を使った絞り込み
(filter even? [1 2 3 4 5 6])

;; reduce関数を使った集約
(reduce + [1 2 3 4 5])
```

## 実際に試してみよう

```clojure
(def numbers (range 1 11))

;; 偶数だけを抽出して2倍にする
(->> numbers
     (filter even?)
     (map #(* 2 %)))
```